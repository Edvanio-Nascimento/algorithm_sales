package com.github.edy.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductModel extends Auditing {

    private final UUID id;
    private final String name;
    private final String sku;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public ProductModel(String name, String sku, BigDecimal price) {
        super();
        this.id = UUID.randomUUID();
        this.name = name.toUpperCase();
        this.sku = sku.toUpperCase();
        this.price = price;

        if (this.sku == null || this.sku.isBlank()) {
            throw new IllegalArgumentException("SKU inválido");
        }

        if ((this.sku.trim().length() > 20) || (this.sku.trim().length() < 5)) {
            throw new IllegalArgumentException("Deve conter no máximo 20 caracteres");
        }

        if (this.name == null || this.name.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (this.name.trim().length() < 5) {
            throw new IllegalArgumentException("O campo nome deve conter ao menos 5 caracteres");
        }
    }

    // SETTTERS
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        toUpdate();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // GETTERS
    public UUID getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
