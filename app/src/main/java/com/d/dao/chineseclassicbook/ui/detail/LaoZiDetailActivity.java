package com.d.dao.chineseclassicbook.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.base.BaseActivity;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearch;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dao on 2017/3/16.
 */

public class LaoZiDetailActivity extends BaseActivity {


    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.tv_commentary)
    TextView tv_commentary;
    @BindView(R.id.tv_translation)
    TextView tv_translation;
    @BindView(R.id.tv_interpretation)
    TextView tv_interpretation;
    @BindView(R.id.tv_appreciation)
    TextView tv_appreciation;

    /**
     * 布局Id
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_show_fragment_laozi;
    }

    /**
     * 初始化视图
     */
    @Override
    public void initView() {
        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            LaoZiSearch search = (LaoZiSearch) intent.getSerializableExtra("detail");
            tv_name.setText(search.getName());
            tv_content.setText(Html.fromHtml(search.getContent()));
            tv_appreciation.setText(Html.fromHtml(search.getAppreciation()));
            tv_interpretation.setText(Html.fromHtml(search.getInterpretation()));
            tv_commentary.setText(Html.fromHtml(search.getCommentary()));
            tv_translation.setText(Html.fromHtml(search.getTranslation()));
        }
    }

}
