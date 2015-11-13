package com.example.daisongsong.moneytree.db.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.daisongsong.moneytree.db.DBHelper;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class DbUtils {

    public static SQLiteDatabase getReadableDb(Context context) {
        return new DBHelper(context).getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDb(Context context) {
        return new DBHelper(context).getWritableDatabase();
    }

    public static void close(SQLiteDatabase db, Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }

        if (db != null) {
            db.close();
        }
    }
}
