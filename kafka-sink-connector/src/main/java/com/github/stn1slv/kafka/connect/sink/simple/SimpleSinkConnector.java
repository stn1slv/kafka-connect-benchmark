package com.github.stn1slv.kafka.connect.sink.simple;

import org.apache.kafka.common.config.Config;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleSinkConnector extends SinkConnector {

    private final Logger log = LoggerFactory.getLogger(SimpleSinkConnector.class);

    private Map<String, String> originalProps;

    @Override
    public String version() {
        return PropertiesUtil.getConnectorVersion();
    }

    @Override
    public ConfigDef config() {
        return new ConfigDef();
    }

    @Override
    public Class<? extends Task> taskClass() {
        return SimpleSinkTask.class;
    }

    @Override
    public Config validate(Map<String, String> connectorConfigs) {
        return super.validate(connectorConfigs);
    }

    @Override
    public void start(Map<String, String> originalProps) {
        this.originalProps = originalProps;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        final List<Map<String, String>> configs = new ArrayList<>( maxTasks );
        for ( int i = 0; i < maxTasks; ++i ) {
            configs.add( originalProps );
        }
        return configs;
    }

    @Override
    public void stop() {
    }

}
