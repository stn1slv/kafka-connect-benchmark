package com.github.stn1slv.kafka.connect.sink.simple;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

public class SimpleSinkTask extends SinkTask {
    private static Logger log = LoggerFactory.getLogger(SimpleSinkTask.class);

    @Override
    public String version() {
        return PropertiesUtil.getConnectorVersion();
    }

    @Override
    public void start(Map<String, String> properties) {
        log.info("SinkTask started");
    }

    @Override
    public void stop() {
        log.info("SinkTask started");
    }

    @Override
    public void put(Collection<SinkRecord> records) {
        if (records.isEmpty()) {
            return;
        }

        for (SinkRecord sinkRecord : records) {
            log.info("Received: "+sinkRecord.value().toString());
        }
    }

}
