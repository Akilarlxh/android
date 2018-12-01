package com.totalo.moreinfo.bbs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.totalo.moreinfo.R;

import java.util.List;

public class BBSAdapter extends ArrayAdapter<BBSbean> {
    private int resourceId;
    public BBSAdapter(Context context, int textViewResourceId, List<BBSbean> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BBSbean bbSbean = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView title = view.findViewById(R.id.bbs_listview_title);
        TextView user = view.findViewById(R.id.bbs_listview_user);
        TextView num = view.findViewById(R.id.bbs_listview_num);
        title.setText(bbSbean.getProblem());
        user.setText(bbSbean.getUser());
        num.setText(bbSbean.getId());
        return view;
    }
}
