package flikr.rumpilstilstkin.ru.myapplication.data.usecases;


import flikr.rumpilstilstkin.ru.myapplication.data.Endpoins;
import flikr.rumpilstilstkin.ru.myapplication.data.model.realm.FeedModel;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;


public class FeedUsecases {

    private Endpoins endpoints;

    public FeedUsecases(Endpoins endpoints) {
        this.endpoints = endpoints;
    }

    public Flowable<Integer> getFeed() {

        return endpoints
                .getFeed()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(feedModels -> {
                    Realm realm = Realm.getDefaultInstance();
                    realm.executeTransactionAsync(realm1 -> {
                        int i = 0;
                        for (FeedModel curItem : feedModels) {
                            curItem.id = i;
                            realm1.copyToRealmOrUpdate(curItem);
                            i++;
                        }
                    });

                    realm.close();
                    return feedModels.size();
                });
    }
}
