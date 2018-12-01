package com.totalo.moreinfo.bbs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.totalo.moreinfo.R;
import com.totalo.moreinfo.Utils.HttpCallbackListener;
import com.totalo.moreinfo.Utils.HttpTool;
import com.totalo.moreinfo.contextActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 论坛版块
 * 排版样式
 */
public class Forum_Fragment extends Fragment{

    ArrayList<BBSbean> list = new ArrayList<>();
    private ListView listView ;
    /**
     * 初始化界面
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.forum, container,false);
        listView = view.findViewById(R.id.forumlist);
        String url = "https://api.twtmiss.cn/api/moreinfo/getForum.php";
        HttpTool.sendGetRequest("GET", url, null, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response);
                for(int i = 0;i <jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    BBSbean bbSbean = new BBSbean();
                    bbSbean.setId(jsonObject.getString("id"));
                    bbSbean.setProblem(jsonObject.getString("problem"));
                    bbSbean.setDes(jsonObject.getString("des"));
                    bbSbean.setFbtime(jsonObject.getString("fbtime"));
                    bbSbean.setUser(jsonObject.getString("user"));
                    list.add(bbSbean);
                }
                Message message = new Message();
                message.what = 0;
                message.obj = response.toString();
                handler.sendMessage(message);

            }

            @Override
            public void onError(Exception e) {

            }
        });
        return view;
    }
    /**
     * 接收解析后传过来的数据
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            Object model = (Object) msg.obj;
            BBSAdapter adapter = new BBSAdapter(getActivity(),R.layout.forum_item,list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(),BBSdetail.class);
                    intent.putExtra("context",list.get(position));
                    startActivity(intent);
                }
            });
            Log.d("sss",model.toString());
        }
    };
}
