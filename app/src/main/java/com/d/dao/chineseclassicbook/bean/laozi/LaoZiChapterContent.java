package com.d.dao.chineseclassicbook.bean.laozi;

import com.d.dao.chineseclassicbook.bean.BaseBean;

/**
 * Created by dao on 2017/2/28.
 */

public class LaoZiChapterContent extends BaseBean {

    private int detailid;//详情ID
    private String name;//名称

    public LaoZiChapterContent(int detailid, String name) {
        this.detailid = detailid;
        this.name = name;
    }

    public int getDetailid() {
        return detailid;
    }

    public void setDetailid(int detailid) {
        this.detailid = detailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LaoZiChapterContent() {
    }
}

