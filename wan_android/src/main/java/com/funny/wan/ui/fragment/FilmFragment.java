package com.funny.wan.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

/**
 * Author: Funny
 * Time: 2019/11/4
 * Description: This is FilmFragment
 */
@Route(path = RouterManager.FILM_FRAGMENT)
public class FilmFragment extends BaseFragment {

    public static FilmFragment newInstance() {

        FilmFragment fragment = (FilmFragment) ARouter.getInstance().build(RouterManager.FILM_FRAGMENT).navigation();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_film;
    }
}
