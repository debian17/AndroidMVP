package ru.debian17.mvp.test;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ru.debian17.mvp.MvpAppCompatActivity;
import ru.debian17.mvp.R;

public class MainActivity extends MvpAppCompatActivity<MainPresenter> implements MainView {

    private String a;

    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("A", String.valueOf(presenter.getA()));
    }

    @Override
    protected void saveData(Bundle outState) {
        outState.putString("key", a);
    }

    @Override
    public void restoreData(Bundle savedInstanceState) {
        Log.e("restoreData", String.valueOf(presenter.list.size()));
        a = savedInstanceState.getString("key");
        Log.e("restoreData", a);
    }

    @Override
    public void onListLoaded(List<Integer> list) {
        Log.e("LIST_SIZE", String.valueOf(list.size()));
        a = "YESSS";
    }
}
