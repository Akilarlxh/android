package com.totalo.moreinfo.index;

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
import com.totalo.moreinfo.contextActivity;
import com.totalo.moreinfo.InfoAdapter;
import com.totalo.moreinfo.Utils.HttpCallbackListener;
import com.totalo.moreinfo.Utils.HttpTool;
import com.totalo.moreinfo.Info;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Index_Fragment
 * 首页
 * 主要包含内容
 *      1.随机推送
 *      2.布局采用错落式布局
 */
public class Index_Fragment extends Fragment{
    ArrayList<Info> list = new ArrayList<>();
    private ListView listView ;
    /**
     * 初始化视图显示
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.indexfragment, container,false);
        listView = view.findViewById(R.id.index_list);
        String url = "https://api.twtmiss.cn/api/moreinfo/getAll.php";
        HttpTool.sendGetRequest("GET", url, null, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) throws JSONException {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i = 0;i <jsonArray.length();i++){
                           JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Info info = new Info();
                            info.setLable(jsonObject.getString("lable"));
                            info.setTitle(jsonObject.getString("title"));
                            info.setAuthor(jsonObject.getString("author"));
                            info.setPublishtime(jsonObject.getString("publishtime"));
                            info.setLink(jsonObject.getString("link"));
                            if(jsonObject.getString("introduction")!=null) {
                                info.setIntroduction(jsonObject.getString("introduction"));
                            }
                            info.setBrief(jsonObject.getString("brief"));
                            list.add(info);
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
            InfoAdapter adapter = new InfoAdapter(getActivity(),R.layout.info_item,list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(),contextActivity.class);
                    intent.putExtra("main",list.get(position));
                    startActivity(intent);
                }
            });
            Log.d("sss",model.toString());
        }
    };

}
