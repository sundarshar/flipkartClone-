package com.example.flipkartclone.Controller;

import com.example.flipkartclone.Dtos.PaymentRequestDto;
import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Exception.CategoryNotFoundException;
import com.example.flipkartclone.Exception.ProductNotFoundException;
import com.example.flipkartclone.Model.Category;
import com.example.flipkartclone.Model.Product;
import com.example.flipkartclone.Services.ProductService;
import com.example.flipkartclone.Services.RazorpayPaymentServices;
import com.example.flipkartclone.Services.Stratagy.PaymentGatewaySelectionImp;
import com.example.flipkartclone.Services.StripPaymentServices;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;
    public RazorpayPaymentServices razorpayPaymentServices;
    public StripPaymentServices stripPaymentServices;
    public PaymentGatewaySelectionImp paymentGatewaySelectionImp;

    public ProductController(@Qualifier("selfProducts") ProductService productService,
                             @Qualifier("Razorpay") RazorpayPaymentServices razorpayPaymentServices,
                             @Qualifier("Strip") StripPaymentServices stripPaymentServices,
                             PaymentGatewaySelectionImp paymentGatewaySelectionImp){
        this.productService = productService;
        this.razorpayPaymentServices = razorpayPaymentServices;
        this.stripPaymentServices = stripPaymentServices;
        this.paymentGatewaySelectionImp = paymentGatewaySelectionImp;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductDto request){
        return productService.createProduct(request);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/category")
    public List<Category> getAllCategory(){
        return productService.getAllCategory();
    }

    @PutMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody ProductDto productDto ) throws ProductNotFoundException {
        return productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
    }

    @GetMapping("products/category/{name}")
    public  ResponseEntity<List<Product>> getProductBasedOnCategory(@PathVariable("name") String category) throws CategoryNotFoundException {
        List<Product> product = productService.getProductsBasedOnCategory(category);
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @PostMapping("/payment")
    public String initialPayment(@RequestBody PaymentRequestDto paymentRequestDto) throws RazorpayException {
        int paymentOption = choosePaymentGateway();
        switch(paymentOption){
            case 1: return razorpayPaymentServices.doPayment(paymentRequestDto);
            case 2: return stripPaymentServices.doPayment(paymentRequestDto);
        }
        return null;

    }

    private int choosePaymentGateway(){
        return paymentGatewaySelectionImp.paymentGatewaySelection();
    }

}
