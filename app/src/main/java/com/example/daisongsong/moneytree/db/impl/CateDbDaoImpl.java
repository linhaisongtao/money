package com.example.daisongsong.moneytree.db.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.daisongsong.moneytree.db.CateDBDao;
import com.example.daisongsong.moneytree.db.DBHelper;
import com.example.daisongsong.moneytree.entity.Cate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 * <p>
 * db.execSQL("CREATE TABLE IF NOT EXISTS cate" +
 * "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");
 */
public class CateDbDaoImpl implements CateDBDao {
    private Context mContext;

    public CateDbDaoImpl(Context context) {
        mContext = context;
    }

    @Override
    public Cate insert(Cate cate) {
        SQLiteDatabase db = DbUtils.getWritableDb(mContext);
        ContentValues cv = new ContentValues();
        cv.put("name", cate.getName());
        int id = (int) db.insert("cate", null, cv);
        DbUtils.close(db, null);
        if (id > 0) {
            cate.setId(id);
            return cate;
        } else {
            return null;
        }

    }

    @Override
    public Cate query(int id) {
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery(String.format("SELECT * FROM cate where _id = '%d'", id), null);
        Cursor cursor = db.query("cate", new String[]{"_id", "name"}, "_id=?", new String[]{String.valueOf(id)},
                null, null, null);
        Cate cate = null;
        if (cursor != null && cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            cate = new Cate(_id, name);
        }
        cursor.close();
        db.close();
        return cate;
    }

    @Override
    public int update(Cate cate) {
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", cate.getName());
        int res = db.update("cate", cv, "_id=?", new String[]{String.valueOf(cate.getId())});
        db.close();
        return res;
    }

    @Override
    public List<Cate> findAll() {
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("cate", new String[]{"_id", "name"}, null, null, null, null, null);
        List<Cate> cates = new ArrayList<>();
        while (cursor != null && cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Cate cate = new Cate(_id, name);
            cates.add(cate);
        }
        cursor.close();
        db.close();
        return cates;
    }
}
