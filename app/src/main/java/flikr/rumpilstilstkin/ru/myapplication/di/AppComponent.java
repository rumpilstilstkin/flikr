package flikr.rumpilstilstkin.ru.myapplication.di;


import dagger.Component;
import flikr.rumpilstilstkin.ru.myapplication.presenter.feed.FeedPresenter;


@Component(modules = {DaggerNetModule.class})
public interface AppComponent {
    void injectsToFeedPresenter(FeedPresenter presenter);
}

