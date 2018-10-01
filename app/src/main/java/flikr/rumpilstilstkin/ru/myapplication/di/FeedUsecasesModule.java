package flikr.rumpilstilstkin.ru.myapplication.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import flikr.rumpilstilstkin.ru.myapplication.data.Endpoins;
import flikr.rumpilstilstkin.ru.myapplication.data.usecases.FeedUsecases;


@Module
public class FeedUsecasesModule {

    @Provides
    @Singleton
    FeedUsecases feedUsecases(Endpoins endpoins) {
        return new FeedUsecases(endpoins);
    }
}
