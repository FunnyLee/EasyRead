package com.funny.wan.ui;

import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseActivity;
import com.funny.component.base.BaseFragment;
import com.funny.component.base.ViewPagerFragmentAdapter;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityMainBinding;
import com.funny.wan.viewModel.MainViewModel;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

@Route(path = RouterManager.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    private List<BaseFragment> mFragmentList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initImmersionbar() {
        ImmersionBar.with(this).statusBarView(mBingdingView.includeLayout.statusView).init();
    }

    @Override
    protected void initView() {
        ViewPager viewPager = mBingdingView.includeLayout.viewPagerContent;

        WanFragment wanFragment = (WanFragment) ARouter.getInstance().build(RouterManager.WAN_FRAGMENT).navigation();
        FilmFragment filmFragment = (FilmFragment) ARouter.getInstance().build(RouterManager.FILM_FRAGMENT).navigation();
        GankFragment gankFragment = (GankFragment) ARouter.getInstance().build(RouterManager.GANK_FRAGMENT).navigation();

        mFragmentList.add(wanFragment);
        mFragmentList.add(filmFragment);
        mFragmentList.add(gankFragment);

        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(adapter);
    }
}
