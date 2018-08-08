package ru.debian17.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class MvpAppCompatActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {

    protected P presenter;

    protected abstract P providePresenter();

    protected void restoreData(Bundle savedInstanceState) {
    }

    protected void saveData(Bundle outState) {
    }

    @LayoutRes
    protected abstract int getMainView();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getMainView());

        FragmentManager fm = getSupportFragmentManager();
        RetainedFragment<P> rf = (RetainedFragment) fm.findFragmentByTag(RetainedFragment.TAG);

        if (rf == null) {
            rf = new RetainedFragment<>();
            fm.beginTransaction()
                    .add(rf, RetainedFragment.TAG)
                    .commit();
            presenter = providePresenter();
            rf.setPresenter(presenter);
        } else {
            presenter = rf.getPresenter();
        }

        presenter.onAttachView(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveData(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreData(savedInstanceState);
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            presenter.onDetachView();
            presenter.onDestroy();
        } else {
            presenter.onDetachView();
        }
    }

}
