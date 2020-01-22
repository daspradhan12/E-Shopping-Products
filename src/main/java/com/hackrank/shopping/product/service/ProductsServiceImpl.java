package com.hackrank.shopping.product.service;

import com.hackrank.shopping.product.exception.ResourceNotFoundException;
import com.hackrank.shopping.product.model.Product;
import com.hackrank.shopping.product.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.ws.http.HTTPException;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductRepository productRepository;


//    public ProductsServiceImpl(ProductsRepository productsRepository) {
//        this.productsRepository = productsRepository;
//    }

    @Override
    public ResponseEntity addProduct(Product product) {

        if (!productRepository.existsById(product.getId())) {
            Product product1 = productRepository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product1);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    public ResponseEntity updateProduct(Product product, long productId) {
        try {
            Product retrievedProduct = productRepository.findById(productId).orElseThrow(Error::new);
            retrievedProduct.setAvailability(product.getAvailability());
            retrievedProduct.setCategory(product.getCategory());
            retrievedProduct.setDiscountedPrice(product.getDiscountedPrice());
            Product product1 = productRepository.save(retrievedProduct);
            return ResponseEntity.status(HttpStatus.OK).body(product1);
        } catch (Error error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                                 .orElseThrow((() -> new ResourceNotFoundException()));
    }

    @Override
    public @NotNull Iterable<Product> getAllProducts() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public @NotNull Iterable<Product> filterProductsByCategory(String category) {
        return productRepository.findByCategoryOrderByDiscountedPrice(category);
    }

    public @NotNull Iterable<Product> filterProduct(String category, Boolean availability) {
        return productRepository.findByCategoryAndAvailability(category, availability);
    }

}