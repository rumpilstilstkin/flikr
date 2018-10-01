package flikr.rumpilstilstkin.ru.myapplication.di;


import javax.inject.Singleton;

import dagger.Component;
import flikr.rumpilstilstkin.ru.myapplication.data.usecases.FeedUsecases;
import flikr.rumpilstilstkin.ru.myapplication.presenter.feed.FeedPresenter;


@Singleton
@Component(modules={DaggerNetModule.class, FeedUsecasesModule.class})
public interface AppComponent {
    FeedUsecases feedUsecases();

    void injectsToFeedPresenter(FeedPresenter presenter);
}

