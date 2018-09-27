package flikr.rumpilstilstkin.ru.myapplication.presenter.feed;


import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;
import flikr.rumpilstilstkin.ru.myapplication.presenter.base.BaseRestPresenter;

@InjectViewState
public class FeedPresenter extends BaseRestPresenter<Object, FeedView> {

    @Override
    public void attachView(FeedView view) {
        super.attachView(view);

        update();
    }

    @Override
    public void onNext(Object o) {

    }

    private void update(){
        List<FeedViewModel> items = new ArrayList<>();
        FeedViewModel feed = new FeedViewModel(1, "", "");
        feed.description = "some description";
        items.add(feed);
        getViewState().setItems(items);
    }
}
