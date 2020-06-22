package tech.space_ant.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ThirdActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvMail;
    private TextView tvPhone;
    private ImageView imgTeam;

    private Button btnSubmit;

    FirebaseDatabase database ;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        tvName = findViewById(R.id.tvName);
        tvMail = findViewById(R.id.tvMail);
        tvPhone = findViewById(R.id.tvPhone);

        imgTeam = findViewById(R.id.imgTeam);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String email = intent.getStringExtra("email");
        final String phone = intent.getStringExtra("phone");
        final Integer team = intent.getIntExtra("team",-1);

        tvName.setText(name);
        tvMail.setText(email);
        tvPhone.setText(phone);

        //Toast.makeText(ThirdActivity.this,name,Toast.LENGTH_SHORT).show();

        if(team == 0)
            imgTeam.setImageResource(R.drawable.blue);

        if(team == 1)
            imgTeam.setImageResource(R.drawable.green);


         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("register");

        //DatabaseReference newRef = myRef.child("Person").push();
        //myRef.setValue(item);



        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> maps = new HashMap<>();
                maps.put("name",name);
                maps.put("team","1");
                maps.put("email",email);
                maps.put("phone",phone);
                myRef.child("user").push().setValue(maps);
            }
        });

    }
}
