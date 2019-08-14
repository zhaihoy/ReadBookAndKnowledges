package com.hongyuanzhai.myapplication.Contract;

import com.hongyuanzhai.myapplication.Base.BaseContract;

/**
 * 将View和Presenter进行关联
 */


public class BookShelfContract {
    public interface View extends BaseContract.BaseView {
        //定义页面刷新和加载的方法
    }

    public interface Presenter<View> extends BaseContract.BasePresenter<BookShelfContract.View> {
        //定义页面处理逻辑
    }

}
