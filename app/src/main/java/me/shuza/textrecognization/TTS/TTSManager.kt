package me.shuza.textrecognization.TTS

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

class TTSManager(_listener: TextToSpeech.OnInitListener, _contexto: Context) {

    private var contexto: Context? = _contexto

    private var listener: TextToSpeech.OnInitListener? = _listener

    private var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(contexto, listener)
    }

    fun hablar(textoAHablar: String) {
        Log.d("hablando", textoAHablar + " ")
        tts!!.language = Locale.forLanguageTag("es")
        tts!!.speak(textoAHablar, TextToSpeech.QUEUE_ADD, null,"")
    }

    fun destruir(){
        tts!!.stop()
        tts!!.shutdown()
    }

    fun detener(){
        tts!!.stop()
    }
}