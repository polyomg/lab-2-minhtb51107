package poly.edu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.model.Product;

@Controller
public class ProductController {

	@GetMapping("/product/form")
	public String form(Model model) {
	    Product p = new Product("iPhone 30", 5000.0);
	    model.addAttribute("product", p); // Đổi từ "p1" sang "product"
	    return "product/form";
	}

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product p) { // ?2
        return "product/form";
    }

    @ModelAttribute("items") // ?3
    public List<Product> getItems() {
        return Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
        );
    }
}
