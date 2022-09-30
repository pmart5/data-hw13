package com.pmart5a.springjdbc.controller;

import com.pmart5a.springjdbc.service.ProductNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductNameController {

        private final ProductNameService productService;

        @GetMapping("/fetch-product")
        public List<String> fetchProduct(@RequestParam("name") String name) {
            return productService.getProductName(name);
        }
}