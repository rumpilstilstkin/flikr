package flikr.rumpilstilstkin.ru.myapplication.di;


import dagger.Module;
import dagger.Provides;
import flikr.rumpilstilstkin.ru.myapplication.data.Endpoins;
import flikr.rumpilstilstkin.ru.myapplication.data.ServiceGenerator;


@Module
public class DaggerNetModule {
    @Provides
    Endpoins getEndpoins(){
        return new ServiceGenerator().createService(Endpoins.class);
    }
}

