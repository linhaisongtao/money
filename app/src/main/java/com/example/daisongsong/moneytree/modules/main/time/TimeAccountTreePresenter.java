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
    private ITimeTreeAccountView mView;
    private AccountDBDao mAccountDBDao = new AccountDbDaoImpl(App.getInstance());

    private List<Account> mAccounts = new ArrayList<>();

    public TimeAccountTreePresenter(ITimeTreeAccountView view) {
        mView = view;
    }

    public void requestFirstPage() {
        mAccounts = mAccountDBDao.queryByTime(0, 20);
        mView.showList(mAccounts);
    }
}
