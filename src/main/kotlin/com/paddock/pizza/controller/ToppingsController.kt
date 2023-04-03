package com.paddock.pizza.controller

import com.paddock.pizza.model.CustomerToppings
import com.paddock.pizza.model.Topping
import com.paddock.pizza.service.CustomerToppingsStorageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ToppingsController(
    private val storageService: CustomerToppingsStorageService
) {
    companion object {
        private const val OPTIMAL_TOPPING_EMAIL = "mpaddock@gmail.com"
    }

    @GetMapping("/toppings/available")
    fun availableToppings() = Topping.values().groupBy { it.classification }

    @GetMapping("/toppings/submitted")
    fun submittedToppings(): Map<Topping, Int> {
        val groupings = storageService.findAll().flatMap { it.toppings }.groupingBy { it }
        return storageService.findAll().flatMap { it.toppings }.groupingBy { it }.eachCount()
    }

    @GetMapping("/toppings/optimal")
    fun optimalToppings(): List<Topping> {
        return storageService.findByEmail(OPTIMAL_TOPPING_EMAIL)?.toppings ?: emptyList()
    }

    @PostMapping("/toppings")
    fun submitToppings(
        @RequestBody customerToppings: CustomerToppings
    ): CustomerToppings {
        // Don't let a user submit the same topping twice in a list
        val customerToppingsDeduplicated = customerToppings.copy(toppings = customerToppings.toppings.distinct())
        return storageService.save(customerToppingsDeduplicated)
    }
}
