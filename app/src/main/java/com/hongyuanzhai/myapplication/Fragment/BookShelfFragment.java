package com.hongyuanzhai.myapplication.Fragment;

import androidx.fragment.app.Fragment;

import com.hongyuanzhai.myapplication.Base.BaseMVPFragment;
import com.hongyuanzhai.myapplication.Contract.BookShelfContract;

public class BookShelfFragment extends BaseMVPFragment<BookShelfContract.Presenter> implements BookShelfContract.View{
    @Override
    protected BookShelfContract.Presenter bindPresenter() {
        return null;
    }

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
    protected int getResourceID() {
        return 0;
    }
}
