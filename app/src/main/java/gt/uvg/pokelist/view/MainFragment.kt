package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.repository.PokemonRepository

class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)
        val pokedata=PokemonRepository().getPokemonList()
        val pokeadapter= PokemonListAdapter(pokedata)
        val recycle= view.findViewById<RecyclerView>(R.id.recyclerView)

        recycle.layoutManager=LinearLayoutManager(activity)
        recycle.adapter=pokeadapter

        recycle.setHasFixedSize(true)


        return view
    }
}