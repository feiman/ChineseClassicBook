package com.d.dao.chineseclassicbook.ui.search.fragment.song;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.bean.Tang;
import com.d.dao.chineseclassicbook.bean.TangContent;
import com.d.dao.chineseclassicbook.constant.RxConstants;
import com.d.dao.chineseclassicbook.ui.detail.TangDetailActivity;
import com.d.dao.chineseclassicbook.ui.search.fragment.BaseNoInitRequestFragment;
import com.d.dao.chineseclassicbook.ui.search.fragment.tang.TangAdapter;
import com.d.dao.chineseclassicbook.ui.search.fragment.tang.TangContract;
import com.d.dao.chineseclassicbook.ui.search.fragment.tang.TangModel;
import com.d.dao.chineseclassicbook.ui.search.fragment.tang.TangPresenter;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;
import com.d.dao.zlibrary.baseutils.ToastUitl;

import rx.functions.Action1;

/**
 * 唐诗
 * Created by dao on 2017/2/26.
 */

public class FragmentSong extends BaseNoInitRequestFragment<TangPresenter, TangModel, Tang, TangContent>
        implements TangContract.View<TangContent> {


    /**
     * 由子类实现创建布局的方法
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_tang_poes;
    }


    @Override
    protected void childLoad(String key, int page) {
        mPresenter.searchSong(key, page);
    }

    @Override
    protected void initRxListener() {
        /**
         * 监听在搜索新闻界面点击搜索
         */
        mRxManager.on(RxConstants.SEARCH_CLICK_SONG, new Action1<String>() {
            @Override
            public void call(String s) {

                if (isSpringRefresh || isSpringLoad) {
                    ToastUitl.showShort("正在加载中，请稍后再试");
                    return;
                }
                key = s;
                curPage = 0;
                mList.clear();
                mContainer.showLoading();
                loadData(curPage);

            }
        });
    }

    @Override
    protected void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new TangAdapter(R.layout.item_fragment_tang, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnRecyclerViewItemClickListener(new BaseRecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("detail", mAdapter.getItem(position));
                intent.setClass(mContext, TangDetailActivity.class);
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
    }

    /**
     * 加载成功
     *
     * @param tangContent
     */
    @Override
    public void onSearchLoadSuccess(TangContent tangContent) {
        if (isSpringRefresh) {//刷新
            onNewData(tangContent);
            isSpringRefresh = false;
            mSpringView.onRefreshAndLoadFinished();
        } else if (isSpringLoad) {//加载
            onAddData(tangContent);
            isSpringLoad = false;
            mSpringView.onRefreshAndLoadFinished();
        } else {//直接查询
            if (isFirstIn) {
                isFirstIn = false;
            }
            onNewData(tangContent);
            mContainer.showContent();
        }
    }

    /**
     * 获取新数据
     *
     * @param tangContent
     */
    private void onNewData(TangContent tangContent) {
        curPage = tangContent.getPagenum();
        totalPage = tangContent.getTotal();
        mAdapter.setNewData(tangContent.getList());
        this.mList = mAdapter.getData();
    }

    /**
     * 添加数据
     *
     * @param tangContent
     */
    private void onAddData(TangContent tangContent) {
        curPage = tangContent.getPagenum();
        totalPage = tangContent.getTotal();
        mAdapter.addData(tangContent.getList());
        this.mList = mAdapter.getData();
    }

}
