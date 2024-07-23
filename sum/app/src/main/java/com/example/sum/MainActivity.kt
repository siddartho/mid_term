package com.example.sum

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button: Button =  findViewById(R.id.btnSum)
        val textnum1: EditText=findViewById(R.id.edNum1)
        val textnum2: EditText=findViewById(R.id.edNum2)
        val textResult: TextView=findViewById(R.id.txtResult)
        val spiner: Spinner = findViewById(R.id.spnSelect)
        var option = arrayOf("Sum","Minus","Multiply","Division")
        var flag : String="Sum"
        spiner.adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,option)
        button.setOnClickListener {
            var x: Int = textnum1.text.toString().toInt()
            var y: Int = textnum2.text.toString().toInt()

            when (flag)
            {
                "Sum"  -> textResult.text= sum(x,y).toString()
                "Minus" -> textResult.text= min(x,y).toString()
                "Multiply"-> textResult.text= mul(x,y).toString()
                "Division"->textResult.text= div(x,y).toString()

            }




        }

    spiner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            flag = option.get(p2)
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

    }


    }
}
public  fun sum( num1 : Int,num2 : Int) :Int {
    return num1 + num2
}
public  fun min( num1 : Int,num2 : Int) :Int {
    return num1 - num2
}
public  fun mul( num1 : Int,num2 : Int) :Int {
    return num1 * num2
}
public  fun div( num1 : Int,num2 : Int) :Int {
    return num1 /num2
}