package diego.guinea.preciojusto.ui.presenter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.AlphaChar
import diego.guinea.preciojusto.ui.gamePage.GamePage

//Presenter de CardView en un RecyclerView para el ChoseGame

class AlphaAdapters(var context: Context, var arrayList: ArrayList<AlphaChar>) : RecyclerView.Adapter<AlphaAdapters.ItemHolder>() {

    //Enlazamos el item con el CardView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
     val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ItemHolder(itemHolder)
    }

    //Gestionamos el Recycler
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val alphaChar: AlphaChar = arrayList[position]

        alphaChar.iconChar?.let { holder.icons.setImageResource(it) }
        holder.alphas.text = alphaChar.alphaChar

        holder.icons.setOnClickListener{
            val intent = Intent(context, GamePage::class.java)
            intent.putExtra("position", position)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    //Gestionamos el CardView
    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.image_cardView)
        var alphas = itemView.findViewById<TextView>(R.id.text_tituloCardView)
    }
}