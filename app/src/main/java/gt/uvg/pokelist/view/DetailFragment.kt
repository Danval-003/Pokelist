package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.model.Pokemon

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailBinding.inflate(layoutInflater, container, false)
        val args: DetailFragmentArgs by navArgs()
        val view = binding.root
        val id = args.pokemonId
        val item = Pokemon(id, "","")
        putImage(item.imageUrlFront, binding.imageView2)
        putImage(item.imageUrlBack, binding.imageView3)
        putImage(item.imageUrlShinnyFront, binding.imageView4)
        putImage(item.imageUrlShinnyBack, binding.imageView5)
        return view
    }
    fun putImage(url:String, imageView: ImageView?){
        Picasso.get()
            .load(url)
            .placeholder(
                androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .error(androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .into(imageView)
    }
}