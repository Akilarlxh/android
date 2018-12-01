package com.totalo.moreinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class InfoAdapter extends ArrayAdapter<Info>{

    private int resourceId;
    public InfoAdapter(Context context,int textViewResourceId,List<Info> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Info info = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView infoImg = view.findViewById(R.id.info_img);
        TextView textView = view.findViewById(R.id.infotitle);
        infoImg.setText(info.getLable());
        textView.setText(info.getTitle());
        return view;
    }
}
