//package com.dealer.order.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
//import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
//import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
//import software.amazon.awssdk.services.dynamodb.endpoints.DynamoDbEndpointProvider;
//import software.amazon.awssdk.utils.StringUtils;
//
//@Configuration
//public class DBConfig {
//
//    @Value("${amazon.dynamodb.endpoint}")
//    private String amazonDynamoDBEndpoint;
//
//    @Value("${amazon.aws.accesskey}")
//    private String amazonAWSAccessKey;
//
//    @Value("${amazon.aws.secretkey}")
//    private String amazonAWSSecretKey;
//
//    @Bean
//    public DynamoDbClient amazonDynamoDB() {
//
//        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
//                .credentialsProvider(DefaultCredentialsProvider.builder().build())
//                .region(Region.US_EAST_1).endpointProvider(DynamoDbEndpointProvider.defaultProvider())
//                .httpClientBuilder(UrlConnectionHttpClient.builder())
//                .build();
//
//        return dynamoDbClient;
//    }
//
//    @Bean
//    public EnvironmentVariableCredentialsProvider amazonAWSCredentials() {
//        return new AwsBasicCredentials(
//                amazonAWSAccessKey, amazonAWSSecretKey);
//    }
//}
//Copy
