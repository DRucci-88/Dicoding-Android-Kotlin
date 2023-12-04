package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview.databinding.ItemRowHeroBinding

class ListHeroAdapter(
    private val listHero: ArrayList<Hero>
) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var bind: ItemRowHeroBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
//        return ListViewHolder(view)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.bind.tvItemName.text = name
        holder.bind.tvItemDescription.text = description
//        holder.imgPhoto.setImageResource(photo)
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .thumbnail()
            .into(holder.bind.imgItemPhoto)

        /// Inline click listener
//        holder.itemView.setOnClickListener(View.OnClickListener {
//            Toast.makeText(
//                holder.itemView.context,
//                "Kamu memilih ${listHero[holder.adapterPosition].name}",
//                Toast.LENGTH_SHORT
//            ).show()
//        })

        /// Click listener on Activity
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(hero: Hero)
    }

}

