# zookeeper-sample
Simple demonstration for hazelcast-zookeeper discovery plugin with both client and service instance.
Hazelcast-zookeeper uses Apache Curator (http://curator.apache.org/) for service discovery.
Members registers themselves to zookeeper server during startup as a service and each new member/client connects to
zookeeper server to get the address and port info. 

###Configuration

Before building the project you should configure hazelcast-zookeeper plugin, you can configure 
client/server instances seperately, by editing `hazelcast.xml` and `hazelcast-client.xml` under `resources` folder.

Here are the configuration details for hazelcast-zookeeper plugin
```xml
<discovery-strategy enabled="true" class="com.hazelcast.zookeeper.ZookeeperDiscoveryStrategy">
    <properties>
        <!--
          Connection string to your ZooKeeper server.
          Default: There is no default, this is a required property.
          Example: 127.0.0.1:2181
        -->
        <property name="zookeeper_url">{ip-address-of-zookeeper}:{port-of-zookeeper}</property>
        <!--Path in ZooKeeper Hazelcast will useDefault: /discovery/hazelcast -->
        <property name="zookeeper_path">{path-on-zookeeper}</property>
        <!--Name of this Hazelcast cluster. You can have multiple distinct clusters to use the same ZooKeeper installation.-->
        <property name="group">{clusterId}</property>
    </properties>
</discovery-strategy>
```

### Packaging
Project uses maven assembly plugin to create an über jar which contains all depencies to run the Apache Curator client.

To package project  :

`mvn clean package`

### Deployment

After build is completed go to target folder and upload `integration-1.0-SNAPSHOT` to your cloud instance.

### Running

You can start server instance by running Member class :

`java -cp integration-1.0-SNAPSHOT.jar com.hazelcast.zookeeper.integration.Member`

You can start client instance by running Client class :

java -cp integration-1.0-SNAPSHOT.jar com.hazelcast.zookeeper.integration.Client

###Testing

Test are done manually over aws with 2 member 2 clients setup. Make sure that 5701(default hz port) 2181(default zookeeper port) are
open for inbound communition.





