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
    public static final String GROUP_WAN_ANDROID = "/group_wan_android";

    public static final String WAN_ANDROID_MAIN_ACTIVITY = GROUP_WAN_ANDROID + "/WanAndroidMainActivity";

    public static final String HOME_FRAGMENT = GROUP_WAN_ANDROID + "/HomeFragment";

    public static final String PROJECT_FRAGMENT = GROUP_WAN_ANDROID + "/ProjectFragment";

    public static final String PROJECT_CONTENT_FRAGMENT = GROUP_WAN_ANDROID + "/ProjectContentFragment";

    public static final String SYSTEM_FRAGMENT = GROUP_WAN_ANDROID + "/SystemFragment";

    public static final String SYSTEM_CONTENT_FRAGMENT = GROUP_WAN_ANDROID + "/SystemContentFragment";

    public static final String NAVIGATION_CONTENT_RAGMENT = GROUP_WAN_ANDROID + "/NavigationContentFragment";

    public static final String ARTICLE_WEBVIEW_ACTIVITY = GROUP_WAN_ANDROID + "/ArticleWebViewActivity";

}
