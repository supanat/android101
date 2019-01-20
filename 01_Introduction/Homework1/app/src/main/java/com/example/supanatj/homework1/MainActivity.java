package com.example.supanatj.homework1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtScore;
    Button btnOK;
    TextView tvGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtScore = (EditText)findViewById(R.id.edtScore);
        btnOK = (Button)findViewById(R.id.btnOK);
        tvGrade = (TextView)findViewById(R.id.tvGrade);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //edtScore.getText().toString()
                //Double score = Double.parseDouble("100.3");


                Double score = Double.parseDouble(edtScore.getText().toString());


                if (score >= 80){
                    tvGrade.setText("ได้เกรด A");
                    tvGrade.setTextColor(Color.BLUE);
                }else if(score >= 70){
                    tvGrade.setText("ได้เกรด B");
                    tvGrade.setTextColor(Color.BLUE);
                }else if(score >= 60){
                    tvGrade.setText("C");
                    tvGrade.setTextColor(Color.BLUE);
                }else if(score >= 50){
                    tvGrade.setText("ได้เกรด D");
                    tvGrade.setTextColor(Color.argb(255,255,165,0));
                }else{
                    tvGrade.setText("ได้เกรด F");
                    tvGrade.setTextColor(Color.RED);
                }



            }
        });
    }
}
