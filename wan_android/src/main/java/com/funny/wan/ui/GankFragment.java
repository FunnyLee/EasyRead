package com.funny.wan.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

/**
 * Author: Funny
 * Time: 2019/11/4
 * Description: This is GankFragment
 */
@Route(path = RouterManager.GANK_FRAGMENT)
public class GankFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }
}
