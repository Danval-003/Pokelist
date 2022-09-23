package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.Pokemon

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args: DetailFragmentArgs by navArgs()
        val view = inflater.inflate(R.layout.fragment_detail,container,false)
        val id = args.pokemonId
        val item = Pokemon(id, "","")
        putImage(item.imageUrlFront, view.findViewById<ImageView>(R.id.imageView2))
        putImage(item.imageUrlBack, view.findViewById<ImageView>(R.id.imageView3))
        putImage(item.imageUrlShinnyFront, view.findViewById<ImageView>(R.id.imageView4))
        putImage(item.imageUrlShinnyBack, view.findViewById<ImageView>(R.id.imageView5))
        return view
    }
    fun putImage(url:String, imageView: ImageView?){
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}