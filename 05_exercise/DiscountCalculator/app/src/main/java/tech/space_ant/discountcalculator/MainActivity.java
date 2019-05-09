package tech.space_ant.discountcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvPrice;
    EditText edtPriceOriginal;
    EditText edtPercentOff;
    Button btnCalculate;
    CheckBox cbTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPrice = findViewById(R.id.tvPrice);
        edtPriceOriginal  = findViewById(R.id.edtPriceOriginal);
        edtPercentOff = findViewById(R.id.edtPercentOff);
        btnCalculate = findViewById(R.id.btnCalculate);
        cbTax = findViewById(R.id.cbTax);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float originalPrice = 0;
                originalPrice =  Float.parseFloat(edtPriceOriginal.getText().toString());

                float percentOff = 0;
                percentOff =  Float.parseFloat(edtPercentOff.getText().toString());



                float discount=0;
                discount = (percentOff/100)*originalPrice;

                float finalPrice=0;
                float tax=0;

                if(cbTax.isChecked())
                {
                    finalPrice=originalPrice-discount;
                    tax = (float)0.07*finalPrice;

                    finalPrice +=tax; // tax 7 %
                }
                else
                {
                    finalPrice=originalPrice-discount;
                }

                tvPrice.setText(Float.toString(finalPrice));

            }
        });

    }
}
