package com.example.supanatj.layout1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ImageButton myImgBtn;
    private CheckBox myCheckBox;
    private RadioButton myMaleRadio;
    private RadioButton myFemaleRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout2);

        myImgBtn = findViewById(R.id.myImgBtn);
        myCheckBox = findViewById(R.id.myCheckBox);
        myMaleRadio = findViewById(R.id.myRadioMale);
        myFemaleRadio = findViewById(R.id.myRadioFemale);

        myImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });

        myCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(myCheckBox.isChecked())
                {
                    Toast.makeText(MainActivity.this,"Checked!",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(MainActivity.this,"Unchecked!",Toast.LENGTH_SHORT).show();
                }


            }
        });


        myMaleRadio.setOnClickListener(radioListener);
        myFemaleRadio.setOnClickListener(radioListener);



    }



    private View.OnClickListener radioListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RadioButton radioButton = (RadioButton)v;
            Toast.makeText(MainActivity.this,radioButton.getText().toString(),Toast.LENGTH_SHORT).show();

        }
    };
}
