package flikr.rumpilstilstkin.ru.myapplication.data;


import java.util.List;

import flikr.rumpilstilstkin.ru.myapplication.data.model.realm.FeedModel;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Endpoins {

    @GET("/repositories")
    Flowable<List<FeedModel>> getFeed();
}
