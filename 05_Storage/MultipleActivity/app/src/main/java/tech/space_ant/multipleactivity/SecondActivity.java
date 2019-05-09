package tech.space_ant.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private  int sum =0;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        tvResult = findViewById(R.id.tvResult);



        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("student");
        int id = bundle.getInt("id");
        String name = bundle.getString("name");
        Double gpa = bundle.getDouble("gpa");
        tvResult.setText(id+" "+name+" "+gpa);

    }
}
