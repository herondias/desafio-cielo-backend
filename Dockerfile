#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine as build

# Set the current working directory inside the image
WORKDIR /opt/app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline. 
# This is a separate step so the dependencies will be cached unless 
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app 
FROM openjdk:8-jre-alpine

WORKDIR /opt/app/

# Copy project dependencies from the build stage
COPY --from=build /opt/app/target/*.jar /opt/app

RUN adduser -D -g '' hedias && chown hedias:hedias /opt/app -R

USER hedias

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dapp=desafio-cielo-backend -jar desafio-cielo-backend.jar"]