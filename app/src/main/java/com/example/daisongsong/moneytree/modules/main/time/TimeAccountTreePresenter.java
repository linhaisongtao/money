package com.example.daisongsong.moneytree.modules.main.time;

import com.example.daisongsong.moneytree.App;
import com.example.daisongsong.moneytree.db.AccountDBDao;
import com.example.daisongsong.moneytree.db.impl.AccountDbDaoImpl;
import com.example.daisongsong.moneytree.entity.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class TimeAccountTreePresenter {
    private static final int DEFAULT_LIMIT = 10;

    private ITimeTreeAccountView mView;
    private AccountDBDao mAccountDBDao = App.getInstance() == null ? null : new AccountDbDaoImpl(App.getInstance());

    private List<Account> mAccounts = new ArrayList<>();

    public TimeAccountTreePresenter(ITimeTreeAccountView view) {
        mView = view;
    }

    public void requestFirstPage() {
        if (mAccountDBDao != null) {
            mAccounts = mAccountDBDao.queryByTime(0, DEFAULT_LIMIT);
            mView.showList(mAccounts);
        }
    }

    public void requestMore() {
        final int nowCount = mAccounts.size();
        if (mAccounts != null && nowCount > 0) {
            int totalInDB = mAccountDBDao.getTotalCount();
            if (totalInDB > nowCount) {
                mAccounts.addAll(mAccountDBDao.queryByTime(nowCount, DEFAULT_LIMIT));
                mView.showList(mAccounts);
            }
        }
    }

    public int getNowTotalCount() {
        return mAccounts == null ? 0 : mAccounts.size();
    }
}
