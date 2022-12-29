package com.example.retailcashier.servieces;

import com.example.retailcashier.models.Product;
import com.example.retailcashier.repositories.ProductRepository;
import com.example.retailcashier.servieces.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String createNewProduct(ProductDto productDto){

        Product product = new Product();
        product.setProductName(product.getProductName());
        product.setProductAmount(product.getProductAmount());
        productRepository.save(product);

        return "The Product Has Been Added";
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).get();
    }

    public Product updateProduct(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId()).get();
        product.setProductName(product.getProductName());
        product.setProductAmount(product.getProductAmount());
        return productRepository.save(product);

    }

    public String deleteProduct(Long id){

        productRepository.deleteById(id);

        return "The Product Has Been Deleted !!";
    }
}
