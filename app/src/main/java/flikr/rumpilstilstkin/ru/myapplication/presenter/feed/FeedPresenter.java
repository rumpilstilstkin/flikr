package flikr.rumpilstilstkin.ru.myapplication.presenter.feed;


import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;

import javax.inject.Inject;

import flikr.rumpilstilstkin.ru.myapplication.MainApp;
import flikr.rumpilstilstkin.ru.myapplication.data.model.realm.FeedModel;
import flikr.rumpilstilstkin.ru.myapplication.data.model.view.FeedViewModel;
import flikr.rumpilstilstkin.ru.myapplication.data.usecases.FeedUsecases;
import flikr.rumpilstilstkin.ru.myapplication.presenter.base.BaseRestPresenter;
import io.realm.Realm;
import io.realm.RealmResults;


@InjectViewState
public class FeedPresenter extends BaseRestPresenter<Integer, FeedView> {

    @Inject
    FeedUsecases usecases;

    Realm realm;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        realm = Realm.getDefaultInstance();
        MainApp.getComponent().injectsToFeedPresenter(this);
        update();
    }

    @Override
    public void attachView(FeedView view) {
        super.attachView(view);
        setData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onNext(Integer o) {
        setData();
    }

    private void update() {
        usecases.getFeed().subscribe(this);
    }

    private void setData() {
        RealmResults<FeedModel> feed = realm.where(FeedModel.class).findAll();
        ArrayList<FeedViewModel> result = new ArrayList<FeedViewModel>();
        for (FeedModel curItem : feed) {
            result.add(new FeedViewModel(curItem));
        }
        getViewState().setItems(result);
    }
}
