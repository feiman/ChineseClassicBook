package com.d.dao.chineseclassicbook.ui.search.fragment;

/**
 * Created by dao on 2017/2/27.
 */

import java.util.List;

/**
 * @param <M>presenter返回的详细数据类型
 * @param <A>章节数据类型
 */
public interface BaseInitFragmentView<M, A> {
    /**
     * 加载成功
     */
    void onSearchLoadSuccess(M data);

    /**
     * 加载失败
     */
    void onSearchLoadFailure();

    /**
     * 没有相关信息
     */
    void onNoRelativeMessage();

    /**
     * 关键词为空
     */
    void onSearchKeyNull();

    /**
     * 服务器不可用
     */
    void onServerUnAvailable();

    /**
     * 获取章节成功
     *
     * @param data
     */
    void onGetChapterSuccess(List<A> data);

    /**
     * 获取章节失败
     */
    void onGetChapterFailure();
}
