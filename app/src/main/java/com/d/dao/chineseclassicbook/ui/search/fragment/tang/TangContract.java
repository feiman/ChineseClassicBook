package com.d.dao.chineseclassicbook.ui.search.fragment.tang;

import com.d.dao.chineseclassicbook.bean.TangResult;
import com.d.dao.chineseclassicbook.ui.search.fragment.BaseNoInitFragmentView;
import com.d.dao.zlibrary.base.ZBaseModel;
import com.d.dao.zlibrary.base.ZBasePresenter;

import rx.Observable;

/**
 * Created by dao on 2017/2/26.
 */

public interface TangContract {
    /**
     * @param <M> Presenter返回的详细结果类型
     */
    interface View<M> extends BaseNoInitFragmentView<M> {

    }

    interface Model extends ZBaseModel {

        /**
         * 唐诗
         *
         * @param keyword 关键词
         * @param page    页数
         * @return
         */
        Observable<TangResult> queryTang(String keyword, int page);

        /**
         * 宋词
         *
         * @param keyword 关键词
         * @param page    页数
         * @return
         */
        Observable<TangResult> querySong(String keyword, int page);


        /**
         * 元曲
         *
         * @param keyword 关键词
         * @param page    页数
         * @return
         */
        Observable<TangResult> queryYuan(String keyword, int page);
    }

    abstract class Presenter extends ZBasePresenter<View, Model> {

        /**
         * 获取唐诗
         *
         * @param keyword 关键词
         * @param page    页数
         */
        abstract void searchTang(String keyword, int page);

        /**
         * 获取宋词
         *
         * @param keyword
         * @param page
         */
        abstract void searchSong(String keyword, int page);

        /**
         * 获取元曲
         *
         * @param keyword
         * @param page
         */
        abstract void searchYuan(String keyword, int page);
    }
}
