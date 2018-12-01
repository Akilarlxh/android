package com.totalo.moreinfo.Utils;

import org.json.JSONException;

public interface HttpCallbackListener {
    void onFinish(String response) throws JSONException;
    void onError(Exception e);
}
