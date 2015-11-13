package com.example.daisongsong.moneytree.modules.newaccount;

import com.example.daisongsong.moneytree.App;
import com.example.daisongsong.moneytree.db.AccountDBDao;
import com.example.daisongsong.moneytree.db.impl.AccountDbDaoImpl;
import com.example.daisongsong.moneytree.entity.Account;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class AddAccountPresenter {
    private IAddAccountView mView;

    private AccountDBDao mAccountDBDao = new AccountDbDaoImpl(App.getInstance());


    public AddAccountPresenter(IAddAccountView view) {
        mView = view;
    }

    public void confirm(String moneyString) {
        long money = Long.MIN_VALUE;
        try {
            double m = Double.parseDouble(moneyString);
            money = (long) (m * 100);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Account account = new Account(-1, 1, "default", System.currentTimeMillis(), money);
        account = mAccountDBDao.insert(account);
        if (account == null) {
            mView.showErrorView();
        } else {
            mView.showAddSuccessView();
        }
    }


    public static interface IAddAccountView {
        void showAddSuccessView();

        void showErrorView();
    }
}
