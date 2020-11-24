FROM maven:3.6.3-jdk-11 AS maven_build

COPY ./ /api-user

WORKDIR /api-user

RUN mvn clean package

FROM openjdk:11-jre-buster

COPY --from=maven_build /api-user/target/api-user-0.0.1-SNAPSHOT.jar /api-user.jar

CMD ["java", "-jar", "/api-user.jar"]