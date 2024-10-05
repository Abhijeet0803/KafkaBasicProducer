# Kafka zookeeper:

bin/zookeeper-server-start.sh config/zookeeper.properties 


# Kafka Server

bin/kafka-server-start.sh config/server.properties


# Kafka Topic Creation

bin/kafka-topics.sh --create --topic user-topic --bootstrap-server localhost:9092

bin/kafka-topics.sh  --bootstrap-server localhost:9092 —list

bin/kafka-topics.sh --describe --topic user-topic --bootstrap-server localhost:9092

bin/kafka-topics.sh --alter --topic user-topic --partitions 3 --bootstrap-server localhost:9092

bin/kafka-topics.sh —delete --topic user-topic --bootstrap-server localhost:9092
Kafka Producer

bin/kafka-console-producer.sh --topic user-topic --bootstrap-server localhost:9092

# Kafka Consumer

bin/kafka-console-consumer.sh --topic user-topic --bootstrap-server localhost:9092

bin/kafka-console-consumer.sh --topic user-topic --bootstrap-server localhost:9092 --property print.key=true
