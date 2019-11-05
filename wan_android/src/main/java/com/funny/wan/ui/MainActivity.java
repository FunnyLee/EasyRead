package com.funny.wan.ui;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseActivity;
import com.funny.component.base.BaseFragment;
import com.funny.component.base.ViewPagerFragmentAdapter;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityMainBinding;
import com.funny.wan.databinding.LayoutContentViewBinding;
import com.funny.wan.viewModel.MainViewModel;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

@Route(path = RouterManager.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private ViewPager mViewPager;
    private ImageView mOneTitleIv;
    private ImageView mTwoTitleIv;
    private ImageView mThreeTitleIv;

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
        LayoutContentViewBinding includeLayout = mBingdingView.includeLayout;
        mViewPager = includeLayout.viewPagerContent;
        mOneTitleIv = includeLayout.oneTitleIv;
        mTwoTitleIv = includeLayout.twoTitleIv;
        mThreeTitleIv = includeLayout.threeTitleIv;

        WanFragment wanFragment = (WanFragment) ARouter.getInstance().build(RouterManager.WAN_FRAGMENT).navigation();
        FilmFragment filmFragment = (FilmFragment) ARouter.getInstance().build(RouterManager.FILM_FRAGMENT).navigation();
        GankFragment gankFragment = (GankFragment) ARouter.getInstance().build(RouterManager.GANK_FRAGMENT).navigation();

        mFragmentList.add(wanFragment);
        mFragmentList.add(filmFragment);
        mFragmentList.add(gankFragment);

        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);

        setCurrentTitle(0);
    }

    @Override
    protected void initEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setCurrentTitle(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mOneTitleIv.setOnClickListener(v -> setCurrentTitle(0));
        mTwoTitleIv.setOnClickListener(v -> setCurrentTitle(1));
        mThreeTitleIv.setOnClickListener(v -> setCurrentTitle(2));
    }

    private void setCurrentTitle(int position) {
        boolean isOne = false;
        boolean isTwo = false;
        boolean isThree = false;
        switch (position) {
            case 0:
                isOne = true;
                break;
            case 1:
                isTwo = true;
                break;
            case 2:
                isThree = true;
                break;
            default:
                isOne = true;
                break;
        }
        mOneTitleIv.setSelected(isOne);
        mTwoTitleIv.setSelected(isTwo);
        mThreeTitleIv.setSelected(isThree);
        mViewPager.setCurrentItem(position);
    }
}
