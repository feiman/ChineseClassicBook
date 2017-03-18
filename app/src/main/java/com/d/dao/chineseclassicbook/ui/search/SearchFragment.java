package com.d.dao.chineseclassicbook.ui.search;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.base.BaseFragment;
import com.d.dao.chineseclassicbook.constant.RxConstants;
import com.d.dao.chineseclassicbook.ui.search.fragment.song.FragmentSong;
import com.d.dao.chineseclassicbook.ui.search.fragment.tang.FragmentTang;
import com.d.dao.chineseclassicbook.ui.search.fragment.taoteching.FragmentLaoZi;
import com.d.dao.chineseclassicbook.ui.search.fragment.yuan.FragmentYuan;
import com.d.dao.zlibrary.basefragmenthelper.FragmentAdapter;
import com.d.dao.zlibrary.baseutils.KeyBoardUtil;
import com.d.dao.zlibrary.baseutils.ToastUitl;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by dao on 2017/3/17.
 */

public class SearchFragment extends BaseFragment {
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.tabLayout)
    TabLayout mTab;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private FragmentAdapter mViewPagerAdapter;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private String[] titles = {"唐诗", "宋词", "元曲", "道德经"};

    private String[] mClickTags = {RxConstants.SEARCH_CLICK_TANG, RxConstants.SEARCH_CLICK_SONG,
            RxConstants.SEARCH_CLICK_YUAN, RxConstants.SEARCH_CLICK_TAO_TE_CHING};


    /**
     * 由子类实现创建布局的方法
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        initTab();

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String key = et_search.getText().toString().trim();
                if (!TextUtils.isEmpty(key)) {
                    mRxManager.post(mClickTags[mViewPager.getCurrentItem()], key);
                    KeyBoardUtil.closeKeyBoard();
                    KLog.e("发送" + mViewPager.getCurrentItem());
                } else {
                    ToastUitl.showShort("请输入关键词后再搜索");
                }
                return true;
            }
        });
    }

    private void initTab() {
        mFragmentList.add(new FragmentTang());
        mFragmentList.add(new FragmentSong());
        mFragmentList.add(new FragmentYuan());
        mFragmentList.add(new FragmentLaoZi());

        mViewPagerAdapter = new FragmentAdapter(getFragmentManager(), mFragmentList, titles);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTab.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                et_search.setText("");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
