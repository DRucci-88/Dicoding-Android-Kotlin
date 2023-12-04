package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bind: ActivityMainBinding

//    private lateinit var btnMoveActivity: Button
//    private lateinit var btnMoveActivityWithData: Button
//    private lateinit var btnMoveActivityWithObject: Button
//    private lateinit var btnDialPhone: Button
//    private lateinit var btnMoveActivityForResult: Button
//    private lateinit var tvResult: TextView
    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == ChooseNumberActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(ChooseNumberActivity.EXTRA_SELECTED_VALUE, 0)
//            tvResult.text = "Hasil : $selectedValue"
            bind.tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

//        btnMoveActivity = findViewById(R.id.btn_move_activity)
//        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data)
//        btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_object)
//        btnDialPhone = findViewById(R.id.btn_dial_number)
//        btnMoveActivityForResult = findViewById(R.id.btn_move_for_result)
//        tvResult = findViewById(R.id.tv_result)
//
//        btnMoveActivity.setOnClickListener(this)
//        btnMoveActivityWithData.setOnClickListener(this)
//        btnMoveActivityWithObject.setOnClickListener(this)
//        btnDialPhone.setOnClickListener(this)
//        btnMoveActivityForResult.setOnClickListener(this)

        bind.btnMoveActivity.setOnClickListener(this)
        bind.btnMoveActivityData.setOnClickListener(this)
        bind.btnMoveActivityObject.setOnClickListener(this)
        bind.btnDialNumber.setOnClickListener(this)
        bind.btnMoveForResult.setOnClickListener(this)

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
            R.id.btn_dial_number -> {
                val phoneNumber = "0895330757096"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phoneNumber}"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, ChooseNumberActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}