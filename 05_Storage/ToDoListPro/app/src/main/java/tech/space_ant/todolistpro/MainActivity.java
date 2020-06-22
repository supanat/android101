package tech.space_ant.todolistpro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private Button buttonAdd;

    private ArrayList<ToDoItem> toDoItems;
    private ArrayAdapter<ToDoItem> arrayAdapter;

    FirebaseDatabase database;
    DatabaseReference myRef;



    public static final int DETAIL_ACTIVITY_REQUEST_CODE = 1000;
    public static final int MENU_DELETE_ID = 2000;
    public static final int MENU_EDIT_ID = 2001;
    public static final int MENU_CANCEL_ID = 2002;

    private int currentItem;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        buttonAdd = (Button) findViewById(R.id.button);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");





        toDoItems = new ArrayList<>();


        for (int i=0;i<5;i++){
            ToDoItem item = new ToDoItem();
            item.setTask(i+"");
            toDoItems.add(item);
        }


        Map<String, String> map = new HashMap<String, String>();
        map.put("task", "watch tv");


        //arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,toDoItems);
        //listView.setAdapter(arrayAdapter);

        /*
        listView.setAdapter(new FirebaseListAdapter<ToDoItem>(this,
                ToDoItem.class,
                android.R.layout.two_line_list_item,
                myRef) {
            @Override
            protected void populateView(@NonNull View v, @NonNull ToDoItem model, int position) {

            }
        });
        */


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("id", 123);
                intent.putExtra("task", "test");

                startActivityForResult(intent,DETAIL_ACTIVITY_REQUEST_CODE);

            }
        });


        registerForContextMenu(listView);






        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //ToDoItem item = new ToDoItem();
                //item.setId(2);
                //item.setTask("watch tv");
                //myRef.setValue(item);

                //myRef.child("todo").push()

                //String key = myRef.child("todolist").push().getKey();

                Map<String, String> map = new HashMap<String, String>();
                map.put("task", "watch tv");
                myRef.push().setValue(map);




            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Toast.makeText(MainActivity.this,"setting",Toast.LENGTH_LONG).show();

            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.add(0,MENU_DELETE_ID,0,"Delete");
        menu.add(0,MENU_EDIT_ID,1,"Edit");
        menu.add(0,MENU_CANCEL_ID,2,"Cancel");
        currentItem = (int) contextMenuInfo.id;

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case MENU_DELETE_ID:


                break;

            case MENU_EDIT_ID:

                //Log.v("menu","select edit");

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("id", 123);
                intent.putExtra("task", "test");

                startActivityForResult(intent,DETAIL_ACTIVITY_REQUEST_CODE);

                break;

            case MENU_CANCEL_ID:


                break;
        }

        return super.onContextItemSelected(item);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Toast.makeText(MainActivity.this,data.getStringExtra("task"),Toast.LENGTH_LONG).show();
    }
}
