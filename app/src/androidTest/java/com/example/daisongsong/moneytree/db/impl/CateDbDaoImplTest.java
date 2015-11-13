package com.example.daisongsong.moneytree.db.impl;

import com.example.daisongsong.moneytree.App;
import com.example.daisongsong.moneytree.entity.Cate;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class CateDbDaoImplTest extends TestCase {
    public void testInsert() {
        long start = System.currentTimeMillis();
        CateDbDaoImpl dbDao = new CateDbDaoImpl(App.getInstance());
        Cate c = new Cate(0, "c1sewe");
        Cate cate = dbDao.insert(c);
        System.out.println("CateDbDaoImplTest.testInsert cate = " + cate);
        Assert.assertNotNull("cate not null !", cate);
        long end = System.currentTimeMillis();
        System.out.println("CateDbDaoImplTest.testInsert time = " + (end - start));
    }

    public void testQuery() {
        long start = System.currentTimeMillis();
        CateDbDaoImpl dbDao = new CateDbDaoImpl(App.getInstance());
        Cate cate = dbDao.query(0);
//        System.out.println("CateDbDaoImplTest.testQuery cate = " + cate);
//        Assert.assertNotNull("cate not null !", cate);
        cate = dbDao.query(1);
        System.out.println("CateDbDaoImplTest.testQuery cate = " + cate);
        Assert.assertNotNull("cate not null !", cate);
        cate = dbDao.query(2);
        System.out.println("CateDbDaoImplTest.testQuery cate = " + cate);
        Assert.assertNotNull("cate not null !", cate);
        cate = dbDao.query(3);
        System.out.println("CateDbDaoImplTest.testQuery cate = " + cate);
        Assert.assertNotNull("cate not null !", cate);
        long end = System.currentTimeMillis();
        System.out.println("CateDbDaoImplTest.testInsert time = " + (end - start));
    }


    public void testUpdate() {
        long start = System.currentTimeMillis();
        CateDbDaoImpl dbDao = new CateDbDaoImpl(App.getInstance());
        Cate c = new Cate(2, "ccccc");
        int res = dbDao.update(c);
        Assert.assertNotSame("not success", 0, res);
        Cate c1 = dbDao.query(2);
        System.out.println("CateDbDaoImplTest.testInsert cate = " + c1);
        Assert.assertNotNull("cate not null !", c1);
        long end = System.currentTimeMillis();
        System.out.println("CateDbDaoImplTest.testInsert time = " + (end - start));
    }

    public void testFindAll() {
        long start = System.currentTimeMillis();
        CateDbDaoImpl dbDao = new CateDbDaoImpl(App.getInstance());

        List<Cate> cates = dbDao.findAll();
        Assert.assertNotNull("cate not null !", cates);
        Assert.assertTrue(cates.size() > 0);
        final int count = cates.size();
        for (int i = 0; i < count; ++i) {
            System.out.println("CateDbDaoImplTest.testFindAll cate [" + i + "] = " + cates.get(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("CateDbDaoImplTest.testInsert time = " + (end - start));
    }
}