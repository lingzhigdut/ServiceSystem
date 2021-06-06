package com.li.serveapplication.view.project.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.li.serveapplication.R;
import com.li.serveapplication.common.FinalData;
import com.li.serveapplication.network.ProjectRequest;
import com.li.serveapplication.network.UserRequest;
import com.li.serveapplication.view.project.adapter.ProjectAdapter;
import com.li.serveapplication.model.Project;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import com.li.serveapplication.network.ProjectRequest;

public class TaskDemoActivity extends Activity implements View.OnClickListener{

    private TextView taskTile ;
    private View taskView;

    ProjectAdapter projectAdapter;
    private RecyclerView mRvProject;
    private Project project;
    private List<Project> projects;

    String url;
    String TAG = "TaskDemoActivity";
    //项目Rv


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_01);
        initData();
    }

    private void initData() {
        //调用网络请求
        url = FinalData.baseURL + "/project/server/projectAllNotAccepted";
        ProjectRequest projectRequest = new ProjectRequest();

        Callback callback = new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Gson gson = new Gson();
                project  = gson.fromJson(response.body().string(),Project.class);
                initView();
            }
        };

        projectRequest.getAllProjects(callback,url);
    }

    public void initView(){
        mRvProject = this.findViewById(R.id.recycler_view);
        ProjectAdapter adapter = new ProjectAdapter(projects);
        initProjectRv();
    };


    public void initProjectRv(){
        projectAdapter = new ProjectAdapter(projects);
        LinearLayoutManager lm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRvProject.setAdapter(projectAdapter);
        mRvProject.setLayoutManager(lm);
        projectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<Project> projects = projectAdapter.getData();
                Intent intent = new Intent();
                intent.putExtra(FinalData.PROJECT_ID,projects.get(position).getIntroduction());
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
