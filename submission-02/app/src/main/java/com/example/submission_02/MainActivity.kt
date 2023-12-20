package com.example.submission_02

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission_02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind : ActivityMainBinding
    private val listBook = ArrayList<Book>()

    private fun init() {
        listBook.addAll(getAllListBook)
        bind.rvListBook.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(listBook)
        bind.rvListBook.adapter = listBookAdapter
        listBookAdapter.setOnItemCallback(object : ListBookAdapter.OnItemCallback {
            override fun onItemClick(book: Book) {
                val goToBookDetail = Intent(this@MainActivity, BookDetailActivity::class.java)
                goToBookDetail.putExtra(BookDetailActivity.EXTRA_BOOK, book)
                startActivity(goToBookDetail)
            }
        })
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
                    Book("Children ${i + 1}",loremIpsumPlaceholder,bookChildrenList.getResourceId(i, -1))
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        init()
    }
}