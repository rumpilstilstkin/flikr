package flikr.rumpilstilstkin.ru.myapplication.view.feed;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import flikr.rumpilstilstkin.ru.myapplication.R;
import flikr.rumpilstilstkin.ru.myapplication.data.model.view.FeedViewModel;
import flikr.rumpilstilstkin.ru.myapplication.presenter.feed.FeedPresenter;
import flikr.rumpilstilstkin.ru.myapplication.presenter.feed.FeedView;


public class FeedFragment extends MvpAppCompatFragment implements
                                                       FeedView,
                                                       FeedAdapter.Listener {

    @InjectPresenter
    FeedPresenter presenter;

    @BindView(R.id.feed_list)
    RecyclerView feedList;

    private FeedAdapter adapter = new FeedAdapter(this);

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        feedList.setAdapter(adapter);
    }

    @Override
    public void setItems(List<FeedViewModel> items) {
        adapter.setItems(items);
    }

    @Override
    public void hideLOading() {
        //hide loading
    }

    @Override
    public void showError(String str) {
        //show error
    }

    @Override
    public void startLoading() {
        //show loading
    }

    @Override
    public void onFeedClick(long id) {
        //go to details
    }
}
