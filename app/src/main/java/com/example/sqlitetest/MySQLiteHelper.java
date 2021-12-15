package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "com.example.schooltest.MyDatabase";

    public static final String SQL_CREATE_USERDATA = "CREATE TABLE " + MyContractClass.UserdataTable.TABLE_NAME + "( " +
            MyContractClass.UserdataTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MyContractClass.UserdataTable.COL_USERNAME + " TEXT ," +
            MyContractClass.UserdataTable.COL_KEY + " TEXT ," +
            MyContractClass.UserdataTable.COL_SNIPPETID + " TEXT);";

    public static final String SQL_CREATE_SNIPPET = "CREATE TABLE " + MyContractClass.SnippetTable.TABLE_NAME + "( " +
            MyContractClass.SnippetTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MyContractClass.SnippetTable.COL_SIPPET + " Text)";

    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERDATA);
        db.execSQL(SQL_CREATE_SNIPPET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
