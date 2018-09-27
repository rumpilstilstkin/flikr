package flikr.rumpilstilstkin.ru.myapplication.model;


public class FeedViewModel {
    public int id;
    public String imageUrl;
    public String description;

    public FeedViewModel(int id, String image, String description){
        this.id = id;
        this.imageUrl = image;
        this.description = description;
    }
}
