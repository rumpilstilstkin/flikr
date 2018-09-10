package flikr.rumpilstilstkin.ru.myapplication.presenter.base.feed;


import java.util.List;

import flikr.rumpilstilstkin.ru.myapplication.presenter.base.BaseRestView;
import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;


interface FeedView extends BaseRestView {
    void setItems(List<FeedViewModel> items);
}
