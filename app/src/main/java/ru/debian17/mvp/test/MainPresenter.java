package ru.debian17.mvp.test;

import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Unit;
import ru.elmed.android.tools.domain.models.medorg.MedOrg;
import ru.elmed.android.tools.domain.usecases.medOrg.UpdateMedOrgsUseCase;

class MainPresenter extends BasePresenter<MainView> {

    private UpdateMedOrgsUseCase getMedOrgs = App.getUseCaseComponent().provideUpdateMedOrgsUseCase();
    private List<MedOrg> medOrgs;

    @Override
    protected void onFirstViewAttach(MainView view) {
        getMedOrgs();
    }

    void getMedOrgs() {
        view.switchToLoad();
        unsubscribeOnDestroy(getMedOrgs.execute(Unit.INSTANCE)
                .delay(15000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error));
    }

    private void success(List<MedOrg> medOrgs) {
        Log.e("LIST_SIZE", String.valueOf(medOrgs.size()));
        this.medOrgs = medOrgs;
        if (view != null) {
            view.switchToMain();
            view.onMedOrgsLoaded(this.medOrgs);
        }
    }

    private void error(Throwable throwable) {
        Log.e("LIST_SIZE", throwable.getMessage());
        if (view != null) {
            view.switchToMain();
            view.onError(throwable);
        }
    }

    public List<MedOrg> getListMedOrgs() {
        return medOrgs;
    }
}
