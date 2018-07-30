package ru.debian17.mvp;

import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends BaseView> {

    private CompositeDisposable subscriptions;
    protected V view;

    private boolean firstAttach;

    public BasePresenter() {
        subscriptions = new CompositeDisposable();
        firstAttach = true;
    }

    protected final void unsubscribeOnDestory(Disposable disposable) {
        subscriptions.add(disposable);
    }

    protected final void clearSubscriptions() {
        subscriptions.clear();
    }

    @CallSuper
    public void onDestroy() {
        subscriptions.clear();
    }

    @CallSuper
    public void onAttachView(V view) {
        this.view = view;
        if (firstAttach) {
            onFirstViewAttach(this.view);
            firstAttach = false;
        }
    }

    public void onFirstViewAttach(V view) {
        //override me!
    }

}
