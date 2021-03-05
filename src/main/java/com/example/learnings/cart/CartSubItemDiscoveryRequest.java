package com.example.learnings.cart;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CartSubItemDiscoveryRequest {

    @NotNull(message = "cartId can't be null")
    @Pattern(regexp="\\d+", message = "cartId must be number")
    private String cartId;

    @NotNull(message = "cartSubItemsDTO can't be null")
    private CartSubItemsDTO cartSubItemsDTO;
}
