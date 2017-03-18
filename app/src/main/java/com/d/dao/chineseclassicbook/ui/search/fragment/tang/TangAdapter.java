package com.d.dao.chineseclassicbook.ui.search.fragment.tang;

import android.text.TextUtils;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.bean.Tang;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;
import com.d.dao.zlibrary.baserecyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by dao on 2017/2/26.
 */

public class TangAdapter extends BaseRecyclerAdapter<Tang> {
    public TangAdapter(int layoutResId, List<Tang> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Tang item) {
        if (!TextUtils.isEmpty(item.getType())) {
            helper.setText(R.id.tv_type, item.getType());
        } else {
            helper.setText(R.id.tv_type, "");
        }
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_author, item.getAuthor());
        helper.setTextHtml(R.id.tv_content, item.getContent());
//        helper.setTextHtml(R.id.tv_translation, item.getTranslation());
//        helper.setTextHtml(R.id.tv_explanation, item.getExplanation());
//        helper.setTextHtml(R.id.tv_appreciation, item.getAppreciation());
    }
}
