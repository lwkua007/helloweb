package bsu.by.web.entity;


public class Image {
    private Integer imageId;
    private String name;
    private String category;
    private Double price;
    private Double rating;

    public Image(Integer imageId, String name, String category, Double price, Double rating) {
        this.imageId = imageId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
