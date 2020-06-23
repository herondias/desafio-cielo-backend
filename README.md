# desafio-cielo-backend
Esse projeto corresponde a etapa de desafio no processo seletivo da Cielo

## Dependências para build
Java SDK 8
Maven
Docker

## Tecnologias Utilizadas
Java 8
Spring Boot

## Maven Build
mvn clean package
java -jar target/desafio-cielo-backend.jar

## Docker Build
docker build -t desafio-cielo-backend .
docker run --name desafio-cielo-backend -d -p 8081:8081 desafio-cielo-backend:latest