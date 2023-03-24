package com.kosa.springbootmyspace.web;

import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.domain.Product;
import com.kosa.springbootmyspace.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/{idx}")
    public ResponseEntity<Product> findById(@PathVariable int idx) {
        try {
            Product findproduct = productService.findById(idx);
            if(findproduct!=null){
                return new ResponseEntity<Product>(findproduct, HttpStatus.OK);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
}
