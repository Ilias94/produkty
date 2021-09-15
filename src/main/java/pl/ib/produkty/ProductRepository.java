package pl.ib.produkty;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepository {
    private final ArrayList<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("mleko", 2.85, ProductCategory.FOOD));
        products.add(new Product("telewizor", 1600, ProductCategory.AGD));
        products.add(new Product("rękawice bokserskie", 410, ProductCategory.OTHER));
        products.add(new Product("chleb", 3.1, ProductCategory.FOOD));
        products.add(new Product("lodówka", 2300, ProductCategory.AGD));
        products.add(new Product("rolki", 799, ProductCategory.OTHER));
    }

    public ArrayList<Product> findByCategory(ProductCategory category) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public ArrayList<Product> findAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }
}
