package com.funny.wan.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.funny.component.base.BaseActivity;
import com.funny.component.base.BaseFragment;
import com.funny.component.base.ViewPagerFragmentAdapter;
import com.funny.wan.R;
import com.funny.wan.ui.fragment.WanMainFragment;
import com.funny.wan.ui.fragment.WanNavigationFragment;
import com.funny.wan.ui.fragment.WanPublicFragment;
import com.funny.wan.ui.fragment.WanSystemFragment;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {

    private ViewPager mViewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, TestActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        initFragment();
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initFragment() {
        List<String> titleList = new ArrayList<>();
        titleList.add("玩安卓");
        titleList.add("公众号");
        titleList.add("知识体系");
        titleList.add("导航");

        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(WanMainFragment.newInstance());
        fragmentList.add(WanNavigationFragment.newInstance());
        fragmentList.add(WanPublicFragment.newInstance());
        fragmentList.add(WanSystemFragment.newInstance());

        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList, titleList);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
    }
}
