package com.d.dao.chineseclassicbook.ui.search.fragment.taoteching;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiChapterContent;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearch;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearchContent;
import com.d.dao.chineseclassicbook.constant.RxConstants;
import com.d.dao.chineseclassicbook.ui.detail.LaoZiDetailActivity;
import com.d.dao.chineseclassicbook.ui.search.fragment.BaseInitRequestFragment;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;
import com.d.dao.zlibrary.baseutils.ToastUitl;

import java.util.List;

import rx.functions.Action1;

/**
 * 老子*道德经
 * Created by dao on 2017/2/28.
 */


public class FragmentLaoZi extends BaseInitRequestFragment<LaoZiPresenter, LaoZiModel,
        LaoZiSearch, LaoZiSearchContent,
        LaoZiChapterContent>
        implements LaoZiContract.View<LaoZiSearchContent, LaoZiChapterContent> {

    private LaoZiChapterAdapter mChapterAdapter;
    private LaoZiSearchAdapter mSearchAdapter;

    /**
     * 根据不同的子类类型发起不同请求
     *
     * @param key
     * @param page
     */
    @Override
    protected void childLoad(String key, int page) {
        mPresenter.searchLaoZi(key, page);
    }

    @Override
    protected void initRxListener() {
        /**
         * 监听在搜索新闻界面点击搜索
         */
        mRxManager.on(RxConstants.SEARCH_CLICK_TAO_TE_CHING, new Action1<String>() {
            @Override
            public void call(String s) {

                if (isSpringRefresh || isSpringLoad) {
                    ToastUitl.showShort("正在加载中，请稍后再试");
                    return;
                }
                isInSearch = true;
                isInInit = false;
                mSpringView.setLoadMoreAble(true);
                mSpringView.setRefreshAble(true);
                key = s;
                curPage = 0;
                mSearchList.clear();
                mContainer.showLoading();
                loadData(curPage);
            }
        });
    }

    @Override
    protected void initRecyclerView() {
        mChapterAdapter = new LaoZiChapterAdapter(R.layout.item_fragment_laozi_chapter, mChapterList);

        mSearchAdapter = new LaoZiSearchAdapter(R.layout.item_fragment_laozi, mSearchList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mSearchAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mChapterAdapter.setOnRecyclerViewItemClickListener(new BaseRecyclerAdapter.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//            }
//        });
        mSearchAdapter.setOnRecyclerViewItemClickListener(new BaseRecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("detail", mSearchAdapter.getItem(position));
                intent.setClass(mContext, LaoZiDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 显示初始页面的内容
     */
    @Override
    protected void showInitPage() {
        isFirstIn = false;
        mContainer.showEmpty(getResources().getDrawable(R.drawable.load_no_data), "输入关键词进行搜索", "");

//        mContainer.showLoading();
//        mPresenter.getLaoZiChapter();
    }


    /**
     * 由子类实现创建布局的方法
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_tang_poes;
    }

    /**
     * 搜索成功
     *
     * @param data
     */
    @Override
    public void onSearchLoadSuccess(LaoZiSearchContent data) {
        if (isSpringRefresh) {//刷新
            onNewData(data);
            isSpringRefresh = false;
            mSpringView.onRefreshAndLoadFinished();
        } else if (isSpringLoad) {//加载
            onAddData(data);
            isSpringLoad = false;
            mSpringView.onRefreshAndLoadFinished();
        } else {//直接查询
            if (isFirstIn) {
                isFirstIn = false;
            }
            onNewData(data);
            mContainer.showContent();
        }
    }

    /**
     * 搜索
     *
     * @param data
     */
    private void onNewData(LaoZiSearchContent data) {
        curPage = data.getPagenum();
        totalPage = data.getTotal();
        mSearchAdapter.setNewData(data.getList());
        this.mSearchList = mSearchAdapter.getData();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    private void onAddData(LaoZiSearchContent data) {
        curPage = data.getPagenum();
        totalPage = data.getTotal();
        mSearchAdapter.addData(data.getList());
        this.mSearchList = mSearchAdapter.getData();
    }

    /**
     * 获取章节成功
     *
     * @param data
     */
    @Override
    public void onGetChapterSuccess(List<LaoZiChapterContent> data) {
        mSpringView.setLoadMoreAble(false);
        mSpringView.setRefreshAble(false);
        mContainer.showContent();

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.setAdapter(mChapterAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mChapterAdapter.setOnRecyclerViewItemClickListener(new BaseRecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        mChapterAdapter.addData(data);
        this.mChapterList = mChapterAdapter.getData();


    }


}
