package me.shuza.textrecognization.Rutas

class Paradas(var _nombre: String, var _listadoRutasAsociadas: ArrayList<String>) {

    private var mNombreParada: String = _nombre

    private var mListadoRutas: ArrayList<String> = _listadoRutasAsociadas

    private fun getNombreParada(): String {
        return mNombreParada
    }

    private fun getRutas(): ArrayList<String>{
        return mListadoRutas
    }
}