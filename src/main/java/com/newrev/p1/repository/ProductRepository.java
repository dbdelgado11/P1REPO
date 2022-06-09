package com.newrev.p1.repository;



import com.newrev.p1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //declare the methods
    //select * from product where productName = ?
    public List<Product> findByProductName(String productName);
    public List<Product> findByPrice(int price);

    public List<Product> findByQoh(int qoh);

    public List<Product> findByPriceBetween(int minimumPrice,int maximumPrice);

    //? select * from product where qoh < ?
    public List<Product>findByQohLessThan(int qoh);

    //select * from product where productName = ?

    @Query("select p from Product p where productName = ?1")
    public List<Product>  getProductByName(String productName);
    //Lakme
    //100
    @Query("SELECT c FROM Product c WHERE c.productName = ?1 AND c.price = ?2")
    public List<Product> findAll(String productName, int price);
}
