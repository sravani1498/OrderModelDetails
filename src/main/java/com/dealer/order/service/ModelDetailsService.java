package com.dealer.order.service;

import com.dealer.order.controller.ModelDetails;
import com.dealer.order.entity.CityDetails;
import com.dealer.order.entity.DealerModelDetails;
import com.dealer.order.model.Order;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ModelDetailsService {

    public Order getModelDetails(Order order) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.US_EAST_1).httpClientBuilder(UrlConnectionHttpClient.builder())
                .build();

        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
        
        DynamoDbTable<DealerModelDetails> modelTable = enhancedClient.table("DealerModelDetails", TableSchema.fromBean(DealerModelDetails.class));
        Key key = Key.builder().partitionValue(order.getDealerId()).sortValue(order.getModel()).build();
        // Get the item by using the key.
        DealerModelDetails model = modelTable.getItem(
                (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));

        DynamoDbTable<CityDetails> cityTable = enhancedClient.table("CityDetails", TableSchema.fromBean(CityDetails.class));
        Key key1 = Key.builder().partitionValue(order.getCity()).build();
        // Get the item by using the key.
        CityDetails city = cityTable.getItem(
                (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key1));
        System.out.println(model.getPrice());
        int totalPrice = model.getPrice() + city.getTax();
        order.setPrice(totalPrice);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, model.getWaitingDays());
        order.setExpectedDeliveryDate(c.getTime());

        return order;
    }
}
