package com.fortech.cart.service;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fortech.cart.CartDto;

@Service
public class CartService {

  private final String CART_CACHE_NAME = "cart";
  private static final String CART_CACHE_KEY = "#cartExternalId";

  private final FakeProductService fakeProductService;

  public CartService(FakeProductService fakeProductService) {
    this.fakeProductService = fakeProductService;
  }

  @Cacheable(value= CART_CACHE_NAME, key = CART_CACHE_KEY)
  public CartDto getCart(UUID cartExternalId) {
    return new CartDto(fakeProductService.generateFakeProducts());
  }
}
