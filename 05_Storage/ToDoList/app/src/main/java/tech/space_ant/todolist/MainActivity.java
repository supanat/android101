package tech.space_ant.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private ArrayList<String> toDoItems;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;

    private Button btnAdd;
    private EditText edtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Inflate

        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        edtMessage = findViewById(R.id.edtMessage);

        toDoItems = new ArrayList<>(); //instantiate
        arrayAdapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,toDoItems);

        listView.setAdapter(arrayAdapter);

        //toDoItems.add("hello");
        /*
        for (int i=0;i<30;i++){
            String item = "Hello "+i;
            toDoItems.add(item);
        }
        */

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem(edtMessage.getText().toString());
                hideKeyboard(v);

            }
        });


        edtMessage.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {



                if (keyCode == KeyEvent.KEYCODE_ENTER
                        && event.getAction() == KeyEvent.ACTION_DOWN){


                   addItem(edtMessage.getText().toString());
                   hideKeyboard(v);

                }

                return false;
            }
        });





    }


    private void hideKeyboard(View v){

        InputMethodManager inputMethodManager =
                (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    private void addItem(String item){


        if (TextUtils.isEmpty(item)==false){

            //toDoItems.add(edtMessage.getText().toString());
            toDoItems.add(0,edtMessage.getText().toString());
            arrayAdapter.notifyDataSetChanged();
            edtMessage.setText("");

        }
    }

}
