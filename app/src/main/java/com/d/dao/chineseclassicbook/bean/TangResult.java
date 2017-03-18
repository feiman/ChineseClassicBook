package com.d.dao.chineseclassicbook.bean;

/**
 * Created by dao on 2017/2/26.
 */

public class TangResult extends BaseBean {

    private TangContent result;
    public String status;
    public String msg;


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

    public TangContent getResult() {
        return result;
    }

    public void setResult(TangContent result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TangResult{" +
                "result=" + result +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    private TangResult() {

    }

    public TangResult(TangContent result, String status, String msg) {
        this.result = result;
        this.status = status;
        this.msg = msg;
    }
}
