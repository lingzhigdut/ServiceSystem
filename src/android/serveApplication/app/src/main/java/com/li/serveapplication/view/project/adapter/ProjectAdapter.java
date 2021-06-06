package com.li.serveapplication.view.project.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.li.serveapplication.R;
import com.li.serveapplication.model.Project;

import java.util.List;

public class ProjectAdapter extends BaseQuickAdapter<Project, BaseViewHolder> {


    public ProjectAdapter(@Nullable List<Project> data) {
        super(R.layout.page_01,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Project project) {
        helper.setText(R.id.tv_task_tile,project.getIntroduction());
    }


}
