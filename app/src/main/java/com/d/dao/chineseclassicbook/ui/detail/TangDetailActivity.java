package com.d.dao.chineseclassicbook.ui.detail;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.base.BaseActivity;
import com.d.dao.chineseclassicbook.bean.Tang;

import butterknife.BindView;

/**
 * Created by dao on 2017/3/16.
 */

public class TangDetailActivity extends BaseActivity {
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.tv_explanation)
    TextView tv_explanation;
    @BindView(R.id.tv_translation)
    TextView tv_translation;
    @BindView(R.id.tv_appreciation)
    TextView tv_appreciation;


    @BindView(R.id.ll_back)
    LinearLayout ll_back;

    /**
     * 布局Id
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.item_show_fragment_tang;
    }

    /**
     * 初始化视图
     */
    @Override
    public void initView() {

        Intent intent = getIntent();
        if (intent != null) {
            Tang tang = (Tang) intent.getSerializableExtra("detail");
            if (!TextUtils.isEmpty(tang.getType())) {
                tv_type.setText(tang.getType());
            } else {
                tv_type.setText("");

            }
            tv_title.setText(tang.getTitle());
            tv_author.setText(tang.getAuthor());
            tv_content.setText(Html.fromHtml(tang.getContent()));
            tv_explanation.setText(Html.fromHtml(tang.getExplanation()));
            tv_translation.setText(Html.fromHtml(tang.getTranslation()));
            tv_appreciation.setText(Html.fromHtml(tang.getAppreciation()));
        }

        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
