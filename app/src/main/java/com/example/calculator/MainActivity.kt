package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    val sin1 = "+"
    val sin2 = "-"
    val sin3 = "*"
    val sin4 = "/"


    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        supportActionBar?.hide()
        ///Num
        bindingClass.textView1.setOnClickListener{ setTextFields("1") }

        bindingClass.textView2.setOnClickListener{ setTextFields("2") }

        bindingClass.textView3.setOnClickListener{ setTextFields("3") }

        bindingClass.textView4.setOnClickListener{ setTextFields("4") }

        bindingClass.textView5.setOnClickListener{ setTextFields("5") }

        bindingClass.textView6.setOnClickListener{ setTextFields("6") }

        bindingClass.textView7.setOnClickListener{ setTextFields("7") }

        bindingClass.textView8.setOnClickListener{ setTextFields("8") }

        bindingClass.textView9.setOnClickListener{ setTextFields("9") }

        bindingClass.textView0.setOnClickListener{ setTextFields("0") }
        /// +
        bindingClass.textMu1.setOnClickListener{ setTextFields("+") }
        /// -
        bindingClass.textMu2.setOnClickListener{ setTextFields("-") }
        /// ×
        bindingClass.textMu3.setOnClickListener{ setTextFields("*") }
        /// ÷
        bindingClass.textMu4.setOnClickListener{ setTextFields("/") }
        ///Clear
        bindingClass.textClear.setOnClickListener{
            bindingClass.textResult.text = ""
            bindingClass.textStr.text = ""
        }
        ///Result
        bindingClass.textMuRav.setOnClickListener{
            try {

                val ex = ExpressionBuilder(bindingClass.textResult.text.toString()).build()
                val result = ex.evaluate()

                val resultLong = result.toLong()
                if (result == resultLong.toDouble()){
                    bindingClass.textResult.text = resultLong.toString()
                }
                else{
                    bindingClass.textResult.text = result.toString()
                }
            } catch (e:Exception) {
                Log.d("ERR", "TEXT: ${e.message}")
                bindingClass.textResult.text = ""
            }
            bindingClass.textStr.text = bindingClass.textResult.text
        }
    }
    fun setTextFields (str: String) {
        bindingClass.textResult.append(str)
        bindingClass.textStr.text = bindingClass.textResult.text
    }
}