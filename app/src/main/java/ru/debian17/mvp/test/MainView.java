package ru.debian17.mvp.test;

import java.util.List;

import ru.debian17.mvp.MvpView;
import ru.elmed.android.tools.domain.models.medorg.MedOrg;

public interface MainView extends MvpView {

    void onMedOrgsLoaded(List<MedOrg> medOrgs);

    void onError(Throwable throwable);

    void switchToLoad();

    void switchToMain();

}
