package com.example.daisongsong.moneytree.db.impl;

import com.example.daisongsong.moneytree.App;
import com.example.daisongsong.moneytree.db.AccountDBDao;
import com.example.daisongsong.moneytree.entity.Account;

import junit.framework.Assert;
import junit.framework.TestCase;

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
}