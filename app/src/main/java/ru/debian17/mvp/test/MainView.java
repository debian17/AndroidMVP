package ru.debian17.mvp.test;

import java.util.List;

import ru.debian17.mvp.BaseView;

public interface MainView extends BaseView {

    void onListLoaded(List<Integer> list);

}
