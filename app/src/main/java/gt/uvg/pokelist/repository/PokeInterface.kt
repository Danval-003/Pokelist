package gt.uvg.pokelist.repository

import gt.uvg.pokelist.model.PokeResponse
import retrofit2.Call
import retrofit2.http.*

interface PokeInterface{
    @GET("pokemon?limit=100")
    fun getFirst100Pokemon(): Call<PokeResponse>
}
