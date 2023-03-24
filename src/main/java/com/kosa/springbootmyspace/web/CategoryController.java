package com.kosa.springbootmyspace.web;

import com.kosa.springbootmyspace.domain.Category;
import com.kosa.springbootmyspace.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        try {
            Category saveCategory = categoryService.save(category);
            if (saveCategory != null) {
                return new ResponseEntity<Category>(saveCategory, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        try {
            int result = categoryService.update(category);
            if (result == 1) {
                Category updateCategory = categoryService.findById(category.getIdx());
                return new ResponseEntity<Category>(updateCategory, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<Integer> delete(@PathVariable int idx) {
        try {
            int result = categoryService.delete(idx);
            if (result == 1) {
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<Category> findById(@PathVariable int idx) {
        try {
            Category findCategory = categoryService.findById(idx);
            if (findCategory != null) {
                return new ResponseEntity<Category>(findCategory, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Category>> findAll() {
        try {
            List<Category> categoryList = categoryService.findAll();
            if (categoryList != null) {
                return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
    }
}
