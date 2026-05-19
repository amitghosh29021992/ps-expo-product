package com.ps.expo.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;
import com.ps.expo.product.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Mock database using a simple Map
    private static final Map<String, Product> mockDatabase = new HashMap<>();

    static {
        mockDatabase.put("101", new Product("101", "Wireless Mouse", 29.99, "Ergonomic 2.4GHz mouse."));
        mockDatabase.put("102", new Product("102", "Mechanical Keyboard", 89.99, "RGB backlit blue-switch keyboard."));
        mockDatabase.put("103", new Product("103", "Gaming Monitor", 249.99, "27-inch 144Hz 1ms display."));
    }

    // GET Endpoint to fetch product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        Product product = mockDatabase.get(id);

        // Return 404 error if the product ID does not exist
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with ID: " + id);
        }

        return product;
    }
}
