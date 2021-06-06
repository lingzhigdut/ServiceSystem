package com.li.serveapplication.network;

import android.util.Log;

import com.google.gson.Gson;
import com.li.serveapplication.common.FinalData;
import com.li.serveapplication.model.Customer;
import com.li.serveapplication.model.Employee;
import com.li.serveapplication.model.Server;
import com.li.serveapplication.model.User;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.li.serveapplication.common.FinalData.JSON;

public class UserRequest {

    public static void login(Callback callback,String name,String password,String userType){
        OkHttpClient client = new OkHttpClient();
        String url = null;
        RequestBody body = null;
        Gson gson = new Gson();
        //设置http地址
        if (userType.contains("客户")) {
            url = FinalData.baseURL+ "/customer/customerLogin";
            Customer user = new Customer();
            user.setName(name);
            user.setPassword(password);
            body = RequestBody.create(JSON, gson.toJson(user));
        } else if (userType.contains("自由职业者")) {
            url =FinalData.baseURL+ "/server/serverLogin";
            Server user = new Server();
            user.setName(name);
            user.setPassword(password);
            body = RequestBody.create(JSON, gson.toJson(user));
        } else if (userType.contains("员工")) {
            Employee user = new Employee();
            url = FinalData.baseURL+"/employee/employeeLogin";
            user.setName(name);
            user.setPassword(password);
            body = RequestBody.create(JSON, gson.toJson(user));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
