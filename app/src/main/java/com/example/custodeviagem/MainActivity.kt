package com.example.custodeviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import com.example.custodeviagem.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(), View.OnClickListener {
    private lateinit var bindging: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindging.root)

        bindging.buttonCalculate.setOnClickListener(this)
    }

    private fun calculate() {

        var totalValue : Float = 0f
        if(isValid()){
            val distancy = bindging.editDistancy.text.toString().toFloat()
            val price  = bindging.editPrice.text.toString().toFloat()
            val autonomy = bindging.editAutonomy.text.toString().toFloat()

            totalValue = (distancy * price) / autonomy
            bindging.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }else{ Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()}
    }

    private fun isValid() : Boolean{
        return (bindging.editDistancy.text.toString() != "" &&
                bindging.editPrice.text.toString() != "" &&
                bindging.editAutonomy.text.toString() != "" &&
                bindging.editAutonomy.text.toString().toFloat() != 0f)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate){
            calculate()
        }
    }
}