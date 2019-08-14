package com.hongyuanzhai.myapplication.Base;

/**
 * @param <T> 创建BaseMVPFragment 是MVP模式下的Fragment 的基类
 */

public abstract class BaseMVPFragment<T extends BaseContract.BasePresenter> extends BaseFragment implements BaseContract.BaseView {


    protected T mPresenter;

    protected abstract T bindPresenter();


    @Override
    protected void initProcess() {
        mPresenter = bindPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView(this);
    }
}