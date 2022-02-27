package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTip(.15)
            Toast.makeText(this,"Propina de 15%", Toast.LENGTH_LONG).show()
        }
        binding.button20.setOnClickListener {
            interfaceCalculateTip(.20)
            Toast.makeText(this,"Propina de 20%", Toast.LENGTH_LONG).show()
        }
        binding.button35.setOnClickListener {
            interfaceCalculateTip(.35)
            Toast.makeText(this,"Propina de 35%", Toast.LENGTH_LONG).show()
        }
        binding.bredondeo.setOnClickListener {

            redondeo()
        }
    }


    private fun interfaceCalculateTip(percetange:Double){
        val amount = binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()

        if (amountValue == null){
            binding.totalTip.text="0.0"
            binding.totalAmount.text="0.0"
            return
        }
        if(amountValue == 0.0 || amountValue < 0){Toast.makeText(this,"Tas bien wey como vas a dar propina de 0 mongol", Toast.LENGTH_LONG).show()}
        binding.totalTip.text="${ amountValue * percetange}"
        binding.totalAmount.text="${amountValue * (1 + percetange)}"
    }

    private fun redondeo(){
        var redondeo_tip = binding.totalTip.text.toString()
        var red_bueno_tip = redondeo_tip.toDoubleOrNull()
        var redondeo_total = binding.totalAmount.text.toString()
        var red_bueno_total = redondeo_total.toDoubleOrNull()

        if (red_bueno_total == null||red_bueno_tip == null){
            return
        }
        red_bueno_tip = round(red_bueno_tip)
        binding.totalTip.text="${red_bueno_tip}"
        red_bueno_total = round(red_bueno_total)
        binding.totalAmount.text="${red_bueno_total}"
    }
}