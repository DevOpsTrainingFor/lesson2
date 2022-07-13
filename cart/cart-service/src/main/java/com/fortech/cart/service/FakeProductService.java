package com.fortech.cart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fortech.cart.ProductDto;

@Service
public class FakeProductService {

  public List<ProductDto> generateFakeProducts() {
    List<ProductDto> products = new ArrayList<>();
    products.add(generateFakeProduct());

    return products;
  }

  private ProductDto generateFakeProduct() {
    return new ProductDto("Macbook Pro", UUID.randomUUID(), BigDecimal.valueOf(5000));
  }
}
