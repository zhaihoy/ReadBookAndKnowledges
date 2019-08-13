package com.hongyuanzhai.myapplication.Base;

public class BaseContract {

    /**
     * @param <T> 传入范型进行页面的绑定和接触
     */
    interface BasePresenter<T> {

        void attachView(T view);

        void detachView(T view);
    }

    /**
     * 主要是页面具体具有的功能
     */
    interface BaseView {

        void showError();

        void completa();
    }

}
