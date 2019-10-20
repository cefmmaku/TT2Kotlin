package me.shuza.textrecognization.Rutas

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.root_view
import me.shuza.textrecognization.R
import me.shuza.textrecognization.TTS.TTSManager

class InfoActivity: AppCompatActivity(), TextToSpeech.OnInitListener {

    private var mTTS : TTSManager? = null
    private var mData : Data? = Data()

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            mTTS!!.hablar(resources.getString(R.string.ruta))
        } else {}
    }


    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.pause_button -> detenTTS()
            R.id.cuauti -> decirRuta(resources.getString(R.string.cuauti))
            R.id.maria -> decirRuta(resources.getString(R.string.maria))
            R.id.ixtacala -> decirRuta(resources.getString(R.string.ixtacala))
            R.id.temoaya -> decirRuta(resources.getString(R.string.temoaya))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_info)
        initTTS()
        initData()
        bindViews()
    }

    private fun decirRuta(_ruta: String){
        var ParadasADecir: ArrayList<String> = mData!!.obtenerParadas(_ruta)
        mTTS!!.hablar(resources.getString(R.string.la_ruta_es))
        mTTS!!.hablar(_ruta)
        mTTS!!.hablar(resources.getString(R.string.son))
        for(i in 0 until ParadasADecir.size){
            mTTS!!.hablar(ParadasADecir[i])
        }
    }

    private fun detenTTS(){
        mTTS!!.detener()
    }

    override fun onPause() {
        super.onPause()
        mTTS!!.detener()
    }

    override fun onDestroy() {
        super.onDestroy()
        mTTS!!.destruir()
    }

    private fun bindViews(){
        root_view.setOnClickListener(clickListener)
        cuauti.setOnClickListener(clickListener)
        maria.setOnClickListener(clickListener)
        temoaya.setOnClickListener(clickListener)
        ixtacala.setOnClickListener(clickListener)
        pause_button.setOnClickListener(clickListener)
    }

    private fun initTTS(){
        mTTS = TTSManager(this, applicationContext)
    }

    private fun initData(){
        mData!!.initDataUnida()
    }
}