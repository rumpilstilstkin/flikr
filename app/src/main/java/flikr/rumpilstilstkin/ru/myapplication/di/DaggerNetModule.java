package flikr.rumpilstilstkin.ru.myapplication.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import flikr.rumpilstilstkin.ru.myapplication.data.Endpoins;
import flikr.rumpilstilstkin.ru.myapplication.data.ServiceGenerator;


@Module
public class DaggerNetModule {
    @Provides
    @Singleton
    Endpoins getEndpoins(){
        return new ServiceGenerator().createService(Endpoins.class);
    }
}

