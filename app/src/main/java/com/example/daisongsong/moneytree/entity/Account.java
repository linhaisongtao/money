package com.example.daisongsong.moneytree.entity;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class Account {
    private int id;
    private int cateId;
    private String content;
    private long time;
    private long money;

    public Account(int id, int cateId, String content, long time, long money) {
        this.id = id;
        this.cateId = cateId;
        this.content = content;
        this.time = time;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public double getMoneyInYuanDouble() {
        return 1.0 * money / 100;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cateId=" + cateId +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", money=" + money +
                '}';
    }
}
