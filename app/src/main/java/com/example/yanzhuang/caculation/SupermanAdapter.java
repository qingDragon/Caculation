package com.example.yanzhuang.caculation;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yanzhuang on 2017/6/15.
 */

public class SupermanAdapter extends ArrayAdapter<Superman> {
    private int resourceId;

    public SupermanAdapter(Context context, int textViewResourceId, List<Superman> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Superman superman = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.supermanImage = (ImageView) view.findViewById(R.id.superman_image);
            viewHolder.supermanName = (TextView) view.findViewById(R.id.superman_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.supermanImage.setImageResource(superman.getImageId());
        viewHolder.supermanName.setText(superman.getName());
        return view;
    }
}
