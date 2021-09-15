package pl.ib.produkty;

public class Product {
    private String name;
    private double price;
    private ProductCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }


    public ProductCategory getCategory() {
        return category;
    }


    public Product(String name, double price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

}
