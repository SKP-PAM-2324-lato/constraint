package com.example.constraint

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.drink_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.acceptButton).setOnClickListener {
            val age = LocalDate.now().year - findViewById<EditText>(R.id.yearText).text.toString().toInt()
            val order = findViewById<Spinner>(R.id.spinner).selectedItem
            val check = findViewById<CheckBox>(R.id.checkbox).isChecked

            val result = findViewById<TextView>(R.id.orderText)

            if((age >= 18  && !check)|| order == "sok jabłkowy" || order == "herbata"){
                result.text = "Twoje zamówienie to: $order"
            }else{
                result.text = "Nie możesz zamówić napoju alkoholowego"
            }
        }
    }
}