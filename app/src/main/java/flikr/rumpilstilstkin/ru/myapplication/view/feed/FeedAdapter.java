package flikr.rumpilstilstkin.ru.myapplication.view.feed;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;


public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private ArrayList<FeedViewModel> data = new ArrayList<>();
    private OnFeedClickListener listener;

    FeedAdapter(OnFeedClickListener listener){
        super();
        this.listener = listener;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FeedViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        holder.bind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<FeedViewModel> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public interface OnFeedClickListener{
        void onFeedClick(long id);
    }
}
