package com.example.submission_02

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission_02.databinding.ItemListBookBinding

class ListBookAdapter(
    private val listBook: ArrayList<Book>
) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    class ListViewHolder(val bind: ItemListBookBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val bind = ItemListBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(bind)
    }

    override fun getItemCount(): Int = listBook.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, image) = listBook[position]
        holder.bind.tvBookTitleItem.text = title
        holder.bind.tvBookDescriptionItem.text = buildString {
            append(description.substring(0, 32))
            append("...")
        }
        holder.bind.ivBookImageItem.setImageResource(image)
        Log.d(MainActivity::class.simpleName, holder.bind.tvBookTitleItem.text.toString())
        Log.d("Rucci", listBook[position].toString())
        Log.d("Rucci", holder.bind.tvBookTitleItem.toString())
    }
}