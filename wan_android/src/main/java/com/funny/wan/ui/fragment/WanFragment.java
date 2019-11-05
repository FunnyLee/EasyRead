package com.funny.wan.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.FragmentWanBinding;
import com.funny.wan.viewModel.NoViewModel;

/**
 * Author: Funny
 * Time: 2019/11/4
 * Description: This is WanFragment
 */
@Route(path = RouterManager.WAN_FRAGMENT)
public class WanFragment extends BaseFragment<NoViewModel, FragmentWanBinding> {

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
        ViewPager viewPager = mBindingView.viewPager;


    }
}
