package com.universal.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by malijie on 2016/12/19.
 */

public class ViewHolder {
    private static ViewHolder holder = null;
    private SparseArray<View> mSparseArray = null;
    private View mConvertView = null;
    private int mPosition;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position){
        mSparseArray = new SparseArray<View>();
        mPosition = position;
        mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);;
        mConvertView.setTag(this);

    }

    public static ViewHolder getViewHolder(Context context, View convertView, ViewGroup parent,int layoutId,int position){
        if(convertView == null){
            return new ViewHolder(context,parent,layoutId,position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public <T extends View> T getView(int viewId){
        View view = mSparseArray.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
            mSparseArray.put(viewId,view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return mConvertView;
    }

    public void setText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
    }

    public void setImageResId(int viewId,int resId){
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
    }

}
