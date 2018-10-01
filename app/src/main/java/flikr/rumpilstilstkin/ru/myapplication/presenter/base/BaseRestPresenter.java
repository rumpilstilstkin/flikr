package flikr.rumpilstilstkin.ru.myapplication.presenter.base;


import com.arellomobile.mvp.MvpPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


public abstract class BaseRestPresenter<T, V extends BaseRestView> extends MvpPresenter<V> implements Subscriber<T> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onComplete() {
        getViewState().hideLOading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        getViewState().showError(e.getLocalizedMessage());
    }
}
