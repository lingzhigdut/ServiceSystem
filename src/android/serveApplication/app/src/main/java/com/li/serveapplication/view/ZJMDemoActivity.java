package com.li.serveapplication.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.li.serveapplication.R;
import com.li.serveapplication.common.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

public class ZJMDemoActivity extends Activity implements OnClickListener,OnPageChangeListener{

    // 底部菜单4个Linearlayout
    private LinearLayout ll_task;
    private LinearLayout ll_taskCondition;
    private LinearLayout ll_personal;
    private LinearLayout ll_settings;


    // 底部菜单4个菜单标题
    private TextView tv_task;
    private TextView tv_condition;
    private TextView tv_personal;
    private TextView tv_settings;

    // 中间内容区域
    private ViewPager viewPager;

    // ViewPager适配器ContentAdapter
    private ContentAdapter adapter;

    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhujiemain);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();

    }

    private void initEvent() {
        // 设置按钮监听
        ll_task.setOnClickListener(this);
        ll_taskCondition.setOnClickListener(this);
        ll_personal.setOnClickListener(this);
        ll_settings.setOnClickListener(this);

        //设置ViewPager滑动监听
        viewPager.setOnPageChangeListener(this);
    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_task = (LinearLayout) findViewById(R.id.ll_home);
        this.ll_taskCondition = (LinearLayout) findViewById(R.id.ll_address);
        this.ll_personal = (LinearLayout) findViewById(R.id.ll_friend);
        this.ll_settings = (LinearLayout) findViewById(R.id.ll_setting);

//        // 底部菜单4个ImageView
//        this.iv_home = (ImageView) findViewById(R.id.iv_home);
//        this.iv_address = (ImageView) findViewById(R.id.iv_address);
//        this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
//        this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

        // 底部菜单4个菜单标题
        this.tv_task = (TextView) findViewById(R.id.tv_home);
        this.tv_condition = (TextView) findViewById(R.id.tv_address);
        this.tv_personal = (TextView) findViewById(R.id.tv_friend);
        this.tv_settings = (TextView) findViewById(R.id.tv_setting);

        // 中间内容区域ViewPager
        this.viewPager = (ViewPager) findViewById(R.id.vp_content);

        // 适配器
        View page_01 = View.inflate( com.li.serveapplication.view.ZJMDemoActivity.this, R.layout.page_01, null);
        View page_02 = View.inflate( com.li.serveapplication.view.ZJMDemoActivity.this, R.layout.page_02, null);
        View page_03 = View.inflate(com.li.serveapplication.view.ZJMDemoActivity.this, R.layout.page_03, null);
        View page_04 = View.inflate(com.li.serveapplication.view.ZJMDemoActivity.this, R.layout.page_04, null);

        views = new ArrayList<View>();
        views.add(page_01);
        views.add(page_02);
        views.add(page_03);
        views.add(page_04);

        this.adapter = new ContentAdapter(views);
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_home:
                tv_task.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_address:
                tv_condition.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_friend:
                tv_personal.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_setting:
                tv_settings.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(3);
                break;

            default:
                break;
        }

    }

    private void restartBotton() {
        // TextView置为白色
        tv_task.setTextColor(0xffffffff);
        tv_condition.setTextColor(0xffffffff);
        tv_personal.setTextColor(0xffffffff);
        tv_settings.setTextColor(0xffffffff);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        restartBotton();
        //当前view被选择的时候,改变底部菜单图片，文字颜色
        switch (arg0) {
            case 0:
                tv_task.setTextColor(0xff1B940A);
                break;
            case 1:
                tv_condition.setTextColor(0xff1B940A);
                break;
            case 2:
                tv_personal.setTextColor(0xff1B940A);
                break;
            case 3:
                tv_settings.setTextColor(0xff1B940A);
                break;

            default:
                break;
        }

    }

}