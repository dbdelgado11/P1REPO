package com.newrev.p1.services;

import com.newrev.p1.model.Product;
import com.newrev.p1.repository.ProductRepository;
import com.newrev.p1.utilities.CheckNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Autowired()
    CheckNumber checkNumber;

    @Override
    public boolean addProduct(Product product) {
        LOGGER.info("Adding product in service");
        if (checkNumber.checkNegativeInt(product.getQoh(), product.getPrice())) {
            productRepository.save(product);
            return true;

        } else {
            LOGGER.warn("Failed to save product since price or qoh is negative");
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        if (checkNumber.checkNegativeInt(product.getQoh(), product.getPrice())) {
            productRepository.save(product);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Product getProduct(int productId) {
        Product pr = productRepository.getById(productId);
        return pr;
    }

    @Override
    public Boolean isProductExists(Integer productId) {
        return productRepository.existsById(productId);
    }


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //by default these are not exposed

    @Override
    public List<Product> getProduct(String productName) {
        return productRepository.getProductByName(productName);
    }

    @Override
    public List<Product> filterProductByPrice(int minimumPrice, int maximumPrice) {
        return productRepository.findByPriceBetween(minimumPrice,maximumPrice);
    }

    @Override
    public List<Product> getProductByPrice(int price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> getProductByQoh(int qoh) {
        return productRepository.findByQoh(qoh);
    }

    @Override
    public List<Product> getProductByGreaterQoh(int greaterQoh) {
        return null;
    }

    @Override
    public List<Product> getProductByLessQoh(int qoh) {
        return getProductByLessQoh(qoh);
    }
}
