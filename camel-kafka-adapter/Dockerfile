FROM maven:3.8-jdk-11 as app-builder
WORKDIR /var/src/app
COPY . .
RUN mvn -DskipTests package && mv target/*.jar target/app.jar

FROM adoptopenjdk:11-jre-hotspot
COPY --from=app-builder /var/src/app/target/app.jar /opt
ENV BROKERS="kafka:9092"
ENV JAVA_OPTS='-Xms2g -Xmx2g'
CMD java ${JAVA_OPTS} -jar /opt/app.jar --camel.component.kafka.brokers=${BROKERS}
# CMD ["java", "${JAVA_OPTS}","-jar", "/opt/app.jar", "--camel.component.kafka.brokers=${BROKERS}"]