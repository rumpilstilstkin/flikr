package flikr.rumpilstilstkin.ru.myapplication.presenter.base;


import com.arellomobile.mvp.MvpPresenter;

import rx.Observer;

abstract class BaseRestPresenter<T> extends MvpPresenter<BaseRestView> implements Observer<T> {

    @Override
    public void onCompleted() {
        getViewState().hideLOading();
    }

    @Override
    public void onError(Throwable e) {
        getViewState().showError(e.getLocalizedMessage());
    }
}
