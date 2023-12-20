package com.example.submission_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission_02.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var bind : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.profileImage.setImageResource(R.drawable.my_profile)
        bind.tvProfileFullName.text = resources.getString(R.string.full_name)
        bind.tvProfileEmail.text = resources.getString(R.string.email)
        actionBar?.title = resources.getString(R.string.profile)
        supportActionBar?.title = resources.getString(R.string.profile)
    }
}