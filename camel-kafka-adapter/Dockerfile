FROM maven:3.8-jdk-11 as app-builder
WORKDIR /var/src/app
COPY . .
RUN mvn -DskipTests package && mv target/*.jar target/app.jar

FROM adoptopenjdk:11-jre-hotspot
COPY --from=app-builder /var/src/app/target/app.jar /opt
ENV brokers=kafka:9092
CMD ["java", "-jar", "/opt/app.jar", "--camel.component.kafka.brokers=${brokers}"]