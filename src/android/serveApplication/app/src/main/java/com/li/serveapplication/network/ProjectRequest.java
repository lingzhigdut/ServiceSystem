package com.li.serveapplication.network;

import com.google.gson.Gson;



import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static com.li.serveapplication.common.FinalData.JSON;

public class ProjectRequest {

    public void getAllProjects(Callback callback,String url){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(JSON, gson.toJson(null));
        Request request = new Request.Builder()
                .url(url)
                .post(null)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
