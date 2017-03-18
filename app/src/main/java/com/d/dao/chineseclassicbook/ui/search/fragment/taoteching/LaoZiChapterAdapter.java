package com.d.dao.chineseclassicbook.ui.search.fragment.taoteching;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.bean.laozi.LaoZiChapterContent;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;
import com.d.dao.zlibrary.baserecyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by dao on 2017/3/1.
 */

public class LaoZiChapterAdapter extends BaseRecyclerAdapter<LaoZiChapterContent> {

    public LaoZiChapterAdapter(int layoutResId, List<LaoZiChapterContent> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LaoZiChapterContent item) {

        helper.setText(R.id.tv_title, item.getName());
    }
}
