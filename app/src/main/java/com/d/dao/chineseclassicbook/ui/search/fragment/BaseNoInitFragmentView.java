package com.d.dao.chineseclassicbook.ui.search.fragment;

/**
 * Created by dao on 2017/2/27.
 */

/**
 * @param <M>presenter返回的详细数据类型
 */
public interface BaseNoInitFragmentView<M> {
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
}
