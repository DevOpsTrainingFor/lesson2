package com.fortech.cart;

import java.util.List;

public class CartDto {

  private List<ProductDto> products;

  public CartDto() {
  }

  public CartDto(List<ProductDto> products) {
    this.products = products;
  }

  public List<ProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDto> products) {
    this.products = products;
  }
}
