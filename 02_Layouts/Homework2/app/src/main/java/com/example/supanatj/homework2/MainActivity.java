package com.example.supanatj.homework2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button btnColor1;
    private Button btnColor2;
    private Button btnColor3;
    private Button btnColor4;
    private Button btnColor5;
    private Button btnColor6;
    private TextView tvRGB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColor1 = findViewById(R.id.btnColor1);
        btnColor2 = findViewById(R.id.btnColor2);
        btnColor3 = findViewById(R.id.btnColor3);
        btnColor4 = findViewById(R.id.btnColor4);
        btnColor5 = findViewById(R.id.btnColor5);
        btnColor6 = findViewById(R.id.btnColor6);
        tvRGB = findViewById(R.id.tvRGB);



        btnColor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRGB.setText("235-255-221");
                tvRGB.setBackgroundColor(((ColorDrawable)btnColor1.getBackground()).getColor());

            }
        });

        btnColor2.setOnClickListener(listener);
        btnColor3.setOnClickListener(listener);
        btnColor4.setOnClickListener(listener);
        btnColor5.setOnClickListener(listener);
        btnColor6.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnColor2:
                    tvRGB.setText("236-203-202");
                    tvRGB.setBackgroundColor(((ColorDrawable)btnColor2.getBackground()).getColor());
                    break;

                 case R.id.btnColor3:
                     tvRGB.setText("117-131-156");
                     tvRGB.setBackgroundColor(((ColorDrawable)btnColor3.getBackground()).getColor());
                    break;
                 case R.id.btnColor4:
                     tvRGB.setText("153-169-191");
                     tvRGB.setBackgroundColor(((ColorDrawable)btnColor4.getBackground()).getColor());
                    break;
                 case R.id.btnColor5:
                     tvRGB.setText("195-204-216");
                     tvRGB.setBackgroundColor(((ColorDrawable)btnColor5.getBackground()).getColor());
                    break;
                 case R.id.btnColor6:
                     tvRGB.setText("221-226-269");
                     tvRGB.setBackgroundColor(((ColorDrawable)btnColor6.getBackground()).getColor());
                    break;



            }
        }
    };
}
