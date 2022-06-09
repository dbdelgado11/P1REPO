package com.newrev.p1.controller;


import com.newrev.p1.annonations.ApiResponse;
import com.newrev.p1.dto.cart.AddToCartDto;
import com.newrev.p1.dto.cart.CartDto;
import com.newrev.p1.model.Cart;
import com.newrev.p1.model.Product;
import com.newrev.p1.model.User;
import com.newrev.p1.services.CartService;
import com.newrev.p1.services.ProductService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/cart")//localhost:8087/cart
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;


    @PostMapping("/add")//localhost:8087/cart/add
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto) {
        Product product = productService.getProduct(addToCartDto.getProductId());
        //Product product = productService.getProductById(addToCartDto.getProductId());
       // System.out.println("product to add"+  product.getName());
        System.out.println("product to add" + product.getProductName());
       // cartService.addToCart(addToCartDto, product, user);
        cartService.addToCart(addToCartDto, product, new User());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
   /* @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);*/

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto){
        Product product = productService.getProduct(cartDto.getProductId());
        cartService.updateCartItem(cartDto, new User(), product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

   /* @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID) {

        cartService.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);*/
    }


