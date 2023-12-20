package com.example.submission_02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission_02.databinding.ItemListBookBinding

class ListBookAdapter(
    private val listBook: ArrayList<Book>
) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    private lateinit var onItemCallback: OnItemCallback

    fun setOnItemCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }

    class ListViewHolder(val bind: ItemListBookBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val bind = ItemListBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(bind)
    }

    override fun getItemCount(): Int = listBook.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, image) = listBook[position]
        holder.bind.tvItemBookTitle.text = title
        holder.bind.tvItemBookDescription.text = description.substring(0, 32).plus("...")
        holder.bind.ivItemBookImage.setImageResource(image)
        holder.itemView.setOnClickListener {
            onItemCallback.onItemClick(listBook[position])
        }
    }

    interface OnItemCallback{
        fun onItemClick(book: Book)
    }
}