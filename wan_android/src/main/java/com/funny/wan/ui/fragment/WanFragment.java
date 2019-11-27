package com.funny.wan.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.base.ViewPagerFragmentAdapter;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.FragmentWanBinding;
import com.funny.wan.viewModel.NoViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Funny
 * Time: 2019/11/4
 * Description: This is WanFragment
 */
@Route(path = RouterManager.WAN_FRAGMENT)
public class WanFragment extends BaseFragment<NoViewModel, FragmentWanBinding> {

    private ViewPager mViewPager;

    public static WanFragment newInstance() {
        WanFragment fragment = (WanFragment) ARouter.getInstance().build(RouterManager.WAN_FRAGMENT).navigation();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wan;
    }

    @Override
    protected void initView() {
        TabLayout tabLayout = mBindingView.tabLayout;
        mViewPager = mBindingView.viewPager;
        initFragment();
        tabLayout.setupWithViewPager(mViewPager);
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

        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), fragmentList, titleList);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(adapter);
    }
}
