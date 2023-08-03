FROM maven:3.3-jdk-8 AS build
WORKDIR /app
COPY ./ /app/
RUN mvn clean install
