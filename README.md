# Kafka Connect (simple) benchmark

This repo contains:
- simple sink connector based on Kafka Connect
- simple sink connector based on Apache Camel with Spring Boot
- infrastructure for testing (Kafka Broker, Prometheus, Grafana, Kafka Lag Exporter)

## Starting

### Building Kafka Connect connector

The first thing you need to do to start using this connector is building it. In order to do that, you need to install the following dependencies:

- [Java 1.8+](https://openjdk.java.net/)
- [Apache Maven](https://maven.apache.org/)

After installing these dependencies, execute the following command:

```bash
mvn clean package
```

### Start all components on the same host

After building the connector you can try it by using the Docker-based installation from this repository.

#### Step 1 - Starting the environment

Remove old containers:

```bash
docker rm kafka zookeeper connect prometheus grafana kafka-lag-exporter
```

Start the environment with the following command:

```bash
docker-compose up
```

Wait until all containers are up so you can start the testing.

#### Step 2 - Start the Kafka Connect connector

Open a terminal to execute the following command:

```bash
curl --location --request POST 'http://localhost:8083/connectors' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "basic-sink",
    "config": {
        "connector.class": "com.github.stn1slv.kafka.connect.sink.simple.SimpleSinkConnector",
        "topics": "output",
        "tasks.max": "1",
        "value.converter": "org.apache.kafka.connect.storage.StringConverter",
        "value.converter.schemas.enable": "true"
    }
}'
```
#### Step 3 - Generate data to kafka topic

Please use https://github.com/stn1slv/kafka-data-generator or your own data generator.
