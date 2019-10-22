package com.funny.component.base;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.funny.component.R;
import com.funny.component.databinding.ActivityBaseTitleBinding;

/**
 * Author: Funny
 * Time: 2019/10/22
 * Description: This is 封装了Toolbar的Activity
 */
public abstract class BaseTitleActivity extends AppCompatActivity {

    private ActivityBaseTitleBinding mBingdingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBingdingView = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_base_title, null, false);
        View mRootView = mBingdingView.getRoot();
        FrameLayout containerView = mBingdingView.containerFl;
        initContainerView(containerView);
        setContentView(mRootView);

        //设置标题栏
        setToolBar(mBingdingView.toolBar);
    }

    protected abstract void initContainerView(FrameLayout containerView);

    /**
     * 设置titlebar
     */
    private void setToolBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });
    }

    @Override
    public void setTitle(CharSequence title) {
        mBingdingView.toolBar.setTitle(title);
    }

    protected void setNoTitle() {
        mBingdingView.toolBar.setVisibility(View.GONE);
    }
}
