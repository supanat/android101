package tech.space_ant.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    private Button btnNext;
    private EditText editText;
    private TextView textView0;
    private TextView textView1;
    private ImageView imgBlue;

    private ImageView imgGreen;

    private int team = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String email = intent.getStringExtra("email");
        final String phone = intent.getStringExtra("phone");


        textView0 = findViewById(R.id.tv0);
        textView1 = findViewById(R.id.tv1);



        textView0.setText("Hi , "+intent.getStringExtra("name"));


        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(team == -1){
                    Toast.makeText(SecondActivity.this,"Choose your team first.",Toast.LENGTH_SHORT).show();

                    return;
                }

                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("team",team);

                startActivity(intent);

            }
        });


        imgGreen = findViewById(R.id.imgGreen);
        imgBlue = findViewById(R.id.btnBlue);

        imgGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SecondActivity.this,"green team",Toast.LENGTH_SHORT).show();
                //imgGreen.setBackgroundColor(0x595959);
                //imgBlue.setBackgroundColor(0xFFFFFF);
                textView1.setText("GREEN TEAM");
                team = 1;
            }
        });

        imgBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SecondActivity.this,"blue team",Toast.LENGTH_SHORT).show();
                //imgGreen.setBackgroundColor(0xFFFFFF);
                //imgBlue.setBackgroundColor(0x595959);
                textView1.setText("BLUE TEAM");
                team = 0;
            }
        });

    }

    private void hideVirtualKeyboard(View v){

        InputMethodManager methodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        methodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
