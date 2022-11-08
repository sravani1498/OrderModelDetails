package com.dealer.order.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primaryPartitionKey;
import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primarySortKey;

@DynamoDbBean
public class DealerModelDetails {

    public static final StaticTableSchema.Builder<DealerModelDetails> TABLE_SCHEMA =
            StaticTableSchema.builder(DealerModelDetails.class)
                    .newItemSupplier(DealerModelDetails::new)
                    .addAttribute(String.class, a -> a.name("dealerId")
                            .getter(DealerModelDetails::getDealerId)
                            .setter(DealerModelDetails::setDealerId)
                            .tags(primaryPartitionKey()))
                    .addAttribute(String.class,
                            a -> a.name("model")
                                    .getter(DealerModelDetails::getModel)
                                    .setter(DealerModelDetails::setModel).tags(primarySortKey())
                    );

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
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String city;
    private int waitingDays;
    private int price;
}
