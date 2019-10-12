package me.shuza.textrecognization.Rutas

class Paradas(_nombre: String, _listadoRutasAsociadas: ArrayList<String>) {

    private var mNombreParada: String = _nombre

    private var mListadoRutas: ArrayList<String> = _listadoRutasAsociadas

    fun getNombreParada(): String {
        return mNombreParada
    }

    fun getRutas(): ArrayList<String>{
        return mListadoRutas
    }
}