package com.d.dao.chineseclassicbook.base;

import com.d.dao.zlibrary.base.ZBaseModel;
import com.d.dao.zlibrary.base.ZBasePresenter;
import com.d.dao.zlibrary.base.fragment.ZBaseFragment;

/**
 * Created by dao on 2017/3/17.
 */

public abstract class BaseFragment<T extends ZBasePresenter, E extends ZBaseModel> extends
        ZBaseFragment<T, E> {

    @Override
    protected void dispatchLogicToChild() {

    }
}
