package com.exp.totalo.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    //创建活动类
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);

    }

    //删除类
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //完成
    public static void finishAll(){
        for (Activity activity :activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
