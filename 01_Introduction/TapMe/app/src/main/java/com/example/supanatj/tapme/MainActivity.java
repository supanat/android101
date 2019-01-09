package com.example.supanatj.tapme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int count = 0;


    private Button btnTap;
    private TextView tvCount;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount =  findViewById(R.id.tvCount);
        btnTap = findViewById(R.id.btnTap);

        //tvCount.setText("999");

        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                //count = count +1;

                tvCount.setText(Integer.toString(count));



            }
        });

    }
}
