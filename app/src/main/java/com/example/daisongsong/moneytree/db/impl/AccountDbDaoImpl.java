package com.example.daisongsong.moneytree.db.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.daisongsong.moneytree.db.AccountDBDao;
import com.example.daisongsong.moneytree.entity.Account;

/**
 * Created by daisongsong on 2015/11/13.
 */
//db.execSQL("CREATE TABLE IF NOT EXISTS m" +
//        "(_id INTEGER PRIMARY KEY AUTOINCREMENT, time LONG, money LONG, cateId INTEGER, content VARCHAR");
public class AccountDbDaoImpl implements AccountDBDao {
    private Context mContext;

    public AccountDbDaoImpl(Context context) {
        mContext = context;
    }

    @Override
    public Account insert(Account account) {
        SQLiteDatabase db = DbUtils.getWritableDb(mContext);
        ContentValues cv = new ContentValues();
        cv.put("time", account.getTime());
        cv.put("money", account.getMoney());
        cv.put("cateId", account.getCateId());
        cv.put("content", account.getContent());
        long id = db.insert("m", null, cv);
        DbUtils.close(db, null);
        if (id > 0) {
            account.setId((int) id);
            return account;
        } else {
            return null;
        }
    }

}
