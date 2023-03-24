package com.kosa.springbootmyspace.web;

import com.kosa.springbootmyspace.domain.Category;
import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.domain.Product;
import com.kosa.springbootmyspace.service.CategoryService;
import com.kosa.springbootmyspace.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/category/{idx}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable int idx) {
        try {
            Category category = categoryService.findById(idx);
            List<Product> findProductList = productService.findByCategory(category);
            if(findProductList != null){
                return new ResponseEntity<>(findProductList, HttpStatus.OK);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> findByCategory(@RequestParam(value = "searchKeyword") String searchKeyword) {
        try {
            System.out.println(searchKeyword);
            List<Product> findProductList = productService.findByNameLike("%" + searchKeyword + "%");
            if(findProductList != null){
                return new ResponseEntity<>(findProductList, HttpStatus.OK);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
