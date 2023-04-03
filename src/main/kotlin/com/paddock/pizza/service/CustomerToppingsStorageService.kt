package com.paddock.pizza.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.paddock.pizza.model.CustomerToppings
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import org.springframework.stereotype.Service

// This was... a choice. It seemed better in my head.
interface CustomerToppingsStorageService {
    fun save(customerToppings: CustomerToppings): CustomerToppings
    fun findAll(): List<CustomerToppings>
    fun findByEmail(email: String): CustomerToppings?
}

@Service
class CustomerToppingsStorageServiceImpl : CustomerToppingsStorageService {
    companion object {
        private const val CUSTOMER_TOPPINGS_BASE_PATH = "src/main/resources/customer_toppings/"
    }

    init {
        Files.createDirectories(Paths.get(CUSTOMER_TOPPINGS_BASE_PATH))
    }

    override fun findAll(): List<CustomerToppings> {
        val folder = File(CUSTOMER_TOPPINGS_BASE_PATH)
        val objectMapper = ObjectMapper()
        return folder.list()?.map {
            val contents = String(Files.readAllBytes(Paths.get(CUSTOMER_TOPPINGS_BASE_PATH + it))).trim()

            objectMapper.readValue(
                contents,
                CustomerToppings::class.java
            )
        } ?: emptyList()
    }

    override fun save(customerToppings: CustomerToppings): CustomerToppings {
        val path = Paths.get(customerToppings.email.toFilePath())
        val objectMapper = ObjectMapper()
        Files.writeString(path, objectMapper.writeValueAsString(customerToppings), StandardCharsets.UTF_8)

        return customerToppings
    }

    override fun findByEmail(email: String): CustomerToppings? {
        val objectMapper = ObjectMapper()
        return try {
            objectMapper.readValue(
                String(Files.readAllBytes(Paths.get(email.toFilePath()))).trim(),
                CustomerToppings::class.java
            )
        } catch (_: Exception) {
            null
        }
    }


    private fun String.toFilePath() = "$CUSTOMER_TOPPINGS_BASE_PATH$this.txt"
}
