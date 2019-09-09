package com.example.dheo.myunittesting.Main;

import com.example.dheo.myunittesting.Base.BasePresenter;
import com.example.dheo.myunittesting.Model.MainModel;

public class MainPresenter implements BasePresenter<MainContract.MainView> {

    MainContract.MainView _view;


    public MainPresenter(MainContract.MainView _view) {

        this._view = _view;
    }


    @Override
    public void onAttach(MainContract.MainView view) {

    }

    @Override
    public void onDettach() {

    }



    public double volume(double length, double width, double height) {
        return length * width * height;
    }


    public void mcalculateVolume(double length, double width, double height) {
        double volume = volume(length, width, height);
        MainModel model = new MainModel(String.valueOf(volume));
        _view.onshowVolume(model);
    }
}