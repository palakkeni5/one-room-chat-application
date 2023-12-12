FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /opt/app
RUN apt-get update && apt-get install dos2unix

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

COPY ./src ./src
RUN sed -i 's/\r$//' mvnw

RUN ./mvnw clean install
RUN ./mvnw dependency:go-offline
 
FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]
