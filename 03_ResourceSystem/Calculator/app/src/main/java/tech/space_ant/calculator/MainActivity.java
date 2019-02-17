package tech.space_ant.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button btnCalulate;
    Button btnClear;
    TextView tvResult;
    RadioGroup rgOperator;

    RadioButton rbPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 =  findViewById(R.id.editText2);
        tvResult = findViewById(R.id.tvResult);
        btnCalulate =  findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        rgOperator =  findViewById(R.id.rgOperator);

        rbPlus = findViewById(R.id.rbPlus);

        /*
        btnCalulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v1 = 0;
                int v2 = 0;
                int result = 0;

                v1 = Integer.parseInt(editText1.getText().toString());
                v2 = Integer.parseInt(editText2.getText().toString());
                result = v1 + v2;
                Log.d("Calculation","Result = "+result);
                Toast.makeText(MainActivity.this,"Result = "+result, Toast.LENGTH_LONG).show();
                tvResult.setText(result + "");
            }
        });
        */





        btnCalulate.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v == btnClear) {

                tvResult.setText("");
                editText1.setText("");
                editText2.setText("");

                /*
                if (rbPlus.isChecked()){
                    Toast.makeText(MainActivity.this,"Pluss is checked", Toast.LENGTH_LONG).show();
                }
                */

            }

            if (v == btnCalulate) {




                int v1 = 0;
                int v2 = 0;
                int result = 0;

                try {
                    v1 = Integer.parseInt(editText1.getText().toString());

                } catch (NumberFormatException e) {

                }

                try {
                    v2 = Integer.parseInt(editText2.getText().toString());

                } catch (NumberFormatException e) {

                }


                switch (rgOperator.getCheckedRadioButtonId()){

                    case R.id.rbPlus:
                        result = v1 + v2;
                        break;

                    case R.id.rbMinus:
                        result = v1 - v2;
                        break;

                    case R.id.rbMultiply:
                        result = v1 * v2;
                        break;

                    case R.id.rbDivide:
                        result = v1 / v2;
                        break;

                }

                tvResult.setText(result + "");

                //Log.d("Calculation","Result = "+result);

                MyHelper.LogD("Calculation","Result : "+result);

                Toast.makeText(MainActivity.this,"Result = "+result, Toast.LENGTH_LONG).show();

            }
        }
    };

}
