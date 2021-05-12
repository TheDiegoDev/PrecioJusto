package diego.guinea.preciojusto.ui.presenter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import diego.guinea.preciojusto.R
import diego.guinea.preciojusto.data.modelo.AlphaChar
import diego.guinea.preciojusto.ui.gameLevels.ChoseGame
import diego.guinea.preciojusto.ui.gamePage.GamePage


class AlphaAdapters(var context: Context, var arrayList: ArrayList<AlphaChar>) : RecyclerView.Adapter<AlphaAdapters.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
     val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var alphaChar: AlphaChar = arrayList[position]

        alphaChar.iconChar?.let { holder.icons.setImageResource(it) }
        holder.alphas.text = alphaChar.alphaChar

        holder.icons.setOnClickListener{
            val intent = Intent(context, GamePage::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("onoff", ChoseGame().songOffOn)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.image_cardView)
        var alphas = itemView.findViewById<TextView>(R.id.text_tituloCardView)
    }
}