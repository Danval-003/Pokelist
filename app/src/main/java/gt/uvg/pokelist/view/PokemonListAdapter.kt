package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private var pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {


    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PokemonListHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val item = pokemonList[position]
        item.id=position+1
        holder.binding.pokemonName.text=item.name
        holder.itemView.setOnClickListener {
            var bundle = bundleOf("pokemonId" to item.id)
            holder.itemView.findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
        Picasso.get()
            .load(item.imageUrlFront)
            .placeholder(androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .error(androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .into(holder.binding.pokemonPhoto)

    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

}