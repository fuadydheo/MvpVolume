package com.example.dheo.myunittesting.Base;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);
    void onDettach();
}

