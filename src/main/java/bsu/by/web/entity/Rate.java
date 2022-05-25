package bsu.by.web.entity;

public class Rate {
    private Double rating;
    private Integer imageId;
    private Integer userId;


    public Rate(Double rating, Integer imageId, Integer userId) {
        this.rating = rating;
        this.imageId = imageId;
        this.userId = userId;
    }

    public Rate(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
