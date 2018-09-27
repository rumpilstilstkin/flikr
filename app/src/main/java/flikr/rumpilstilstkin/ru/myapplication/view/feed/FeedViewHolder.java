package flikr.rumpilstilstkin.ru.myapplication.view.feed;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import flikr.rumpilstilstkin.ru.myapplication.R;
import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;

public class FeedViewHolder extends RecyclerView.ViewHolder {

    private View root;
    private TextView description = root.findViewById(R.id.description);
    private ImageView image = root.findViewById(R.id.imageView);

    private FeedViewModel model;
    FeedAdapter.OnFeedClickListener listener;

    private FeedViewHolder(View view) {
        super(view);
        root = view;
        root.setOnClickListener(view1 -> {
                    if (listener != null) {
                        listener.onFeedClick(model.id);
                    }
                }
        );
    }

    public void bind(FeedViewModel model, FeedAdapter.OnFeedClickListener listener) {
        this.listener = listener;
        this.model = model;
        description.setText(model.description);
    }

    static FeedViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new FeedViewHolder(inflater.inflate(R.layout.item_feed, parent, false));
    }
}
