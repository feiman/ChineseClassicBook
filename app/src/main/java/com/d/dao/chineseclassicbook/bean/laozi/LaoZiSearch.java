package com.d.dao.chineseclassicbook.bean.laozi;

import com.d.dao.chineseclassicbook.bean.BaseBean;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiSearch extends BaseBean {
    private String detailid;
    private String name;
    private String content;
    private String commentary;
    private String translation;
    private String appreciation;
    private String interpretation;

    public LaoZiSearch(String detailid, String name, String content,
                       String commentary, String translation,
                       String appreciation, String interpretation) {
        this.detailid = detailid;
        this.name = name;
        this.content = content;
        this.commentary = commentary;
        this.translation = translation;
        this.appreciation = appreciation;
        this.interpretation = interpretation;
    }

    public LaoZiSearch() {

    }

    public String getDetailid() {
        return detailid;
    }

    public void setDetailid(String detailid) {
        this.detailid = detailid;
    }

    @Override
    public String toString() {
        return "LaoZiSearch{" +
                "detailid='" + detailid + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", commentary='" + commentary + '\'' +
                ", translation='" + translation + '\'' +
                ", appreciation='" + appreciation + '\'' +
                ", interpretation='" + interpretation + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}

