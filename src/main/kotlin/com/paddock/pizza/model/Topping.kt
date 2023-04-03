package com.paddock.pizza.model

enum class Topping(val classification: ToppingClassification) {
    ANCHOVIES(ToppingClassification.MEAT),
    BACON(ToppingClassification.MEAT),
    CHICKEN(ToppingClassification.MEAT),
    GROUND_BEEF(ToppingClassification.MEAT),
    HAM(ToppingClassification.MEAT),
    PEPPERONI(ToppingClassification.MEAT),
    SAUSAGE(ToppingClassification.MEAT),

    BANANA_PEPPERS(ToppingClassification.VEGGIE),
    BLACK_OLIVES(ToppingClassification.VEGGIE),
    GREEN_OLIVES(ToppingClassification.VEGGIE),
    GREEN_PEPPERS(ToppingClassification.VEGGIE),
    JALAPENOS(ToppingClassification.VEGGIE),
    MUSHROOMS(ToppingClassification.VEGGIE),
    ONIONS(ToppingClassification.VEGGIE),
    RED_ONIONS(ToppingClassification.VEGGIE),
    TOMATOES(ToppingClassification.VEGGIE),

    EXTRA_CHEESE(ToppingClassification.OTHER),
    PINEAPPLE(ToppingClassification.OTHER);
}

enum class ToppingClassification {
    MEAT,
    VEGGIE,
    OTHER;
}
