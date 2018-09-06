package flikr.rumpilstilstkin.ru.myapplication.presenter.base;


import com.arellomobile.mvp.MvpView;

public interface BaseRestView extends MvpView {
    void startLoading();
    void hideLOading();
    void showError(String str);

}
