package com.example.daisongsong.moneytree.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_ACCOUNT = "m";

    private static final int DB_VERSION = 4;

    public DBHelper(Context context) {
        super(context, "m.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS m" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, time LONG, money LONG, cateId INTEGER, content VARCHAR)");
        db.execSQL("CREATE TABLE IF NOT EXISTS cate" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("DBHelper.onUpgrade");
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE m");
            db.execSQL("DROP TABLE cate");
            createTables(db);
        }
    }
}
