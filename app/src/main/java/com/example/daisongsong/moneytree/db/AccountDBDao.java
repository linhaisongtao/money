package com.example.daisongsong.moneytree.db;

import com.example.daisongsong.moneytree.entity.Account;

import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public interface AccountDBDao {

    Account insert(Account account);
    Account update(Account account);
    List<Account> queryByTime(int offset, int limit);
    int getTotalCount();
}
