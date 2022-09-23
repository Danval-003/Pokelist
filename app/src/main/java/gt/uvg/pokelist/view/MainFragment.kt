package gt.uvg.pokelist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.PokeResponse
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.API
import gt.uvg.pokelist.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)
        val pokedata=PokemonRepository().getPokemonList()

        val pokeadapter= PokemonListAdapter(pokedata)
        val s= getFirst100PokemonList(requireContext())
        val recycle= view.findViewById<RecyclerView>(R.id.recyclerView)

        recycle.layoutManager=LinearLayoutManager(activity)
        recycle.adapter=pokeadapter

        recycle.setHasFixedSize(true)



        return view
    }

    fun getFirst100PokemonList(context: Context):List<Pokemon>?{
        API.retrofitService.getFirst100Pokemon().enqueue(object : Callback<PokeResponse> {
            override fun onResponse(
                call: Call<PokeResponse>,
                response: Response<PokeResponse>
            ) {
                Toast.makeText(context, "FETCHED: " + response.body()!!.count, Toast.LENGTH_LONG).show()

            }
            override fun onFailure(call: Call<PokeResponse>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
        return null
    }
}