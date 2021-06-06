package com.li.serveapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.li.serveapplication.R;
import com.li.serveapplication.common.FinalData;
import com.li.serveapplication.common.GetResponseBody;
import com.li.serveapplication.model.Server;
import com.li.serveapplication.model.sdf;
import com.li.serveapplication.network.UserRequest;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.li.serveapplication.common.FinalData.JSON;

public class LoginDemoActivity extends Activity implements View.OnClickListener {

    private final String TAG = "LoginDemoActivity";
    private EditText userNameEdit;
    private EditText passWordEdit;
    private Spinner userTypeSpinner;
    private Button qqLogin;
    private CheckBox hide_pwd;

    private String userName;
    private String passWord;
    private String url;
    private String userType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
       // setContentView(R.layout.login_ayout);
        //寻找控件
        initView();
        //设置点击事件
        initClickEvent();
    }

    //控件监听模块
    //初始化控件
    public void initView() {

//        userNameEdit = (EditText) this.findViewById(R.id.qq_account);
//        passWordEdit = (EditText) this.findViewById(R.id.qq_password);
//        qqLogin = (Button) this.findViewById(R.id.qq_login);
//        userTypeSpinner = (Spinner) findViewById(R.id.select_userType);
//        hide_pwd = (CheckBox) findViewById(R.id.hide_pwd);
//        //默认隐藏密码
//        hide_pwd.setChecked(true);

    }


    //checkbox监听
    private void initClickEvent() {
        //选择是否显示密码
        hide_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    passWordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    passWordEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        qqLogin.setOnClickListener(this);
    }


    //登录按钮监听
    @Override
    public void onClick(View v) {
        handleLoginButton(v);
    }

    //登录请求模块-----------------------------------------------------------------------------------
    //处理登录事件
    private void handleLoginButton(View v) {
        setValue();
        requestLogin();
    }


    //设置url
    public void setValue(){
        //第三步拿到界面上的内容，包括账号和密码
        userName = userNameEdit.getText().toString();
        passWord = passWordEdit.getText().toString();
        userType = userTypeSpinner.getSelectedItem().toString();


        //判空
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "账号不可以为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passWord)) {
            Toast.makeText(this, "密码不可以为空", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    //处理http请求
    public void requestLogin() {
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                sdf sss = gson.fromJson(response.body().string(), sdf.class);

                String jsonMsg = GetResponseBody.getResponseBody(response);
                Log.d(TAG, "onResponse: "+ response.body().string()); //+ response.body().string());
               // JsonObject jsonObject = new JsonObject();
                if (sss.getStatus()==200){
                    Intent intent = new Intent();
                    intent.setClass(LoginDemoActivity.this, ZJMDemoActivity.class);
                    startActivity(intent);
                }
            }
        };
        UserRequest.login(callback,userName,passWord,userType);
    }


}
