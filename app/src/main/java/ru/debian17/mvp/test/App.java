package ru.debian17.mvp.test;

import ru.elmed.android.tools.app.ElMedApplication;
import ru.elmed.android.tools.app.di.components.AppComponent;
import ru.elmed.android.tools.app.di.components.UseCaseComponent;

public class App extends ElMedApplication {

    private static AppComponent appComponent;
    private static UseCaseComponent useCaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = ElMedApplication.Companion.getAppComponent();
        useCaseComponent = ElMedApplication.Companion.getUseCaseComponent();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static UseCaseComponent getUseCaseComponent() {
        return useCaseComponent;
    }
}
