package com.d.dao.chineseclassicbook.ui.search.fragment.taoteching;

import com.alibaba.fastjson.JSONObject;
import com.d.dao.chineseclassicbook.api.API;
import com.d.dao.chineseclassicbook.api.Urls;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiChapterResult;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearchResult;
import com.d.dao.zlibrary.baserx.RxSchedulers;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiModel implements LaoZiContract.Model {
    /**
     * 老子道德经
     * 查询老子章节
     */
    @Override
    public Observable<LaoZiChapterResult> queryLaoZiChapter() {
        return API.getInstance().getApiService().queryChapter(Urls.APP_KEY)

                .map(new Func1<String, LaoZiChapterResult>() {
                    @Override
                    public LaoZiChapterResult call(String s) {
                        LaoZiChapterResult result = null;
                        if (getStatus(s).equals("0")) {
                            result = JSONObject.parseObject(s, LaoZiChapterResult.class);
                        } else {
                            result = new LaoZiChapterResult(getStatus(s));
                        }
                        return result;
                    }
                })
                .compose(RxSchedulers.<LaoZiChapterResult>io_main());
    }

    /**
     * 老子道德经
     * 搜索
     *
     * @param keyword
     * @param page
     * @return
     */
    @Override
    public Observable<LaoZiSearchResult> queryLaoZi(String keyword, int page) {
        return API.getInstance().getApiService().queryLaoZi(Urls.APP_KEY, keyword, 1,page,2)
                .map(new Func1<String, LaoZiSearchResult>() {
                    @Override
                    public LaoZiSearchResult call(String s) {
                        String status = getStatus(s);
                        LaoZiSearchResult result = null;
                        if (status.equals("0")) {
                            result = JSONObject.parseObject(s, LaoZiSearchResult.class);
                        } else {
                            result = new LaoZiSearchResult(status);
                        }
                        return result;
                    }
                })
                .compose(RxSchedulers.<LaoZiSearchResult>io_main());
    }

    /**
     * 获取状态值
     *
     * @param s
     * @return
     */
    private String getStatus(String s) {
        String str = s.substring(s.indexOf("\"", 9), s.indexOf(","));
        return str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
    }
}
