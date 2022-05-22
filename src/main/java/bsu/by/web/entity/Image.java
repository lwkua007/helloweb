package bsu.by.web.entity;

public class Image {
    private Integer imageId;
    private String name;
    private String category;
    private String price;
    private Double rating;
    private Integer userId;
    private String location;


    public Image(String name, String category, String price, Integer userId, String location) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.userId = userId;
        this.location = location;
    }


    public Image(Integer imageId, String name, String category, String price, Double rating, String location) {
        this.imageId = imageId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.location = location;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
