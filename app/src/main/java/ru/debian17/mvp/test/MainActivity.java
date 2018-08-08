package ru.debian17.mvp.test;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Unit;
import ru.debian17.mvp.MvpAppCompatActivity;
import ru.debian17.mvp.R;
import ru.debian17.mvp.State;
import ru.elmed.android.tools.domain.models.medorg.MedOrg;
import ru.elmed.android.tools.domain.usecases.medOrg.GetMedOrgsUseCase;

public class MainActivity extends MvpAppCompatActivity<MainPresenter> implements MainView {

    private TextView textView;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = findViewById(R.id.tvTest);
    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getMainView() {
        return R.layout.activity_main;
    }

    @Override
    public void onMedOrgsLoaded(List<MedOrg> medOrgs) {
        Log.e("MainActivity_LOADED", String.valueOf(medOrgs.size()));
        textView.setText("MAIN" + String.valueOf(medOrgs.size()));
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e("ERROR", throwable.getMessage());
        textView.setText(throwable.getMessage());
    }

    @Override
    public void switchToLoad() {

    }

    @Override
    public void switchToMain() {

    }

}
