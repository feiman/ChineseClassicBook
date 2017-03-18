package com.d.dao.chineseclassicbook.ui.search.fragment.taoteching;

import com.d.dao.chineseclassicbook.bean.laozi.LaoZiChapterResult;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearchResult;
import com.d.dao.zlibrary.baserx.LogSubscriber;
import com.socks.library.KLog;

import rx.Subscriber;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiPresenter extends LaoZiContract.Presenter {
    /**
     * 老子道德经
     * 获取道德经的章数
     */
    @Override
    void getLaoZiChapter() {
        mModel.queryLaoZiChapter().subscribe(new Subscriber<LaoZiChapterResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                KLog.e(e.toString());
                mView.onGetChapterFailure();
            }

            @Override
            public void onNext(LaoZiChapterResult laoZiChapterResult) {
                KLog.e("status", laoZiChapterResult.getStatus());
                switch (laoZiChapterResult.getStatus()) {
                    case "0"://成功
                        mView.onGetChapterSuccess(laoZiChapterResult.getResult());
                        break;
                    case "203"://没有信息
                        mView.onNoRelativeMessage();
                        break;
                    case "201"://关键词为空
                        mView.onSearchKeyNull();
                        break;
                    case "101":
                    case "102":
                    case "103":
                    case "104":
                    case "105":
                    case "106":
                    case "107":
                    case "108":
                        mView.onServerUnAvailable();
                        break;
                    default:
                        mView.onGetChapterFailure();
                        //服务器暂时不可用了
                        break;
                }
            }
        });
    }

    /**
     * 老子道德经
     * 搜索
     *
     * @param keyword
     * @param page
     */
    @Override
    public void searchLaoZi(String keyword, int page) {
        mModel.queryLaoZi(keyword, page).subscribe(new LogSubscriber<LaoZiSearchResult>() {
            @Override
            protected void onError2(Throwable e) {
                mView.onSearchLoadFailure();
            }

            @Override
            protected void onNext2(LaoZiSearchResult result) {
                switch (result.getStatus()) {
                    case "0"://成功
                        mView.onSearchLoadSuccess(result.getResult());
                        break;
                    case "203"://没有信息
                        mView.onNoRelativeMessage();
                        break;
                    case "201"://关键词为空
                        mView.onSearchKeyNull();
                        break;
                    case "101":
                    case "102":
                    case "103":
                    case "104":
                    case "105":
                    case "106":
                    case "107":
                    case "108":
                        mView.onServerUnAvailable();
                        break;
                    default:
                        mView.onSearchLoadFailure();
                        //服务器暂时不可用了
                        break;
                }
            }
        });
    }

    @Override
    public void onStart() {

    }
}
