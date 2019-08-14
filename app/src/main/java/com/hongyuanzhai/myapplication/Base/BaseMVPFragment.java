package com.hongyuanzhai.myapplication.Base;

/**
 *
 * @param <T>  创建BaseMVPFragment 是MVP模式下的Fragment 的基类
 */

public abstract class BaseMVPFragment<T extends BaseContract.BasePresenter> extends BaseFragment implements BaseContract.BaseView {
    @Override
    public void showError() {

    }

    @Override
    public void completa() {

    }

    @Override
    protected void initProcess() {

    }

    @Override
    protected void initClick() {

    }

    @Override
    protected void initDetail() {

    }

    @Override
    protected void initData() {

    }

}
