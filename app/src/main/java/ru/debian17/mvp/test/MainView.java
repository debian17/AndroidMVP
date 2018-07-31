package ru.debian17.mvp.test;

import java.util.List;

import ru.debian17.mvp.MvpView;

public interface MainView extends MvpView {

    void onListLoaded(List<Integer> list);

}
