package com.d.dao.zlibrary.base.activity;

import android.os.Bundle;

import com.d.dao.zlibrary.base.ZBaseModel;
import com.d.dao.zlibrary.base.ZBasePresenter;
import com.d.dao.zlibrary.baseutils.StatusBarUtil;


/**
 * Created by dao on 14/11/2016.
 * 一般界面通用的Activity
 */
// TODO: 19/12/2016 可不可以找到使用动态设置背景是否透明的方法
public abstract class ZBaseCommonActivity<T extends ZBasePresenter, E extends ZBaseModel> extends
        ZActivity<T, E> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置StatusBar颜色与透明度
        StatusBarUtil.setColor(ZBaseCommonActivity.this, getStatusBarColorResourceId(),
                getStatusBarAlpha());
    }

    /**
     * 状态栏颜色
     *
     * @return
     */
    protected abstract int getStatusBarColorResourceId();

    /**
     * 状态栏透明度
     *
     * @return
     */
    protected abstract int getStatusBarAlpha();

    /**
     * 是否夜间模式
     *
     * @return
     */
    @Override
    public boolean isNight() {
        return false;
    }

    /**
     * 是否需要滑动结束activity
     *
     * @return
     */
    @Override
    public boolean canSwipeToFinish() {
        return false;
    }
}