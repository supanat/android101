package tech.space_ant.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edtName);
        editText2 = findViewById(R.id.edtMail);
        editText3 = findViewById(R.id.edtPhone);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(editText.getText().toString()) &&
                        TextUtils.isEmpty(editText2.getText().toString())&&
                        TextUtils.isEmpty(editText3.getText().toString())){


                    return;

                }

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",editText.getText().toString());
                intent.putExtra("email",editText2.getText().toString());
                intent.putExtra("phone",editText3.getText().toString());

                startActivity(intent);
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    //hideVirtualKeyboard(v);
                }


                return false;
            }
        });

    }


    private void hideVirtualKeyboard(View v){

        InputMethodManager methodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        methodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
