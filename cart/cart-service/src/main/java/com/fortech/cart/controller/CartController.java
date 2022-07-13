package com.fortech.cart.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.cart.CartDto;
import com.fortech.cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartService service;

  private final Logger logger = LoggerFactory.getLogger(CartController.class);

  public CartController(CartService service) {
    this.service = service;
  }

  @GetMapping("/{cartExternalId}")
  public CartDto getCart(@PathVariable UUID cartExternalId) {
    logger.info("Called cart retrieval with id {}", cartExternalId);

    return service.getCart(cartExternalId);
  }

}
