package com.hongyuanzhai.myapplication.Presenter;

import com.hongyuanzhai.myapplication.Contract.BookShelfContract;

/**
 * BookShelfPresenter  进行数据的加载的类，进行数据的加载  （BasePresenter）Presenter --  View bind ，
 * 并且也要注意的是应该实现的是改类的 Presenter 和 View
 */
public class BookShelfPresenter extends RxBasePresenter<BookShelfContract.View> implements BookShelfContract.Presenter {
}
