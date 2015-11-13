package com.example.daisongsong.moneytree.entity;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class Cate {
    private int id;
    private String name;

    public Cate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
