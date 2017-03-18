package com.d.dao.chineseclassicbook.ui.stack;

import android.graphics.Color;
import android.support.v7.widget.CardView;

import com.d.dao.chineseclassicbook.R;
import com.d.dao.zlibrary.baserecyclerview.BaseRecyclerAdapter;
import com.d.dao.zlibrary.baserecyclerview.BaseViewHolder;

import java.util.List;


/**
 * Created by dao on 2017/2/6.
 */

public class RecyclerViewAdapter extends BaseRecyclerAdapter<String> {

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int[] color = {Color.parseColor("#6c13a4"), Color.parseColor("#c60d63"),
                Color.parseColor("#1bc7ca"), Color.parseColor("#ea7f2d"),
                Color.parseColor("#3f61c7"), Color.parseColor("#a52cd6")};
        helper.setText(R.id.tv_book, item);
        CardView cardView = (CardView) helper.convertView.findViewById(R.id.cardView);
        cardView.setCardBackgroundColor(color[(int) (Math.random() * 6)]);
    }


    public RecyclerViewAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }
}
