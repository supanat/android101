package tech.space_ant.todolistpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    private ToDoItem toDoItem;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        editText = (EditText)findViewById(R.id.taskText);

        Intent intent = this.getIntent();

        toDoItem = new ToDoItem();
        toDoItem.setId(intent.getIntExtra("id",-1));
        toDoItem.setTask(intent.getStringExtra("task"));

        editText.setText(toDoItem.getTask().toString());
        editText.setSelection(toDoItem.getTask().length());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {


            String editedTask = editText.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("id",toDoItem.getId());
            intent.putExtra("task", editedTask);

            setResult(RESULT_OK,intent);

            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
