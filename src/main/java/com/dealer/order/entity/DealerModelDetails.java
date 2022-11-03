package com.dealer.order.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class DealerModelDetails {

    private String dealerId;
    private String model;
    private String year;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("dealerId")
    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }
    @DynamoDbSortKey
    @DynamoDbAttribute("model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @DynamoDbAttribute("year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    @DynamoDbAttribute("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @DynamoDbAttribute("waitingDays")
    public int getWaitingDays() {
        return waitingDays;
    }

    public void setWaitingDays(int waitingDays) {
        this.waitingDays = waitingDays;
    }
    @DynamoDbAttribute("price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String city;
    private int waitingDays;
    private double price;
}
