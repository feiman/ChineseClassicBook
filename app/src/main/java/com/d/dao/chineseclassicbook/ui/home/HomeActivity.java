package com.d.dao.chineseclassicbook.ui.home;

import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.baidu.autoupdatesdk.BDAutoUpdateSDK;
import com.baidu.autoupdatesdk.UICheckUpdateCallback;
import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.base.BaseActivity;
import com.d.dao.chineseclassicbook.ui.search.SearchFragment;
import com.d.dao.chineseclassicbook.ui.stack.StackFragment;
import com.d.dao.chineseclassicbook.ui.search3.Search3Fragment;
import com.d.dao.chineseclassicbook.ui.search4.Search4Fragment;
import com.d.dao.zlibrary.basefragmenthelper.FragmentController;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by dao on 2017/3/17.
 */

public class HomeActivity extends BaseActivity {

    @BindView(R.id.rg)
    RadioGroup mRadioGroup;


    private String[] titles = {"推荐", "书库", "搜索", "下载"};
    private FragmentController fragmentController;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    /**
     * 布局Id
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    /**
     * 初始化视图
     */
    @Override
    public void initView() {

        //检测更新
        BDAutoUpdateSDK.uiUpdateAction(this, new MyUICheckUpdateCallback());

        mFragments.add(new StackFragment());
        mFragments.add(new Search3Fragment());
        mFragments.add(new SearchFragment());
        mFragments.add(new Search4Fragment());

        fragmentController = FragmentController.getInstance(this, R.id.container, mFragments);
        fragmentController.showFragment(0);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_recommend:
                        switchToFragment(0);
                        break;
                    case R.id.rb_stack:
                        switchToFragment(1);
                        break;
                    case R.id.rb_search:
                        switchToFragment(2);
                        break;
                    case R.id.rb_download:
                        switchToFragment(3);
                        break;
                }
            }
        });

    }

    private class MyUICheckUpdateCallback implements UICheckUpdateCallback {

        @Override
        public void onCheckComplete() {
        }
    }

    private void switchToFragment(int index) {
        if (index < 0) {
            index = 0;
        } else if (index > titles.length) {
            index = titles.length;
        }
        fragmentController.showFragment(index);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentController.onDestroy();
    }
}
