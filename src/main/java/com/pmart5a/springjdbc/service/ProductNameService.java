package com.pmart5a.springjdbc.service;

import com.pmart5a.springjdbc.repository.ProductNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductNameService {

    private final ProductNameRepository productNameRepository;

    public List<String> getProductName(String name) {
        return productNameRepository.getProductName(name);
    }
}