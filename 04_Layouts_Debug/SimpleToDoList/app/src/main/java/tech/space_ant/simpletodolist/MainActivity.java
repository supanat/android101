package tech.space_ant.simpletodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;
    private Button btnAdd;

    ArrayList<String> toDoItems;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        btnAdd =  findViewById(R.id.button_Add);

        toDoItems = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,toDoItems);
        listView.setAdapter(arrayAdapter);

        /*
        for(int i=0;i<10;i++){

            String item ="Item "+i;
            toDoItems.add(item);
            arrayAdapter.notifyDataSetChanged();
        }
        */

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    addItem(editText.getText().toString());
                    hideKeyboard(v);
                    return true;
                }

                return false;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem(editText.getText().toString());
                hideKeyboard(v);

            }
        });
    }



    private void hideKeyboard(View v){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
    private void addItem(String item){

        toDoItems.add(item);
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");


    }
}
