package jp.techacademy.ryota.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        val val1 = inputArea1.text.toString()
        val val2 = inputArea2.text.toString()
        var result = 0.0

        if (val1.isNotEmpty() && val2.isNotEmpty()) {
            val doubleVal1: Double = val1.toDouble()
            val doubleVal2: Double = val2.toDouble()

            if (v != null) {
                when (v.id) {
                    R.id.button1 -> result = sum(doubleVal1, doubleVal2)
                    R.id.button2 -> result = difference(doubleVal1, doubleVal2)
                    R.id.button3 -> result = product(doubleVal1, doubleVal2)
                    R.id.button4 -> result = quotient(doubleVal1, doubleVal2)
                }
            }
            intent.putExtra("result", result)
            startActivity(intent)
        } else {
            if (v != null) {
                Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun sum(val1: Double, val2: Double): Double {
        return val1 + val2
    }

    private fun difference(val1: Double, val2: Double): Double {
        return val1 - val2
    }

    private fun product(val1: Double, val2: Double): Double {
        return val1 * val2
    }

    private fun quotient(val1: Double, val2: Double): Double {
        return val1 / val2
    }
}
