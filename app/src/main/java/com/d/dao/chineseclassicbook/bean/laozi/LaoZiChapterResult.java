package com.d.dao.chineseclassicbook.bean.laozi;

import com.d.dao.chineseclassicbook.bean.BaseBean;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiChapterContent;

import java.util.List;

/**
 * Created by dao on 2017/2/28.
 */

public class LaoZiChapterResult extends BaseBean {

    private List<LaoZiChapterContent> result;
    private String status;
    private String msg;

    public List<LaoZiChapterContent> getResult() {
        return result;
    }

    public void setResult(List<LaoZiChapterContent> result) {
        this.result = result;
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

    @Override
    public String toString() {
        return "LaoZiChapterResult{" +
                "result=" + result +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public LaoZiChapterResult(List<LaoZiChapterContent> result, String status, String msg) {
        this.result = result;
        this.status = status;
        this.msg = msg;
    }

    public LaoZiChapterResult(String status) {
        this.status = status;
    }

    private LaoZiChapterResult() {
    }
}
