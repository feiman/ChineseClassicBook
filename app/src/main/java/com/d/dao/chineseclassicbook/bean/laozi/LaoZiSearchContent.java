package com.d.dao.chineseclassicbook.bean.laozi;

import com.d.dao.chineseclassicbook.bean.BaseBean;

import java.util.List;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiSearchContent extends BaseBean {

    private int total;
    private int pagenum;
    private int pagesize;

    private List<LaoZiSearch> list;

    public LaoZiSearchContent(int total, int pagenum, int pagesize, List<LaoZiSearch> list) {
        this.total = total;
        this.pagenum = pagenum;
        this.pagesize = pagesize;
        this.list = list;
    }

    public LaoZiSearchContent() {
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

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<LaoZiSearch> getList() {
        return list;
    }

    public void setList(List<LaoZiSearch> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LaoZiSearchContent{" +
                "list=" + list +
                ", pagesize=" + pagesize +
                ", pagenum=" + pagenum +
                ", total=" + total +
                '}';
    }
}
