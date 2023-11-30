package com.example.intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.TextView
import com.example.intent.Person

class PersonDetailActivity : AppCompatActivity() {

    private lateinit var tvObject: TextView
    private lateinit var tvObjectArray: TextView

    companion object {
        const val PERSON_DETAIL = "person_detail"
        const val PERSON_DETAIL_ARRAY = "person_detail_array"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)

        tvObject = findViewById(R.id.tv_object_received)
        tvObjectArray = findViewById(R.id.tv_object_received_array)

        val person: Person? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(PERSON_DETAIL, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(PERSON_DETAIL)
        }

        val persons =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableArrayExtra(PERSON_DETAIL_ARRAY, Person::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableArrayExtra(PERSON_DETAIL_ARRAY)
            }
        @Suppress("DEPRECATION")
        intent.getParcelableArrayExtra(PERSON_DETAIL_ARRAY)?.forEach {
            Log.d("person_detail", it.toString())
        }
        Log.d("person_detail", persons.toString())

        if (person != null)
            tvObject.text = person.toString()

//        if (persons != null)
//            Log.d("person_detail", persons.toString())
        tvObjectArray.text = persons.toString()
    }
}