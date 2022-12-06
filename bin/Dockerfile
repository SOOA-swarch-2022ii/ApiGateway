# define base docker image
FROM openjdk:8
ADD target/api-gateway-0.0.1-SNAPSHOT.jar sooa-api-gateway.jar
ENTRYPOINT ["java", "-jar", "sooa-api-gateway.jar"]