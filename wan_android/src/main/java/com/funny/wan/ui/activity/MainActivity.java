package com.funny.wan.ui.activity;

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
import com.funny.wan.ui.fragment.FilmFragment;
import com.funny.wan.ui.fragment.GankFragment;
import com.funny.wan.ui.fragment.WanFragment;
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

    public static void start() {
        ARouter.getInstance().build(RouterManager.MAIN_ACTIVITY).navigation();
    }

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

        WanFragment wanFragment = WanFragment.newInstance();
        FilmFragment filmFragment = FilmFragment.newInstance();
        GankFragment gankFragment = GankFragment.newInstance();

        mFragmentList.add(wanFragment);
        mFragmentList.add(filmFragment);
        mFragmentList.add(gankFragment);

        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
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

        mOneTitleIv.setOnClickListener(v -> {
            if (mViewPager.getCurrentItem() != 0) {
                setCurrentTitle(0);
            }
        });
        mTwoTitleIv.setOnClickListener(v -> {
            if (mViewPager.getCurrentItem() != 1) {
                setCurrentTitle(1);
            }
        });

        mThreeTitleIv.setOnClickListener(v -> {
            if (mViewPager.getCurrentItem() != 2) {
                setCurrentTitle(2);
            }
        });
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
