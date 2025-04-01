package com.hw.service;



import com.hw.model.dto.Product;
import com.hw.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }


    public void addProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public void updateProduct(int id, Product product) {
        product.setId(id); // Устанавливаем ID для обновления
        productRepository.saveProduct(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }
}
