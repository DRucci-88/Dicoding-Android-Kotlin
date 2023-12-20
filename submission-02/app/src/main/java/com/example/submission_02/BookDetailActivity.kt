package com.example.submission_02

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission_02.databinding.ActivityBookDetailBinding

class BookDetailActivity : AppCompatActivity() {

    private lateinit var bind: ActivityBookDetailBinding

    companion object{
        val EXTRA_BOOK = "extra_book"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val book = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_BOOK, Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_BOOK)
        }

        if (book != null){
            bind.tvBookTitle.text = book.title
            bind.tvBookDescription.text = book.description
            bind.ivBookImage.setImageResource(book.image)
        }
        actionBar?.title = book?.title ?: "Error Title"
        supportActionBar?.title = book?.title ?: "Error Title"
    }
}