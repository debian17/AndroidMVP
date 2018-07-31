package ru.debian17.mvp;

import android.support.annotation.CallSuper;

public class MvpPresenter<V extends MvpView> {

    protected V view;

    private boolean firstViewAttach;

    public MvpPresenter() {
        firstViewAttach = true;
    }

    @CallSuper
    public void onDestroy() {
        view = null;
    }

    @CallSuper
    public void onAttachView(V view) {
        this.view = view;
        if (firstViewAttach) {
            onFirstViewAttach(this.view);
            firstViewAttach = false;
        }
    }

    @CallSuper
    public void onDetachView() {
        view = null;
    }

    public void onFirstViewAttach(V view) {
        //override me!
    }

}
