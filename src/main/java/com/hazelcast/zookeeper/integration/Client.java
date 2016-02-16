package com.hazelcast.zookeeper.integration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;

import java.io.InputStream;

public class Client {
    public static void main(String[] args) {
        String xmlFileName = "hazelcast-client.xml";
        InputStream xmlResource = Client.class.getClassLoader().getResourceAsStream(xmlFileName);
        ClientConfig clientConfig = new XmlClientConfigBuilder(xmlResource).build();
        HazelcastClient.newHazelcastClient(clientConfig);
    }
}
