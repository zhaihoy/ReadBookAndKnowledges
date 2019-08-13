package com.hongyuanzhai.myapplication.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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

public abstract class BaseFragment extends Fragment {

    private CompositeDisposable compositeDisposable;

    // 用RxJava做网络请求类
    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    // 也就是Activity 跟Fragment 彻底的解除绑定  在onDestroy方法之后调用 目的防止内存泄漏
    @Override
    public void onDetach() {
        super.onDetach();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 页面数据的处理
        initData();
        // 页面具体控件处理
        initDetail();
        //页面上可能存在的点击事件处理
        initClick();
        //页面上具体的逻辑处理
        initProcess();
    }

    protected abstract void initProcess();

    protected abstract void initClick();

    protected abstract void initDetail();

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int resourceID = getResourceID();
        return inflater.inflate(resourceID, container, false);
    }

    protected abstract int getResourceID();
}
