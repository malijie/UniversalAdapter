package com.universal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by malijie on 2016/12/19.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    private List<T> mList = null;
    private Context mContext = null;
    private int mLayoutId;
    public CommonAdapter(Context context, List<T> list,int layoutId){
        mContext = context;
        mList = list;
        mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext,view,viewGroup,mLayoutId,position);
        convert(viewHolder,mList.get(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T item);

}
