package tech.space_ant.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText edtInput1;
    private EditText getEdtInput2;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //startActivity(intent);

                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //intent.putExtra("result", 22);
                //startActivity(intent);


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Student student1 = new Student();
                student1.id = 60123;
                student1.name = "Supanat";
                student1.gpa = 3.14;

                Bundle bundle = new Bundle();
                bundle.putInt("id",student1.id);
                bundle.putString("name",student1.name);
                bundle.putDouble("gpa",student1.gpa);

                intent.putExtra("student", bundle);
                startActivity(intent);


            }
        });
    }
}
