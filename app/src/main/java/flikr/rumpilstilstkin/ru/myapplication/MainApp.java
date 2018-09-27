package flikr.rumpilstilstkin.ru.myapplication;


import android.app.Application;

import flikr.rumpilstilstkin.ru.myapplication.di.AppComponent;
import flikr.rumpilstilstkin.ru.myapplication.di.DaggerAppComponent;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);

        component = DaggerAppComponent.create();
    }


    public static AppComponent getComponent() {
        return component;
    }
}

