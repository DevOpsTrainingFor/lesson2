package com.fortech.cart;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDto {

  private String name;

  private UUID externalId;

  private BigDecimal price;

  public ProductDto(String name, UUID externalId, BigDecimal price) {
    this.name = name;
    this.externalId = externalId;
    this.price = price;
  }

  public ProductDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getExternalId() {
    return externalId;
  }

  public void setExternalId(UUID externalId) {
    this.externalId = externalId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
