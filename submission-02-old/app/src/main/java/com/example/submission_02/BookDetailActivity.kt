package com.example.submission_02

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.submission_02.databinding.ActivityBookDetailBinding


class BookDetailActivity : AppCompatActivity() {

    private lateinit var bind: ActivityBookDetailBinding

    companion object {
        const val EXTRA_BOOK = "extra_book"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_book_detail)

        val book = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra<Book>(EXTRA_BOOK, Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Book>(EXTRA_BOOK)
        }
        Log.d("Rucci", book.toString())
        if (book != null) {
            bind.ivBookImage.setImageResource(book.image)
            bind.tvBookTitle.text = book.title
            bind.tvBookDescription.text = book.description
        }
    }
}