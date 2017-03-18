package com.d.dao.chineseclassicbook.base;

import android.os.Bundle;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.zlibrary.base.ZBaseModel;
import com.d.dao.zlibrary.base.ZBasePresenter;
import com.d.dao.zlibrary.base.activity.ZBaseCommonActivity;
import com.d.dao.zlibrary.base.activity.ZBaseWelcomeActivity;
import com.d.dao.zlibrary.baseutils.StatusBarUtil;

/**
 * Created by dao on 2017/2/4.
 */

public abstract class BaseActivity<T extends ZBasePresenter, E extends ZBaseModel>
        extends ZBaseCommonActivity<T, E> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(BaseActivity.this, getResources().getColor(R.color.colorPrimary), 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        JPushInterface.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        JPushInterface.onResume(this);
    }

    @Override
    protected int getStatusBarAlpha() {
        return 0;
    }

    @Override
    protected int getStatusBarColorResourceId() {
        return R.color.colorPrimary;
    }
}
