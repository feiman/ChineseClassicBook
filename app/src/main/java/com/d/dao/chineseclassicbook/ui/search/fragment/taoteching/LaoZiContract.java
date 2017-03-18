package com.d.dao.chineseclassicbook.ui.search.fragment.taoteching;

import com.d.dao.chineseclassicbook.bean.laozi.LaoZiChapterResult;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearchResult;
import com.d.dao.chineseclassicbook.ui.search.fragment.BaseInitFragmentView;
import com.d.dao.zlibrary.base.ZBaseModel;
import com.d.dao.zlibrary.base.ZBasePresenter;

import rx.Observable;

/**
 * Created by dao on 2017/3/1.
 */

public interface LaoZiContract {

    /**
     * @param <M> Presenter返回的详细结果类型
     * @param <A> 章节列表
     */
    interface View<M, A> extends BaseInitFragmentView<M, A> {

    }

    interface Model extends ZBaseModel {

        /**
         * 老子道德经
         * 查询老子章节
         */
        Observable<LaoZiChapterResult> queryLaoZiChapter();

        /**
         * 老子道德经
         * 搜索
         *
         * @param keyword
         * @param page
         * @return
         */
        Observable<LaoZiSearchResult> queryLaoZi(String keyword, int page);
    }

    abstract class Presenter extends ZBasePresenter<View, Model> {

        /**
         * 老子道德经
         * 获取道德经的章数
         */
        abstract void getLaoZiChapter();

        /**
         * 老子道德经
         * 搜索
         */
        abstract void searchLaoZi(String keyword, int page);

    }
}
