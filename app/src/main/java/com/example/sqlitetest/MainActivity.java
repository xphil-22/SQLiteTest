package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    MySQLiteHelper mySQLiteHelper = null;
    int id;
    SQLiteDatabase db;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hallo", "du");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);
        mySQLiteHelper = new MySQLiteHelper(this);
        db = mySQLiteHelper.getWritableDatabase();
        id = (int) MySQLStatements.insertUserData(db, "philipp", "3dggdskhfgkfdshgla", "1");
        db = mySQLiteHelper.getWritableDatabase();
        MySQLStatements.inserSnippet(db, jsonObject);
        mySQLiteHelper.close();
        textView = findViewById(R.id.textView);

    }

    public void setUser(View view){
        String[] array;
        db = mySQLiteHelper.getWritableDatabase();
        array = MySQLStatements.getUserData(db, id);
        textView.setText(array[0] + ", " + array[1] + ", " + array[2]);
        db = mySQLiteHelper.getWritableDatabase();
        textView.setText(MySQLStatements.getSnippet(db, 1).toString());
    }
}