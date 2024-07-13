package com.victorgroup.hipermercadovic.apirest.controllers;

import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>>findAll(){
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO>findById(@PathVariable int id){
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO>createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(this.productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDTO>updateProduct(@RequestBody ProductDTO productDTO,@PathVariable int id){
        return new ResponseEntity<>(this.productService.updateProduct(productDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable int id){
        return new ResponseEntity<>(this.productService.deleteProduct(id), HttpStatus.NO_CONTENT);
    }
}
