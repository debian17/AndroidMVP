package ru.debian17.mvp.test;

import android.util.Log;

import java.util.ArrayList;

import ru.debian17.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    private int a = 0;

    public ArrayList<Integer> list = new ArrayList<>();

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

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        view.onListLoaded(list);
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
