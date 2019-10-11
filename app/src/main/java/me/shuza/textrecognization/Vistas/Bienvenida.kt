package me.shuza.textrecognization.Vistas

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.bienvenida.*
import me.shuza.textrecognization.MainActivity
import me.shuza.textrecognization.R
import me.shuza.textrecognization.TTS.TTSManager

class Bienvenida: AppCompatActivity(), TextToSpeech.OnInitListener  {

    private var mTTS : TTSManager? = null

    private lateinit var mRootView: ConstraintLayout

    val clickListener = View.OnClickListener {view ->

        when (view.id) {
            R.id.rootview_bienvenida -> onClickPantalla()
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            Log.d("hablando", "Success bienvenida")
            mTTS!!.hablar(resources.getString(R.string.bienvenido))
        } else {
            Log.d("hablando", "fail")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenida)
        bindViews()
        initTTS()
    }

    private fun initTTS(){
        mTTS = TTSManager(this, applicationContext)
    }

    private fun bindViews() {
        mRootView = this.rootview_bienvenida
        mRootView.setOnClickListener(clickListener)
    }

    private fun onClickPantalla() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}