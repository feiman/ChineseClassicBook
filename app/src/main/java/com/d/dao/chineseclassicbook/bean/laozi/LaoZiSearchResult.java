package com.d.dao.chineseclassicbook.bean.laozi;

import com.d.dao.chineseclassicbook.bean.BaseBean;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiSearchResult extends BaseBean {

    private String status;
    private String msg;
    private LaoZiSearchContent result;


    public LaoZiSearchResult(String status, String msg, LaoZiSearchContent result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    private LaoZiSearchResult() {
    }

    public LaoZiSearchResult(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LaoZiSearchResult{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LaoZiSearchContent getResult() {
        return result;
    }

    public void setResult(LaoZiSearchContent result) {
        this.result = result;
    }
}
