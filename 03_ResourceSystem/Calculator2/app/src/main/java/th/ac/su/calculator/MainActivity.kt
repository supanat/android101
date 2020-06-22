package th.ac.su.calculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText1 = findViewById<EditText>(R.id.editText1)
        var editText2 = findViewById<EditText>(R.id.editText2)
        var btnCalulate = findViewById<Button>(R.id.btnCalculate)
        var tvResult = findViewById<TextView>(R.id.tvResult)

        var rgOperator = findViewById<RadioGroup>(R.id.rgOperator)

        var checkbox1 = findViewById<CheckBox>(R.id.checkbox1)

        btnCalulate.setOnClickListener {

            if (checkbox1.isChecked){


                var v1:Int = editText1.text.toString().toInt()
                var v2:Int = editText2.text.toString().toInt()
                var result = 0




                when(rgOperator.checkedRadioButtonId){
                    R.id.rbPlus-> result = v1+v2
                    R.id.rbMinus-> result = v1-v2
                    R.id.rbMultiply-> result = v1*v2
                    R.id.rbDivide-> result = v1/v2
                }


                tvResult.setText(result.toString())


            }



        }
    }


}
