package com.hongyuanzhai.myapplication.Contract;

public class BaseContract {

    /**
     * @param <T> 传入范型进行页面的绑定和接触
     */
    public interface BasePresenter<T> {

        void attachView(T view);

        void detachView(T view);
    }

    /**
     * 主要是页面具体具有的功能
     */
    public interface BaseView {

        void showError();

        void completa();
    }

}
