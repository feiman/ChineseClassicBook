package com.d.dao.chineseclassicbook.ui.search.fragment.tang;

import com.d.dao.chineseclassicbook.bean.TangResult;
import com.socks.library.KLog;

import rx.Subscriber;

/**
 * Created by dao on 2017/2/26.
 */

public class TangPresenter extends TangContract.Presenter {
    @Override
    public void onStart() {

    }

    @Override
    public void searchTang(String keyword, int page) {
        mModel.queryTang(keyword, page).subscribe(new Subscriber<TangResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                KLog.e(e.toString());
                mView.onSearchLoadFailure();
            }

            @Override
            public void onNext(TangResult tangResult) {

                KLog.e(tangResult.toString());
                KLog.e("status", tangResult.getStatus());
                switch (tangResult.getStatus()) {
                    case "0"://成功
                        mView.onSearchLoadSuccess(tangResult.getResult());
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

    /**
     * 获取宋词
     *
     * @param keyword
     * @param page
     */
    @Override
    public void searchSong(String keyword, int page) {
        mModel.querySong(keyword, page)
                .subscribe(new Subscriber<TangResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.toString());
                        mView.onSearchLoadFailure();
                    }

                    @Override
                    public void onNext(TangResult tangResult) {
                        KLog.e(tangResult.toString());
                        switch (tangResult.getStatus()) {
                            case "0"://成功
                                mView.onSearchLoadSuccess(tangResult.getResult());
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

    /**
     * 获取元曲
     *
     * @param keyword
     * @param page
     */
    @Override
    public void searchYuan(String keyword, int page) {
        mModel.queryYuan(keyword, page)
                .subscribe(new Subscriber<TangResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.toString());
                        mView.onSearchLoadFailure();
                    }

                    @Override
                    public void onNext(TangResult tangResult) {
                        KLog.e(tangResult.toString());
                        switch (tangResult.getStatus()) {
                            case "0"://成功
                                mView.onSearchLoadSuccess(tangResult.getResult());
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

}
//
//        201	关键词为空
//        203	没有信息
//        系统错误码：
//        代号	说明
//        101	APPKEY为空或不存在
//        102	APPKEY已过期
//        103	APPKEY无请求此数据权限
//        104	请求超过次数限制
//        105	IP被禁止
//        106	IP请求超过限制
//        107	接口维护中
//        108	接口已停用