package com.d.dao.chineseclassicbook.ui.search.fragment.tang;

import com.alibaba.fastjson.JSONObject;
import com.d.dao.chineseclassicbook.api.API;
import com.d.dao.chineseclassicbook.api.Urls;
import com.d.dao.chineseclassicbook.bean.TangContent;
import com.d.dao.chineseclassicbook.bean.TangResult;
import com.d.dao.zlibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by dao on 2017/2/26.
 */

public class TangModel implements TangContract.Model {
    @Override
    public Observable<TangResult> queryTang(String keyword, int page) {

        return API.getInstance().getApiService().queryTang(Urls.APP_KEY, keyword, page, 2)

                .map(new Func1<String, TangResult>() {
                    @Override
                    public TangResult call(String s) {

                        String str = s.substring(s.indexOf("\"", 9), s.indexOf(","));
                        String temp = (str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\"")));

                        TangResult tangResult = null;
                        if (temp.equals("0")) {
                            tangResult = JSONObject.parseObject(s, TangResult.class);
                        } else {
                            tangResult = new TangResult(new TangContent(), temp, "");
                        }
                        return tangResult;
                    }
                })
                .compose(RxSchedulers.<TangResult>io_main());
    }

    /**
     * 宋词
     *
     * @param keyword 关键词
     * @param page    页数
     * @return
     */
    @Override
    public Observable<TangResult> querySong(String keyword, int page) {
        return API.getInstance().getApiService().querySong(Urls.APP_KEY, keyword, page, 2)
                .compose(RxSchedulers.<TangResult>io_main());
    }

    /**
     * 元曲
     *
     * @param keyword 关键词
     * @param page    页数
     * @return
     */
    @Override
    public Observable<TangResult> queryYuan(String keyword, int page) {

        return API.getInstance().getApiService().queryYuan(Urls.APP_KEY, keyword, page, 2)
                .map(new Func1<TangResult, TangResult>() {
                    @Override
                    public TangResult call(TangResult tangResult) {
                        return tangResult;
                    }
                })
                .compose(RxSchedulers.<TangResult>io_main());
    }
}
