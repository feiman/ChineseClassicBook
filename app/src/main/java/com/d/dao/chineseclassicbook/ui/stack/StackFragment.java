package com.d.dao.chineseclassicbook.ui.stack;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.base.BaseFragment;
import com.d.dao.chineseclassicbook.bean.Book;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by dao on 2017/3/17.
 */

public class StackFragment extends BaseFragment {
    @BindView(R.id.banner)
    BGABanner mBanner;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    List<String> mBannerTitleList = new ArrayList<>();//banner标题
    List<String> mBannerImageUrlList = new ArrayList<>();//bannerUrl

    /**
     * 由子类实现创建布局的方法
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_stack;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        initBanner();
        initRecyclerView();

    }

    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Book> mList = new ArrayList<>();//储存数据

    private String[] mBooks = {"皇帝内经", "吕氏春秋", "三国志", "山海经", "史记", "周易",
            "世说新语", "孙子兵法", "明史", "天宫开物", "梦溪笔谈", "了凡四训"};

    private void initRecyclerView() {
        initBookList();

        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 3, GridLayoutManager.VERTICAL, false));
        recyclerViewAdapter = new RecyclerViewAdapter(R.layout.item_book, mList);
        mRecyclerView.setAdapter(recyclerViewAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAdapter.setOnRecyclerViewItemClickListener(new BaseRecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                jumpByClickItem(position);
            }
        });
    }

    private void initBookList() {
        Book book;
        for (int i = 0, j = mBooks.length; i < j; i++) {
            book = new Book();
            book.setName(mBooks[i]);
            book.setIndex(i);
            mList.add(book);
        }
    }

    private void initBanner() {
        mBannerImageUrlList.add("");
        mBannerImageUrlList.add("");
        mBannerImageUrlList.add("");
        mBannerImageUrlList.add("");
        mBannerTitleList.add("论语");
        mBannerTitleList.add("孟子");
        mBannerTitleList.add("庄子");
        mBannerTitleList.add("诗经");

        mBanner.setAllowUserScrollable(true);
        mBanner.setAdapter(new BGABannerAdapter(mContext));
        mBanner.setData(mBannerImageUrlList, mBannerTitleList);
        mBanner.setOnItemClickListener(new BGABanner.OnItemClickListener() {
            @Override
            public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {

            }
        });
    }
}
