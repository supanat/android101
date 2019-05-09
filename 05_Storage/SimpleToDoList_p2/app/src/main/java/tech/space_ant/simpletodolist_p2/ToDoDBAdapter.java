package tech.space_ant.simpletodolist_p2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ToDoDBAdapter {

    private  static final int DATABASE_VERSION = 1;
    private  static  final  String DATABASE_NAME = "ToDoList.db";

    private  static  final String TABLE_NAME = "ToDoItem";
    public   static  final String KEY_ID = "id";
    public   static  final String KEY_TASK = "task";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_TASK + " TEXT NOT NULL);";

    private final Context context;


    private SQLiteDatabase db;
    private ToDoDBOpenHelper dbOpenHelper;

    public ToDoDBAdapter(Context context) {

        //this.context = context;

        //dbOpenHelper = new ToDoDBOpenHelper(context,DATABASE_NAME,
        //        null,DATABASE_VERSION);


        this.context = context;
        dbOpenHelper = new ToDoDBOpenHelper(this.context, DATABASE_NAME, null,
                DATABASE_VERSION);

    }

    public void open(){
        dbOpenHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }
    public long insertItem(String task){
        ContentValues values = new ContentValues();
        values.put(KEY_TASK,task);

        return  db.insert(TABLE_NAME,null,values);
    }

    public Cursor selectAllItems(){

        return db.query(TABLE_NAME, new String[] { KEY_ID, KEY_TASK }, null,
                null, null, null, null);
    }



    private static class ToDoDBOpenHelper extends SQLiteOpenHelper{


        public ToDoDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(SQL_CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
