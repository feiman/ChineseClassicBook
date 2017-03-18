package com.d.dao.chineseclassicbook.ui.search.fragment;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.zlibrary.base.ZBaseModel;
import com.d.dao.zlibrary.base.ZBasePresenter;
import com.d.dao.zlibrary.base.fragment.ZBaseLazyFragment;
import com.d.dao.zlibrary.baseutils.ToastUitl;
import com.d.dao.zlibrary.basewidgets.ProgressActivity;
import com.d.dao.zlibrary.basewidgets.zspringview.container.ZDefaultFooter;
import com.d.dao.zlibrary.basewidgets.zspringview.container.ZDefaultHeader;
import com.d.dao.zlibrary.basewidgets.zspringview.widget.ZSpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by dao on 2017/2/27.
 */

/**
 * 道德经论语的基类
 * 进入时进行请求
 *
 * @param <K> recyclerView的列表数据类型
 * @param <M> presenter搜索后返回的详细结果类型
 * @param <T> presenter类型
 * @param <E> model类型
 * @param <A> 返回的章节目录列表数据类型
 */
public abstract class BaseInitRequestFragment<T extends ZBasePresenter, E extends ZBaseModel,
        K, M, A>
        extends ZBaseLazyFragment<T, E> implements BaseInitFragmentView<M, A> {

    protected
    @BindView(R.id.uiContainer)
    ProgressActivity mContainer;
    protected
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    protected
    @BindView(R.id.spring)
    ZSpringView mSpringView;

    protected boolean isSpringRefresh = false;
    protected boolean isSpringLoad = false;


    protected int curPage = 0;
    protected int totalPage = -1;

    protected String key = "";

    protected List<K> mSearchList = new ArrayList<>();

    protected List<A> mChapterList = new ArrayList<>();

    protected boolean isInSearch = false;
    protected boolean isInInit = false;

    /**
     * 第一次进入界面是自动加载
     */
    @Override
    protected void lazyLoad() {
        if (!isFirstIn) {
            return;
        }
        if (isSpringLoad || isSpringRefresh) {
            return;
        }
        isInInit = true;
        isInSearch = false;
        showInitPage();//显示页面刚进入时的初始内容
    }


    protected void loadData(int page) {
        if (isSpringLoad && isLastPage()) {
            if (isSpringLoad) {
                mSpringView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSpringView.onRefreshAndLoadFinished();
                        ToastUitl.showShort("没有更多相关的内容了");
                    }
                }, 1000);
            }
            return;
        }

        if (TextUtils.isEmpty(key)) {
            ToastUitl.showShort("请输入关键词进行查询");
            return;
        }
        childLoad(key, page + 1);
    }

    /**
     * 是否最后一页
     *
     * @return
     */
    private boolean isLastPage() {
        if (totalPage != -1 && totalPage <= curPage * 2) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * onResume时刷新数据,一般不用处理
     */
    @Override
    public void refreshData() {

    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        initRxListener();
        initRecyclerView();
        initSpring();
    }

    protected void initSpring() {
        mSpringView.setEnabled(true);
        mSpringView.setHeader(new ZDefaultHeader(mContext));
        mSpringView.setFooter(new ZDefaultFooter(mContext));
        mSpringView.setOnRefreshAndLoadListener(new ZSpringView.OnRefreshAndLoadListener() {
            @Override
            public void onRefresh() {
                if (isSpringLoad || isSpringRefresh) {
                    return;
                }
                isSpringRefresh = true;
                curPage = 0;
                loadData(curPage);
            }

            @Override
            public void onLoadMore() {
                if (isSpringLoad || isSpringRefresh) {
                    return;
                }

                isSpringLoad = true;
                loadData(curPage);
            }
        });


    }

    /**
     * 获取章节失败
     */
    @Override
    public void onGetChapterFailure() {
        mContainer.showError(getResources().getDrawable(R.drawable.load_no_data),
                "获取数据失败", "检查网络是否通畅后重试", "再试试",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showInitPage();
                    }
                });
    }

    /**
     * 搜索加载失败
     */
    @Override
    public void onSearchLoadFailure() {

        if (isSpringRefresh) {//刷新
            mSpringView.onRefreshAndLoadFinished();
            isSpringRefresh = false;
            if (mSearchList.isEmpty()) {
                showRefreshError();
            }
        } else if (isSpringLoad) {//加载
            showLoadError();
            mSpringView.onRefreshAndLoadFinished();
            isSpringLoad = false;
        } else {
            showSearchError();
        }
    }

    /**
     * 加载失败
     */
    private void showLoadError() {
        ToastUitl.showShort("加载失败");
    }

    /**
     * 刷新或者搜索失败
     */
    private void showRefreshError() {
        mContainer.showError(getResources().getDrawable(R.drawable.load_no_data),
                "获取数据失败", "检查网络是否通畅后重试", "再试试",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContainer.showLoading();
                        loadData(curPage);
                    }
                });
    }

    /**
     * 搜索失败
     */
    private void showSearchError() {
        showRefreshError();
    }


    /**
     * 没有相关信息
     */
    @Override
    public void onNoRelativeMessage() {
        if (isSpringRefresh) {//刷新
            mSpringView.onRefreshAndLoadFinished();
            isSpringRefresh = false;
            showNoMessageError();
        } else if (isSpringLoad) {//加载
            showNoMessageLoadError();
            mSpringView.onRefreshAndLoadFinished();
            isSpringLoad = false;
        } else {
            showNoMessageError();
        }
    }

    /**
     * 加载更多时没有找到相关信息
     */
    private void showNoMessageLoadError() {
        ToastUitl.showShort("没有数据了");
    }

    /**
     * 没有相关信息
     */
    private void showNoMessageError() {
        if (isInSearch) {
            mContainer.showError(getResources().getDrawable(R.drawable.load_no_data),
                    "没有找到相关内容", "请修改关键词后重试", "再试试",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mContainer.showLoading();
                            loadData(curPage);
                        }
                    });
        } else {
            mContainer.showError(getResources().getDrawable(R.drawable.load_no_data),
                    "没有章节信息", "", "再试试",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showInitPage();
                        }
                    });
        }

    }

    /**
     * 关键词为空
     */
    @Override
    public void onSearchKeyNull() {
        if (isSpringRefresh) {//刷新
            mSpringView.onRefreshAndLoadFinished();
            isSpringRefresh = false;
            showNoKeyError();
        } else if (isSpringLoad) {//加载
            showNoKeyLoadError();
            mSpringView.onRefreshAndLoadFinished();
            isSpringLoad = false;
        } else {
            showNoKeyError();
        }
    }

    private void showNoKeyLoadError() {
        ToastUitl.showShort("关键词为空");
    }

    private void showNoKeyError() {
        mContainer.showError(getResources().getDrawable(R.drawable.load_no_data),
                "关键词为空", "请修改关键词后重试", "再试试",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContainer.showLoading();
                        loadData(curPage);
                    }
                });

    }

    @Override
    public void onServerUnAvailable() {
        if (isSpringRefresh) {//刷新
            mSpringView.onRefreshAndLoadFinished();
            isSpringRefresh = false;
            showServerUnAvailableError();
        } else if (isSpringLoad) {//加载
            showServerLoadError();
            mSpringView.onRefreshAndLoadFinished();
            isSpringLoad = false;
        } else {
            showServerUnAvailableError();
        }
    }

    /**
     * 服务器不可用
     */
    private void showServerUnAvailableError() {
        mContainer.showError(getResources().getDrawable(R.drawable.load_error),
                "稍后再试", "服务器暂时不可用，正在抢修中", "再试试",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isInSearch) {
                            mContainer.showLoading();
                            loadData(curPage);
                        } else {// 获取章节失败
                            showInitPage();
                        }

                    }
                });
    }

    private void showServerLoadError() {
        ToastUitl.showShort("服务器正在维护中，稍后再试");
    }

    /**
     * 根据不同的子类类型发起不同请求
     *
     * @param key
     * @param page
     */
    protected abstract void childLoad(String key, int page);

    protected abstract void initRxListener();

    protected abstract void initRecyclerView();

    /**
     *
     */
    protected abstract void showInitPage();
}
