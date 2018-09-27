package flikr.rumpilstilstkin.ru.myapplication.data;


import flikr.rumpilstilstkin.ru.myapplication.model.FeedViewModel;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Endpoins {

    @GET("/users/{user}")
    Flowable<FeedViewModel> getUser(
            @Path("user") String user);
}
