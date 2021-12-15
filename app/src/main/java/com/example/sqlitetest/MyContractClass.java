package com.example.sqlitetest;

import android.provider.BaseColumns;

public final  class MyContractClass {
    public MyContractClass(){}
    public static abstract class UserdataTable implements BaseColumns{
        public static final String TABLE_NAME = "UserdataTable";
        public static final String COL_USERNAME = "Username";
        public static final String COL_KEY = "Key";
        public static final String COL_SNIPPETID = "SnippetID";
    }
    public static abstract class SnippetTable implements BaseColumns{
        public static final String TABLE_NAME = "SnippetTable";
        public static final String COL_SIPPET = "Snippet";
    }
}
