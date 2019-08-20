package com.hongyuanzhai.myapplication.Fragment;

import com.hongyuanzhai.myapplication.Base.BaseMVPFragment;
import com.hongyuanzhai.myapplication.Bean.CollBookBean;
import com.hongyuanzhai.myapplication.Contract.BookShelfContract;
import com.hongyuanzhai.myapplication.R;

import java.util.List;

public class BookShelfFragment extends BaseMVPFragment<BookShelfContract.Presenter> implements BookShelfContract.View {

    @Override
    public void showError() {

    }

    @Override
    public void completa() {

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

    @Override
    protected int getResourceID()
    {
        System.out.println("=======初始化布局==");
        return R.layout.fragment_bookshelf;
    }

    // 进行presenter绑定
    @Override
    protected BookShelfContract.Presenter bindPresenter() {
        // 进行Presenter的与View的绑定 --->基类中完成

        return null;
    }

    @Override
    public void finishRefresh(List<CollBookBean> collBookBeans) {

    }

    @Override
    public void finishUpdate() {

    }

    @Override
    public void showErrorTip(String error) {

    }
}
