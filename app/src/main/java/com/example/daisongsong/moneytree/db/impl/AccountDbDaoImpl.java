package com.example.daisongsong.moneytree.db.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.daisongsong.moneytree.db.AccountDBDao;
import com.example.daisongsong.moneytree.db.DBHelper;
import com.example.daisongsong.moneytree.entity.Account;

import java.util.ArrayList;
import java.util.List;

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
        long id = db.insert(DBHelper.TABLE_ACCOUNT, null, cv);
        DbUtils.close(db, null);
        if (id > 0) {
            account.setId((int) id);
            return account;
        } else {
            return null;
        }
    }

    @Override
    public Account update(Account account) {
        SQLiteDatabase db = DbUtils.getWritableDb(mContext);

        ContentValues cv = new ContentValues();
        cv.put("time", account.getTime());
        cv.put("time", account.getTime());
        cv.put("money", account.getMoney());
        cv.put("cateId", account.getCateId());
        cv.put("content", account.getContent());
        int res = db.update(DBHelper.TABLE_ACCOUNT, cv, "_id=?", new String[]{String.valueOf(account.getId())});
        DbUtils.close(db, null);
        if (res > 0) {
            return account;
        } else {
            return null;
        }
    }

    @Override
    public List<Account> queryByTime(int offset, int limit) {
        List<Account> accounts = new ArrayList<>();
        SQLiteDatabase db = DbUtils.getReadableDb(mContext);
        Cursor cursor = db.query(DBHelper.TABLE_ACCOUNT, new String[]{"_id", "time", "money", "cateId", "content"},
                null, null, null, null, "time desc", String.format("%d,%d", offset, limit));
        while (cursor != null && cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            long money = cursor.getLong(cursor.getColumnIndex("money"));
            long time = cursor.getLong(cursor.getColumnIndex("time"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            int catId = cursor.getInt(cursor.getColumnIndex("cateId"));
            Account a = new Account(id, catId, content, time, money);
            accounts.add(a);
        }
        DbUtils.close(db, cursor);
        return accounts;
    }

}
