package com.exp.totalo.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsContentFragment extends Fragment{
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refresh(String newTitle,String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(view.VISIBLE);
        TextView newTitleText = (TextView)view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView)view.findViewById(R.id.new_content);
        newTitleText.setText(newTitle);
        newsContentText.setText(newsContent);
    }

    }
