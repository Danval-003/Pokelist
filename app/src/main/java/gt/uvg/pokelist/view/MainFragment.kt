package gt.uvg.pokelist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.PokeResponse
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainFragment: Fragment() {

    private var pokeBoolean: Boolean = false
    private lateinit var recyclerView:RecyclerView
    private var pokelist:List<Pokemon> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)
        recyclerView= view.findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar= view.findViewById<ProgressBar>(R.id.progressBar)
        recyclerView.layoutManager=LinearLayoutManager(activity)

        val button = view.findViewById<Button>(R.id.recharge)
        button.setOnClickListener {
            recyclerView.visibility=View.GONE
            progressBar.visibility=View.VISIBLE
            getFirst100Pokemon(requireContext(),progressBar)
        }
        if(!pokeBoolean){
            pokeBoolean=getFirst100Pokemon(requireContext(), progressBar)
        }else{
            if(pokelist.size >0){
                progressBar.visibility = View.GONE
                recyclerView.adapter=PokemonListAdapter(pokelist)
            }else{

                Toast.makeText(context, "ERROR, THE LIST OF POKEMON IS EMPTY", Toast.LENGTH_LONG).show()
            }
        }
        recyclerView.setHasFixedSize(true)
        return view
    }
    fun getFirst100Pokemon(context: Context, progressBar:ProgressBar):Boolean{
        API.retrofitService.getFirst100Pokemon().enqueue(object : Callback<PokeResponse> {
            override fun onResponse(
                call: Call<PokeResponse>,
                response: Response<PokeResponse>
            ) {
                pokelist= response.body()!!.results

                recyclerView.adapter=PokemonListAdapter(pokelist)

                progressBar.visibility = View.GONE
                recyclerView.visibility=View.VISIBLE
            }
            override fun onFailure(call: Call<PokeResponse>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
        return true
    }
}