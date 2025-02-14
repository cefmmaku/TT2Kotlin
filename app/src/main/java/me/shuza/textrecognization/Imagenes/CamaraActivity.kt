package me.shuza.textrecognization.Imagenes

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.SurfaceHolder
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import me.shuza.textrecognization.R
import me.shuza.textrecognization.Rutas.Data
import me.shuza.textrecognization.Rutas.InfoActivity
import org.jetbrains.anko.toast
import kotlin.properties.Delegates
import me.shuza.textrecognization.TTS.*

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  28-Jun-18
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

class CamaraActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            mTTS!!.hablar(resources.getString(R.string.instrucciones))
        } else {
        }
    }

    private var mCameraSource by Delegates.notNull<CameraSource>()
    private var textRecognizer by Delegates.notNull<TextRecognizer>()
    private var mTTS : TTSManager? = null
    private var mData : Data? = Data()
    private var mTextoOCR: String = ""
    private val PERMISSION_REQUEST_CAMERA = 100
    private var camaraPermitida: Boolean = true

    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.root_view -> realizaOperaciones()
            R.id.info_button -> abreInfo()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)
        initTTS()
        initData()
        startCameraSource()
        bindViews()
    }

    private fun abreInfo(){
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
    }

    private fun bindViews(){
        root_view.setOnClickListener(clickListener)
        info_button.setOnClickListener(clickListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        mTTS!!.destruir()
    }

    override fun onPause() {
        super.onPause()
        mTTS!!.detener()
    }

    private fun initTTS(){
        mTTS = TTSManager(this, applicationContext)
    }

    private fun initData(){
        mData!!.initData()
    }

    private fun startCameraSource() {

        //  Create text Recognizer
        textRecognizer = TextRecognizer.Builder(this).build()

        if (!textRecognizer.isOperational) {
            toast("Dependencies are not loaded yet...please try after few moment!!")
            Logger.d("Dependencies are downloading....try after few moment")
            return
        }

        //  Init camera source to use high resolution and auto focus
        mCameraSource = CameraSource.Builder(applicationContext, textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setAutoFocusEnabled(true)
                .setRequestedFps(2.0f)
                .build()

        surface_camera_preview.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder?) {
                mCameraSource.stop()
            }

            @SuppressLint("MissingPermission")
            override fun surfaceCreated(p0: SurfaceHolder?) {
                try {
                    if (isCameraPermissionGranted()) {
                        mCameraSource.start(surface_camera_preview.holder)
                    } else {
                        requestForPermission()
                    }
                } catch (e: Exception) {
                    camaraPermitida = false
                    //toast("Error:  ${e.message}")
                }
            }
        })

        textRecognizer.setProcessor(object : Detector.Processor<TextBlock> {
            override fun release() {}

            override fun receiveDetections(detections: Detector.Detections<TextBlock>) {
                val items = detections.detectedItems

                if (items.size() <= 0) {
                    return
                }

                tv_result.post {
                    val stringBuilder = StringBuilder()

                    for (i in 0 until items.size()) {
                        val item = items.valueAt(i)
                        stringBuilder.append(item.value)
                        stringBuilder.append(" ")
                    }
                    mTextoOCR = stringBuilder.toString()
                }
            }
        })
    }

    private fun realizaOperaciones(){
        if(camaraPermitida){
            tv_result.text = mTextoOCR
            val rutaDefinitiva: String = mData!!.obtieneRuta(
                    mData!!.compareData(
                            mData!!.separaParadas(mTextoOCR)
                    )
            )
            mTTS!!.hablar(rutaDefinitiva)
            mTextoOCR = ""
        }
        else{
            mTTS!!.hablar(resources.getString(R.string.sin_permiso))
        }
    }


    fun isCameraPermissionGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED
    }

    private fun requestForPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST_CAMERA)
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode != PERMISSION_REQUEST_CAMERA) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            return
        }

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (isCameraPermissionGranted()) {
                mCameraSource.start(surface_camera_preview.holder)
            } else {
                camaraPermitida = false
                toast("Permission need to grant")
                finish()
            }
        }
    }
}
