package com.d.dao.chineseclassicbook.ui.search.fragment.taoteching;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiSearch;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;
import com.d.dao.zlibrary.baserecyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiSearchAdapter extends BaseRecyclerAdapter<LaoZiSearch> {

    public LaoZiSearchAdapter(int layoutResId, List<LaoZiSearch> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LaoZiSearch item) {

        helper.setText(R.id.tv_title, item.getName());
        helper.setTextHtml(R.id.tv_content, item.getContent());

    }
}
