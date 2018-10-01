package flikr.rumpilstilstkin.ru.myapplication;


import android.app.Application;

import com.crashlytics.android.Crashlytics;
import flikr.rumpilstilstkin.ru.myapplication.di.AppComponent;
import flikr.rumpilstilstkin.ru.myapplication.di.DaggerAppComponent;
import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);

        component = DaggerAppComponent.builder().build();
    }


    public static AppComponent getComponent() {
        return component;
    }
}

