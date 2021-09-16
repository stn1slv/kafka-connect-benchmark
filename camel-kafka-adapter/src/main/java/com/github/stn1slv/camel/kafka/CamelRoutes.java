package com.github.stn1slv.camel.kafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:output?brokers=kafka:9092").log("${body}");
    }
}
