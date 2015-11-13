package com.example.daisongsong.moneytree.db;

import com.example.daisongsong.moneytree.entity.Cate;

import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public interface CateDBDao{
    Cate insert(Cate cate);
    Cate query(int id);
    int update(Cate cate);
    List<Cate> findAll();
}
