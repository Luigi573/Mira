package com.luigi573.mira.base;

public interface BasePresenter<T extends BaseView> {

    void takeView(T view);

    void dropView();
}
