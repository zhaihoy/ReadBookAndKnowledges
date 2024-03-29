package com.hongyuanzhai.myapplication.Contract;

import com.hongyuanzhai.myapplication.Bean.CollBookBean;

import java.util.List;

/**
 * 将View和Presenter进行关联
 */


public class BookShelfContract {
    public interface View extends BaseContract.BaseView {
        //定义页面刷新和加载的方法
        void finishRefresh(List<CollBookBean> collBookBeans);
        void finishUpdate();
        void showErrorTip(String error);
    }

    public interface Presenter extends BaseContract.BasePresenter<BookShelfContract.View> {
        //网络加载
        void refreshCollBooks();
        void createDownloadTask(CollBookBean collBookBean);
        void updateCollBooks(List<CollBookBean> collBookBeans);
        void loadRecommendBooks(String gender);
    }

}
