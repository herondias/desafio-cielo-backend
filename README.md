# desafio-cielo-backend
Esse projeto corresponde a etapa de desafio no processo seletivo da Cielo

## Dependências para build
1. Java SDK 8
2. Maven
3. Docker

## Tecnologias Utilizadas
1. Java 8
2. Spring Boot

## Maven Build
1. mvn clean package
2. java -jar target/desafio-cielo-backend.jar

## Docker Build
1. docker build -t desafio-cielo-backend .
2. docker run --name desafio-cielo-backend -d -p 8081:8081 desafio-cielo-backend:latest

### URL de acesso
<a href="http://localhost:8081">http://localhost:8081</a>
