package com.funny.component.router;

/**
 * Author: Funny
 * Time: 2019/7/25
 * Description: This is ARouter路径管理类
 */
public class RouterManager {

    public static final String MAIN_ACTIVITY = "/home/MainActivity";

    public static final String WAN_FRAGMENT = "/home/WanFragment";

    public static final String GANK_FRAGMENT = "/home/GankFragment";

    public static final String FILM_FRAGMENT = "/home/FilmFragment";

    /**
     * wanAndroid
     */
    public static final String GROUP_WAN_ANDROID = "/group_wan_android/";

    public static final String WAN_MIAN_FRAGMENT = GROUP_WAN_ANDROID + "WanMainFragment";

    public static final String WAN_NAVIGATION_FRAGMENT = GROUP_WAN_ANDROID + "WanNavigationFragment";

    public static final String WAN_PUBLIC_FRAGMENT = GROUP_WAN_ANDROID + "WanPublicFragment";

    public static final String WAN_SYSTEM_FRAGMENT = GROUP_WAN_ANDROID + "WanSystemFragment";


}
