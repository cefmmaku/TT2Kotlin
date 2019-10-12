package me.shuza.textrecognization.Rutas

import android.util.Log

class Data {

    private lateinit var mListadoParadas: ArrayList<Paradas>

    private val tripleRuta: ArrayList<String> = arrayListOf("Politécnico - Cuautitlan Izcalli Infonavit Norte", "Politécnico - Monte Maria", "Politécnico - Temoaya")
    private val dobleRutaPoliCuautiMonte: ArrayList<String> = arrayListOf("Politécnico - Cuautitlan Izcalli Infonavit Norte", "Politécnico - Monte Maria")
    private val dobleRutaPoliIxtacalaTemoaya: ArrayList<String> = arrayListOf("Politécnico - San Juan Ixtacala", "Politécnico - Temoaya")
    private val rutaPoliCuautitlan: ArrayList<String> = arrayListOf("Politécnico - Cuautitlan Izcalli Infonavit Norte")
    private val rutaPoliMonteMaria: ArrayList<String> = arrayListOf("Politécnico - Monte Maria")
    private val rutaPoliIxtacala: ArrayList<String> = arrayListOf("Politécnico - San Juan Ixtacala")
    private val rutaPoliTemoaya: ArrayList<String> = arrayListOf("Politécnico - Temoaya")


    fun initData(){
        mListadoParadas = ArrayList()
        mListadoParadas.addAll(
                listOf(
                        Paradas("", tripleRuta)
                        ,Paradas("tenayucan", tripleRuta)
                        ,Paradas("ceylan", tripleRuta)
                        ,Paradas("tabla", dobleRutaPoliCuautiMonte)
                        ,Paradas("honda", dobleRutaPoliCuautiMonte)
                        ,Paradas("recuerdo", tripleRuta)
                        ,Paradas("jardines", tripleRuta)
                        ,Paradas("tequex", dobleRutaPoliCuautiMonte)
                        ,Paradas("perinorte", dobleRutaPoliCuautiMonte)
                        ,Paradas("lecheria", dobleRutaPoliCuautiMonte)
                        ,Paradas("bacardi", dobleRutaPoliCuautiMonte)
                        ,Paradas("dhl", dobleRutaPoliCuautiMonte)
                        ,Paradas("ford", dobleRutaPoliCuautiMonte)
                        ,Paradas("koblens", dobleRutaPoliCuautiMonte)
                        ,Paradas("infonavit", rutaPoliCuautitlan)
                        ,Paradas("norte", rutaPoliCuautitlan)
                        ,Paradas("cuautitlan", rutaPoliCuautitlan)
                        ,Paradas("soriana", rutaPoliCuautitlan)
                        ,Paradas("mega", rutaPoliCuautitlan)
                        ,Paradas("alamos", rutaPoliCuautitlan)
                        ,Paradas("monte", rutaPoliMonteMaria)
                        ,Paradas("maria", rutaPoliMonteMaria)
                        ,Paradas("lago", rutaPoliMonteMaria)
                        ,Paradas("autopista", rutaPoliMonteMaria)
                        ,Paradas("recuerdo", rutaPoliMonteMaria)
                        ,Paradas("nicolas", rutaPoliMonteMaria)
                        ,Paradas("romero", rutaPoliMonteMaria)
                        ,Paradas("isidro", rutaPoliMonteMaria)
                        ,Paradas("maria", rutaPoliMonteMaria)
                        ,Paradas("patera", rutaPoliIxtacala)
                        ,Paradas("torres", rutaPoliIxtacala)
                        ,Paradas("perlillar", rutaPoliIxtacala)
                        ,Paradas("san", rutaPoliIxtacala)
                        ,Paradas("juan", rutaPoliIxtacala)
                        ,Paradas("ixtacala", rutaPoliIxtacala)
                        ,Paradas("comandancia", rutaPoliIxtacala)
                        ,Paradas("santa", dobleRutaPoliIxtacalaTemoaya)
                        ,Paradas("rosa", dobleRutaPoliIxtacalaTemoaya)
                        ,Paradas("vallejo", rutaPoliTemoaya)
                        ,Paradas("covadonga", rutaPoliTemoaya)
                )
        )
    }

    fun compareData(_textoExtraido: ArrayList<String>){
       for(i in 0 until _textoExtraido.size){
            Log.d("Paradas", _textoExtraido[i])
       }
    }

    fun separaParadas(_textoExtraido: String): ArrayList<String>{

        var mListadoParadasExtraidas: ArrayList<String> = ArrayList()
        var tempParada: String? = null
        for(i in 0 until _textoExtraido.length){
            val c: Char = _textoExtraido[i]
            if(c.equals(" ")){
                mListadoParadasExtraidas.add(tempParada!!)
                tempParada = ""
            }
            else{
                tempParada += c
            }
        }

        return mListadoParadasExtraidas
    }
}