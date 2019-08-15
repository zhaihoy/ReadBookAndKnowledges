package com.hongyuanzhai.myapplication.Presenter;

import com.hongyuanzhai.myapplication.Contract.BaseContract;

/**
 * RxJava虽然好用，但是总所周知，容易遭层内存泄漏。
 * 也就说在订阅了事件后没有及时取阅，导致在activity或者fragment销毁后仍然占用着内存，无法释放。
 * 而disposable便是这个订阅事件，可以用来取消订阅。
 * <p>
 * 一个disposable的容器，可以容纳多个disposable，添加和去除的复杂度为O(1)。
 * 如果这个CompositeDisposable容器已经是处于dispose的状态，那么所有加进来的disposable都会被自动切断。
 * 用CompositeDisposable来管理订阅事件disposable，然后在Activity/Fragment销毁的时候
 * ，调用compositeDisposable.dispose()就可以切断所有订阅事件，防止内存泄漏。
 */

public class RxBasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter {
    @Override
    public void attachView(Object view) {

    }

    @Override
    public void detachView(Object view) {

    }
}
