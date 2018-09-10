package flikr.rumpilstilstkin.ru.myapplication.presenter;


import flikr.rumpilstilstkin.ru.myapplication.presenter.base.BaseRestPresenter;
import io.reactivex.Flowable;


public class RealRestPresenter extends BaseRestPresenter<String> {

    @Override
    public void onNext(String s) {

    }

    public void update(){
        getViewState().startLoading();
        Flowable.just("", "")
                .subscribe(this);
    }
}
