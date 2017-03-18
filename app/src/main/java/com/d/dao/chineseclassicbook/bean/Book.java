package com.d.dao.chineseclassicbook.bean;

/**
 * 书库中每一本书的名字和序号
 * Created by dao on 2017/3/18.
 */

public class Book extends BaseBean {
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Book(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public Book() {
    }
}
