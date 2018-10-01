package flikr.rumpilstilstkin.ru.myapplication.data.model.view;


import flikr.rumpilstilstkin.ru.myapplication.data.model.realm.FeedModel;


public class FeedViewModel {
    public int id;
    public String imageUrl;
    public String description;

    public FeedViewModel(int id, String image, String description) {
        this.id = id;
        this.imageUrl = image;
        this.description = description;
    }

    public FeedViewModel(FeedModel model) {
        this(model.id, model.imageUrl, model.description);
    }
}
