package gt.uvg.pokelist.repository

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.model.PokeResponse
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.view.MainFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.reflect.KProperty

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object API {
    val retrofitService : PokeInterface by lazy {
        retrofit.create(PokeInterface::class.java)
    }
}


class PokemonRepository {




    // Obtain pokemon list from https://pokeapi.co/
    fun getPokemonList(): List<Pokemon> {
        return listOf(
            Pokemon(1, "bulbasaur",""),
            Pokemon(2, "ivysaur",""),
            Pokemon(3, "venusaur",""),
            Pokemon(4, "charmander",""),
            Pokemon(5, "charmeleon",""),
            Pokemon(6, "charizard",""),
            Pokemon(7, "squirtle",""),
            Pokemon(8 , "wartortle",""),
            Pokemon(9, "blastoise",""),
            Pokemon(10,"caterpie","")
        )
    }





}

