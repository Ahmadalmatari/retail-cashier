package com.example.retailcashier.controllers;

import com.example.retailcashier.models.Product;
import com.example.retailcashier.servieces.ProductService;
import com.example.retailcashier.servieces.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Product findProductById(@RequestParam Long id){

        log.debug("Find Product By Id");
        return productService.getProduct(id);
    }

    @PostMapping
    public String createProduct(@RequestBody ProductDto productDto){

        log.debug("Create New Product");
        return productService.createNewProduct(productDto);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody ProductDto productDto){

        log.debug("Update Product");
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){

        log.debug("Delete Product");
        return productService.deleteProduct(id);
    }
}
