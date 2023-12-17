package com.example.submission_02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission_02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private val listBook = ArrayList<Book>()
    private lateinit var rvBookList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        listBook.addAll(getAllListBook)
        Log.d("Rucci", listBook.map { it.title.toString() }.toString())

        rvBookList = findViewById(R.id.rv_book_list)
        showRecycleList()
    }

    private val getAllListBook: ArrayList<Book>
        @SuppressLint("Recycle")
        get() {
            val loremIpsumPlaceholder = resources.getString(R.string.lorem_ipsum_placeholder)
            val bookChildrenList = resources.obtainTypedArray(R.array.book_children_image_list)
            val bookFictionList = resources.obtainTypedArray(R.array.book_fiction_image_list)
            val bookTopList = resources.obtainTypedArray(R.array.book_top_image_list)
            val listBook = ArrayList<Book>()
            for (i in 0..<bookChildrenList.length()) {
                listBook.add(
                    Book(
                        "Children ${i + 1}",
                        loremIpsumPlaceholder,
                        bookChildrenList.getResourceId(i, -1)
//                        R.drawable.children_1
                    )
                )
            }
            for (i in 0..<bookFictionList.length()) {
                listBook.add(
                    Book("Fiction ${i+1}",loremIpsumPlaceholder,bookFictionList.getResourceId(i, -1))
                )
            }
            for (i in 0..<bookTopList.length()) {
                listBook.add(
                    Book("Top ${i+1}",loremIpsumPlaceholder,bookTopList.getResourceId(i, -1))
                )
            }
            bookChildrenList.recycle()
            bookFictionList.recycle()
            bookTopList.recycle()
            return listBook
        }

    private fun showRecycleList() {
        val listBookAdapter = ListBookAdapter(listBook)

//        bind.rvBookList.layoutManager = LinearLayoutManager(this)
//        bind.rvBookList.adapter = listBookAdapter

        rvBookList.layoutManager = LinearLayoutManager(this)
        rvBookList.adapter = listBookAdapter
    }
}