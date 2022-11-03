package com.dealer.order.controller;

import com.dealer.order.model.Order;
import com.dealer.order.service.ModelDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dealer")
public class ModelDetails {

    @PostMapping("/model")
    public Order getModelDetails(Order order) {
        ModelDetailsService service = new ModelDetailsService();
        return service.getModelDetails(order);
    }

}
