FROM maven:3.6.3-jdk-11 AS maven_build

COPY ./ /api-contact-book

WORKDIR /api-contact-book

RUN mvn clean package

FROM openjdk:11-jre-buster

COPY --from=maven_build /api-contact-book/target/api-contact-book-0.0.1-SNAPSHOT.jar /api-contact-book.jar

CMD ["java", "-jar", "/api-contact-book.jar"]