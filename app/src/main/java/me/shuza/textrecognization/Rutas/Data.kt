package me.shuza.textrecognization.Rutas

import android.util.Log
import java.util.HashMap

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
                        Paradas("tenayucan", tripleRuta)
                        ,Paradas("ceylan", tripleRuta)
                        ,Paradas("tabla", dobleRutaPoliCuautiMonte)
                        ,Paradas("honda", dobleRutaPoliCuautiMonte)
                        ,Paradas("recuerdo", tripleRuta)
                        ,Paradas("jardines", tripleRuta)
                        ,Paradas("tequex", dobleRutaPoliCuautiMonte)
                        ,Paradas("cementos", dobleRutaPoliCuautiMonte)
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

    fun compareData(_textoExtraido: ArrayList<String>): ArrayList<String>{
       var mListadoRutas: ArrayList<String> = ArrayList()
       for(i in 0 until _textoExtraido.size){
           for(j in 0 until mListadoParadas.size){
               if(mListadoParadas[j].getNombreParada().contains(_textoExtraido[i]) || _textoExtraido[i].contains(mListadoParadas[j].getNombreParada())){
                    mListadoRutas.addAll(mListadoParadas[j].getRutas())
               }
           }
       }
        for(i in 0 until mListadoRutas.size){
            Log.d("Rutas", mListadoRutas[i])
        }
        return mListadoRutas
    }

    fun obtieneRuta(_listadoRutas: ArrayList<String>): String{
        val hm = HashMap<String, Int>()
        var maxValue = -1
        var indice = ""

        for (i in _listadoRutas) {
            val j = hm[i]
            hm[i] = if (j == null) 1 else j + 1
        }

        // displaying the occurrence of elements in the arraylist
        for ((key, value) in hm) {
            if (value > maxValue) {
                maxValue = value
                indice = key
            }
        }

        return "La ruta es $indice"
    }


    fun separaParadas(_textoExtraido: String): ArrayList<String>{

        var mListadoParadasExtraidas: ArrayList<String> = ArrayList()
        var tempParada: String? = null
        for(i in 0 until _textoExtraido.length){
            val c: Char = _textoExtraido[i]
            if(c == ' '){
                mListadoParadasExtraidas.add(tempParada!!.toLowerCase())
                tempParada = ""
            }
            else{
                tempParada += c
            }
        }

        return mListadoParadasExtraidas
    }
}