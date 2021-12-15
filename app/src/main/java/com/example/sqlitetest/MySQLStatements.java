package com.example.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MySQLStatements {
    public static long insertUserData(SQLiteDatabase db, String userName, String key, String snippetID) {
        ContentValues values = new ContentValues();
        values.put(MyContractClass.UserdataTable.COL_USERNAME, userName);
        values.put(MyContractClass.UserdataTable.COL_KEY, key);
        values.put(MyContractClass.UserdataTable.COL_SNIPPETID, snippetID);
        long newRowId = db.insert(MyContractClass.UserdataTable.TABLE_NAME, null, values);
        return newRowId;
    }

    public static long inserSnippet(SQLiteDatabase db, JSONObject snippet) {
        ContentValues values = new ContentValues();
        values.put(MyContractClass.SnippetTable.COL_SIPPET, snippet.toString());
        long newRowId = db.insert(MyContractClass.SnippetTable.TABLE_NAME, null, values);
        return newRowId;
    }

    public static JSONObject getSnippet(SQLiteDatabase db, int column) {
        JSONObject myJson = null;
        final String SQL_GET_SNIPPET =
                "SELECT " + "*" + " FROM " + MyContractClass.SnippetTable.TABLE_NAME +
                        " WHERE " + MyContractClass.SnippetTable._ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(column)};
        Cursor cursor = db.rawQuery(SQL_GET_SNIPPET, selectionArgs);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                try {
                    myJson = new JSONObject(cursor.getString(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            cursor.close();
        }
        return myJson;
    }

    public static String[] getUserData(SQLiteDatabase db, int userId) {
        String[] myData = new String[3];
        final String SQL_GET_USERDATA =
                "SELECT " + "*" +
                        " FROM " + MyContractClass.UserdataTable.TABLE_NAME +
                        " WHERE " + MyContractClass.UserdataTable._ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(userId)};
        Cursor cursor = db.rawQuery(SQL_GET_USERDATA, selectionArgs);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int i = 0;
                do {
                    myData[i] = cursor.getString(i);
                    Log.d("lol", myData[i]);
                    i++;
                }
                while (cursor.moveToNext());
            }
            cursor.close();
        }
        return myData;
    }
}