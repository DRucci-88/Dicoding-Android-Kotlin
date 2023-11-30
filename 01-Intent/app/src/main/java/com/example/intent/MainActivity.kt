package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityWithData: Button
    private lateinit var btnMoveActivityWithObject: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_object)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_move_activity -> {
                val moveToCalculator = Intent(this@MainActivity, CalculatorActivity::class.java)
                startActivity(moveToCalculator)
            }
            R.id.btn_move_activity_data -> {
                val moveToCalculatorWithData =
                    Intent(this@MainActivity, CalculatorActivity::class.java)
                moveToCalculatorWithData.putExtra(CalculatorActivity.EDIT_WIDTH, 50.9)
                moveToCalculatorWithData.putExtra(CalculatorActivity.EDIT_HEIGHT, 11.7)
                moveToCalculatorWithData.putExtra(CalculatorActivity.EDIT_LENGTH, 23.1)
                startActivity(moveToCalculatorWithData)
            }
            R.id.btn_move_activity_object -> {
                val moveToPersonDetailWithObject =
                    Intent(this@MainActivity, PersonDetailActivity::class.java)
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )
                val persons = ArrayList<Person>()
                persons.add(person)
                persons.add(Person("Rucci", 10,"rucci@gmail.com", "Bekasi"))
                persons.add(Person("le", 13, "le@gmail.com", "Bandung"))

                moveToPersonDetailWithObject.putExtra(PersonDetailActivity.PERSON_DETAIL, person)
                moveToPersonDetailWithObject.putParcelableArrayListExtra(PersonDetailActivity.PERSON_DETAIL_ARRAY, persons)

                startActivity(moveToPersonDetailWithObject)
            }
        }
    }
}