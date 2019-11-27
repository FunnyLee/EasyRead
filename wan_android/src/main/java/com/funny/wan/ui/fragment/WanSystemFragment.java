package com.funny.wan.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.FragmentWanSystemBinding;
import com.funny.wan.viewModel.NoViewModel;

/**
 * Author: Funny
 * Time: 2019/11/5
 * Description: This is WanSystemFragment
 */
@Route(path = RouterManager.WAN_SYSTEM_FRAGMENT)
public class WanSystemFragment extends BaseFragment<NoViewModel, FragmentWanSystemBinding> {

    public static WanSystemFragment newInstance() {
        WanSystemFragment fragment = (WanSystemFragment) ARouter.getInstance().build(RouterManager.WAN_SYSTEM_FRAGMENT).navigation();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wan_system;
    }
}
