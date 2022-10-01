package gt.uvg.pokelist.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

