package com.dealer.order.controller;

import com.dealer.order.model.Order;
import com.dealer.order.service.ModelDetailsService;
import jdk.jfr.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dealer")
public class ModelDetails {

    @PostMapping("/model")
    public Order getModelDetails( @RequestBody Order order) {
        ModelDetailsService service = new ModelDetailsService();
        return service.getModelDetails(order);
    }

}
