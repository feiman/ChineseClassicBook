package com.d.dao.chineseclassicbook.bean;

import java.util.List;

/**
 * Created by dao on 2017/2/26.
 */

public class TangContent extends BaseBean{

    private int total;
    private int pagenum;
    private int pageSize;
    private List<Tang> list;

    @Override
    public String toString() {
        return "TangContent{" +
                "total='" + total + '\'' +
                ", pagenum='" + pagenum + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", list=" + list +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Tang> getList() {
        return list;
    }

    public void setList(List<Tang> list) {
        this.list = list;
    }




}
//"total":"9",
//        "pagenum": "1",
//        "pagesize": "1",
//        "list": [
//        {
//        "title": "登鹳雀楼",
//        "type": "五言绝句",
//        "content": "白日依山尽，黄河入海流。<br>欲穷千里目，更上一层楼。",
//        "explanation": "<p>　　1．鹳雀楼：旧址在山西永济县，楼高三层，前对中条山，下临黄河。传说常有鹳雀在此停留，故有此名。 </p>",
//        "appreciation": "<p>　　这首诗写诗人在登高望远中表现出来的不凡的胸襟抱负，反映了盛唐时期人们积极向上的进取精神。 </p>",
//        "author": "王之涣"
//        }
//        ]