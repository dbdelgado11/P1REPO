package com.newrev.p1.services;



import com.newrev.p1.model.Product;

import java.util.List;

public interface ProductService {
    public boolean addProduct(Product product);
    public boolean deleteProduct(int productId);
    public boolean updateProduct(Product product);
    public Product getProduct(int productId);
    public Boolean isProductExists(Integer productId);
    public List<Product> getProduct(String productName);
    public List<Product> getProducts();

    public List<Product> filterProductByPrice(int minimumPrice,int maximumPrice);
    public List<Product> getProductByPrice(int Price);
    public List<Product> getProductByQoh(int qoh);
    public List<Product> getProductByGreaterQoh(int greaterQoh);


    List<Product> getProductByLessQoh(int qoh);
}
