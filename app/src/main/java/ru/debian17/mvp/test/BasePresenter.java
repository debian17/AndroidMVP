package ru.debian17.mvp.test;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.debian17.mvp.MvpPresenter;
import ru.debian17.mvp.MvpView;

public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {

    private CompositeDisposable subscriptions;

    protected BasePresenter() {
        subscriptions = new CompositeDisposable();
    }

    protected void unsubscribeOnDestroy(Disposable disposable) {
        subscriptions.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }

}
