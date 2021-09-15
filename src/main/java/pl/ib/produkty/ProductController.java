package pl.ib.produkty;

import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/lista")
    public String allProducts(@RequestParam(value = "kategoria", required = false) ProductCategory category, Model model) {
        ArrayList<Product> products;
        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);

        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        model.addAttribute("priceSum", sum);
        return "list"; // ->/resources/templetes/list.html
    }

    @PostMapping("/dodaj")
    public String add(@RequestParam String name,
                      @RequestParam double price,
                      @RequestParam ProductCategory category) {
        Product product = new Product(name, price, category);
        productRepository.add(product);
        return "redirect:/lista";
    }

}
