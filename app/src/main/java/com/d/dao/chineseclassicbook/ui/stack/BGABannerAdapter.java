package com.d.dao.chineseclassicbook.ui.stack;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.d.dao.chineseclassicbook.R;

import cn.bingoogolapple.bgabanner.BGABanner;


public class BGABannerAdapter implements BGABanner.Adapter {
    private Context context;

    public BGABannerAdapter(Context context) {
        this.context = context;
    }

    // TODO: 2017/2/8 设置一张placeholder
    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        int[] mUrls = {R.mipmap.lunyu, R.mipmap.mengzi, R.mipmap.zhuangzi, R.mipmap.shijing};

        Glide.with(context)
                .load(mUrls[position])
                .crossFade()
                .into((ImageView) view);
    }
}
