package ru.debian17.mvp.test;

import android.util.Log;

import ru.debian17.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    private int a = 0;

    private void plusA() {
        a += 1;
    }

    public int getA() {
        return a;
    }

    @Override
    public void onFirstViewAttach(MainView view) {
        Log.e("MainPresenter", "onFirstViewAttach");
        plusA();
    }

    @Override
    public void onAttachView(MainView view) {
        super.onAttachView(view);
        Log.e("MainPresenter", "onAttachView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MainPresenter", "onDestroy");
    }
}
