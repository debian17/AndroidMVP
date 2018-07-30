package ru.debian17.mvp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

@SuppressWarnings("unchecked")
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter;

    public abstract P providePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();

        RetainedFragment<P> rf = (RetainedFragment) fm.findFragmentByTag(RetainedFragment.TAG);

        if (rf == null) {
            presenter = providePresenter();
            rf = new RetainedFragment<>();
            fm.beginTransaction()
                    .add(rf, RetainedFragment.TAG)
                    .commit();
            rf.setPresenter(presenter);
        } else {
            presenter = rf.getPresenter();
        }
        presenter.onAttachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            presenter.onDestroy();
        }
    }
}
