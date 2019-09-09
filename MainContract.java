package com.example.dheo.myunittesting.Main;

import com.example.dheo.myunittesting.Base.BaseView;
import com.example.dheo.myunittesting.Model.MainModel;

public interface MainContract {

    interface MainPresenter {

    }

    interface MainView extends BaseView {
        void onshowVolume(MainModel model);
        void onError();

    }
}
