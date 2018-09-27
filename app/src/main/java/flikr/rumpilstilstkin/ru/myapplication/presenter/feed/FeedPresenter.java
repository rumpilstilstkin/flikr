package flikr.rumpilstilstkin.ru.myapplication.presenter.feed;


import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import flikr.rumpilstilstkin.ru.myapplication.MainApp;
import flikr.rumpilstilstkin.ru.myapplication.data.Endpoins;
import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;
import flikr.rumpilstilstkin.ru.myapplication.presenter.base.BaseRestPresenter;


@InjectViewState
public class FeedPresenter extends BaseRestPresenter<Object, FeedView> {

    @Inject
    Endpoins netApi;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        MainApp.getComponent().injectsToFeedPresenter(this);
    }

    @Override
    public void attachView(FeedView view) {
        super.attachView(view);

        update();
    }

    @Override
    public void onNext(Object o) {

    }

    private void update() {
        List<FeedViewModel> items = new ArrayList<>();
        FeedViewModel feed = new FeedViewModel(1, "", "");
        feed.description = "some description";
        items.add(feed);
        getViewState().setItems(items);
    }
}
