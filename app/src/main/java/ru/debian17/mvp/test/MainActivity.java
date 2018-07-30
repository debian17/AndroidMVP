package ru.debian17.mvp.test;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ru.debian17.mvp.BaseActivity;
import ru.debian17.mvp.R;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    public void restoreView() {
        Log.e("restoreView", String.valueOf(presenter.list.size()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("A", String.valueOf(presenter.getA()));

    }

    @Override
    public void onListLoaded(List<Integer> list) {
        Log.e("LIST_SIZE", String.valueOf(list.size()));
    }
}
