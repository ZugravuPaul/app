package com.home.projectapp.controller;

import com.home.projectapp.dto.ProductDto;
import com.home.projectapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> show_all_products() {
        return productService.show_all_products();
    }
    @PostMapping
    public void addProduct(@RequestBody ProductDto product){
        productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable @Valid @Min(0) Long id, @RequestParam String name) {
        productService.updateName(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable @Valid @Min(0) Long id){
        productService.deleteProduct(id);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity handleException() {
        return ResponseEntity.badRequest().body("Bad request");
    }
}
