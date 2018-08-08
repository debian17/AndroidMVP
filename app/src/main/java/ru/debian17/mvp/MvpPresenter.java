package ru.debian17.mvp;

import android.support.annotation.CallSuper;

public class MvpPresenter<V extends MvpView> {

    protected V view;

    private boolean firstViewAttach;

    protected MvpPresenter() {
        firstViewAttach = true;
    }

    @CallSuper
    public void onDestroy() {
        view = null;
    }

    @CallSuper
    public void onAttachView(V view) {
        if (this.view == null && view != null) {
            this.view = view;
            if (firstViewAttach) {
                firstViewAttach = false;
                onFirstViewAttach(this.view);
            }
        }
    }

    @CallSuper
    public void onDetachView() {
        view = null;
    }

    protected void onFirstViewAttach(V view) {
        //override me!
    }

}
