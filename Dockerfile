FROM openjdk:11
EXPOSE 8080
ADD target/dealer-order-0.0.1-SNAPSHOT.jar dealer-order-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/dealer-order-0.0.1-SNAPSHOT.jar"]