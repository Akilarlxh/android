package com.totalo.moreinfo.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * 保存登陆的状态
 */
public class SharePreference implements SharedPreferences{
    Context context;
    public SharePreference(){}
    public SharePreference(Context context){
        this.context = context;
    }

    /**
     * 设置登陆的状态
     */
    public void setStatus(){
        SharedPreferences sp  =  context.getSharedPreferences("save",Context.MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogin",true);
        editor.apply();

    }

    /**
     * 获取登陆状态
     * @return
     */
    public boolean getStatus(){
        SharedPreferences sp = context.getSharedPreferences("save",Context.MODE_WORLD_READABLE);
        boolean b = sp.getBoolean("isLogin",false);
        return b;
    }

    @Override
    public Map<String, ?> getAll() {
        return null;
    }

    @Nullable
    @Override
    public String getString(String key, @Nullable String defValue) {
        return null;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        return null;
    }

    @Override
    public int getInt(String key, int defValue) {
        return 0;
    }

    @Override
    public long getLong(String key, long defValue) {
        return 0;
    }

    @Override
    public float getFloat(String key, float defValue) {
        return 0;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return false;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Editor edit() {
        return null;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }
}
