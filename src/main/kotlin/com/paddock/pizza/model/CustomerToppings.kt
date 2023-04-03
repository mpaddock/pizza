package com.paddock.pizza.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerToppings(
    @JsonProperty("email")
    val email: String,
    @JsonProperty("toppings")
    val toppings: List<Topping>
)
