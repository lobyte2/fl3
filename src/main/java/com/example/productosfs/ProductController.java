package com.example.productosfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // get retorna lista de productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // post permite agregar un nuevo producto
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    //delete
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable java.util.UUID id) {

        productRepository.deleteById(id);
    }
}