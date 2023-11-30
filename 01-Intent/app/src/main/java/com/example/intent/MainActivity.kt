package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityWithData: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
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
        }
    }
}