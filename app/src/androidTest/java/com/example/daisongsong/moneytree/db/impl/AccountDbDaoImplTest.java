package com.example.daisongsong.moneytree.db.impl;

import com.example.daisongsong.moneytree.App;
import com.example.daisongsong.moneytree.db.AccountDBDao;
import com.example.daisongsong.moneytree.entity.Account;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class AccountDbDaoImplTest extends TestCase {

    public void testInsert() throws Exception {
        Account account = new Account(0, 1, "test", System.currentTimeMillis(), 12300);
        AccountDBDao dao = new AccountDbDaoImpl(App.getInstance());
        Account account1 = dao.insert(account);
        System.out.println("AccountDbDaoImplTest.testInsert account1 = " + account1);
        Assert.assertNotNull(account1);
    }


    public void testUpdate() {
        Account account = new Account(3, 1, "test123", System.currentTimeMillis(), 812300);
        AccountDBDao dao = new AccountDbDaoImpl(App.getInstance());
        Account a = dao.update(account);
        System.out.println("AccountDbDaoImplTest.testUpdate a = " + a);
        Assert.assertNotNull(a);
    }

    public void testQueryByTime() {
        List<Account> accounts = new AccountDbDaoImpl(App.getInstance()).queryByTime(2, 2);

        Assert.assertNotNull(accounts);
        Assert.assertTrue(accounts.size() > 0);
        final int count = accounts.size();
        for (int i = 0; i < count; ++i) {
            System.out.println("AccountDbDaoImplTest.testQueryByTime accounts[" + i + "] = " + accounts.get(i));
        }
    }
}