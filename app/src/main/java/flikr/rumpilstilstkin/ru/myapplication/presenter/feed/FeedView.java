package flikr.rumpilstilstkin.ru.myapplication.presenter.feed;


import java.util.List;

import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;
import flikr.rumpilstilstkin.ru.myapplication.presenter.base.BaseRestView;


public interface FeedView extends BaseRestView {
    void setItems(List<FeedViewModel> items);
}
