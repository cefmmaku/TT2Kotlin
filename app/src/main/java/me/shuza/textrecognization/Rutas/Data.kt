package me.shuza.textrecognization.Rutas

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class Data {

    private lateinit var mListadoParadas: ArrayList<Paradas>
    private lateinit var mListadoParadasUnidas: ArrayList<Paradas>

    private val tripleRuta: ArrayList<String> = arrayListOf("Politécnico a Cuautitlán Izcalli Infonavit Norte", "Politécnico a Monte María", "Politécnico a Temoaya")
    private val dobleRutaPoliCuautiMonte: ArrayList<String> = arrayListOf("Politécnico a Cuautitlán Izcalli Infonavit Norte", "Politécnico a Monte María")
    private val dobleRutaPoliIxtacalaTemoaya: ArrayList<String> = arrayListOf("Politécnico a San Juan Ixtacala", "Politécnico a Temoaya")
    private val rutaPoliCuautitlan: ArrayList<String> = arrayListOf("Politécnico a Cuautitlán Izcalli Infonavit Norte")
    private val rutaPoliMonteMaria: ArrayList<String> = arrayListOf("Politécnico a Monte María")
    private val rutaPoliIxtacala: ArrayList<String> = arrayListOf("Politécnico a San Juan Ixtacala")
    private val rutaPoliTemoaya: ArrayList<String> = arrayListOf("Politécnico a Temoaya")
    private val rutaPoliTlane: ArrayList<String> = arrayListOf("Politécnico a Tlalnepantla")


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
                        ,Paradas("teques", dobleRutaPoliCuautiMonte)
                        ,Paradas("cementos", dobleRutaPoliCuautiMonte)
                        ,Paradas("perinorte", dobleRutaPoliCuautiMonte)
                        ,Paradas("lecheria", dobleRutaPoliCuautiMonte)
                        ,Paradas("bacardi", dobleRutaPoliCuautiMonte)
                        ,Paradas("dhl", dobleRutaPoliCuautiMonte)
                        ,Paradas("ford", dobleRutaPoliCuautiMonte)
                        ,Paradas("koblenz", dobleRutaPoliCuautiMonte)
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
                        ,Paradas("Gustavo", rutaPoliTlane)
                        ,Paradas("baz", rutaPoliTlane)
                        ,Paradas("clinica", rutaPoliTlane)
                        ,Paradas("tlalne", rutaPoliTlane)
                        ,Paradas("tlane", rutaPoliTlane)
                        ,Paradas("lerma", rutaPoliTlane)
                        ,Paradas("barrientos", rutaPoliTlane)
                        ,Paradas("satelite", rutaPoliTlane)
                )
        )
    }

    fun initDataUnida(){
        mListadoParadasUnidas = ArrayList()
        mListadoParadasUnidas.addAll(
                listOf(
                        Paradas("Tenayucan", tripleRuta)
                        ,Paradas("Ceylán", tripleRuta)
                        ,Paradas("Tabla", dobleRutaPoliCuautiMonte)
                        ,Paradas("Honda", dobleRutaPoliCuautiMonte)
                        ,Paradas("Jardínes del Recuerdo", tripleRuta)
                        ,Paradas("Tequex", dobleRutaPoliCuautiMonte)
                        ,Paradas("Cementos", dobleRutaPoliCuautiMonte)
                        ,Paradas("Perinorte", dobleRutaPoliCuautiMonte)
                        ,Paradas("Lechería", dobleRutaPoliCuautiMonte)
                        ,Paradas("bacardí", dobleRutaPoliCuautiMonte)
                        ,Paradas("dhl", dobleRutaPoliCuautiMonte)
                        ,Paradas("ford", dobleRutaPoliCuautiMonte)
                        ,Paradas("koblenz", dobleRutaPoliCuautiMonte)
                        ,Paradas("infonavit Norte", rutaPoliCuautitlan)
                        ,Paradas("Cuautitlán Izcalli", rutaPoliCuautitlan)
                        ,Paradas("Mega Soriana", rutaPoliCuautitlan)
                        ,Paradas("Álamos", rutaPoliCuautitlan)
                        ,Paradas("Monte María", rutaPoliMonteMaria)
                        ,Paradas("lago", rutaPoliMonteMaria)
                        ,Paradas("autopista", rutaPoliMonteMaria)
                        ,Paradas("Jardínes del Recuerdo", rutaPoliMonteMaria)
                        ,Paradas("San isidro", rutaPoliMonteMaria)
                        ,Paradas("Nicolás Romero", rutaPoliMonteMaria)
                        ,Paradas("La patera", rutaPoliIxtacala)
                        ,Paradas("Las torres", rutaPoliIxtacala)
                        ,Paradas("perlillar", rutaPoliIxtacala)
                        ,Paradas("san Juan Ixtacala", rutaPoliIxtacala)
                        ,Paradas("comandancia", rutaPoliIxtacala)
                        ,Paradas("santa rosa", dobleRutaPoliIxtacalaTemoaya)
                        ,Paradas("vallejo", rutaPoliTemoaya)
                        ,Paradas("covadonga", rutaPoliTemoaya)
                        ,Paradas("Gustavo Baz", rutaPoliTlane)
                        ,Paradas("Clínica 72", rutaPoliTlane)
                        ,Paradas("Tlalnepantla", rutaPoliTlane)
                        ,Paradas("Lerma", rutaPoliTlane)
                        ,Paradas("Barrientos", rutaPoliTlane)
                        ,Paradas("Satélite", rutaPoliTlane)
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
        var indice: String
        var ruta = "Lo siento, no pude encontrar ninguna ruta asociada :("

        for (i in _listadoRutas) {
            val j = hm[i]
            hm[i] = if (j == null) 1 else j + 1
        }

        // displaying the occurrence of elements in the arraylist
        for ((key, value) in hm) {
            if (value > maxValue) {
                maxValue = value
                indice = key
                ruta = "La ruta es $indice"
            }
        }

        return ruta
    }


    fun separaParadas(_textoExtraido: String): ArrayList<String>{

        var mListadoParadasExtraidas: ArrayList<String> = ArrayList()
        var tempParada: String? = ""
        for(i in 0 until _textoExtraido.length){
            val c: Char = _textoExtraido[i]
            if(c == ' '){
                if(tempParada!!.length > 3)
                    {
                        mListadoParadasExtraidas.add(tempParada.toLowerCase(Locale.getDefault()))
                    }
                tempParada = ""
            }
            else{
                tempParada += c
            }
        }

        return mListadoParadasExtraidas
    }

    fun obtenerParadas(_ruta: String): MutableList<String>{
        val Paradas: MutableList<String> = ArrayList()
        for(i in 0 until mListadoParadasUnidas.size){
            for(j in 0 until mListadoParadasUnidas[i].getRutas().size){
                if(mListadoParadasUnidas[i].getRutas()[j].contains(_ruta)) {
                    Paradas.add(mListadoParadasUnidas[i].getNombreParada())
                }
            }
        }
        Paradas.add(Paradas.size -1, "í")
        return Paradas
    }
}