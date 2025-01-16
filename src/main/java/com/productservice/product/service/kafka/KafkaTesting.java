package com.productservice.product.service.kafka;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.errors.TopicExistsException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class KafkaTesting {
    public static void main(String[] args) throws Exception {
        String bootstrapServers = "localhost:9092";
        String topicName = "test";
        // Step 1: Create Kafka Topic
        createTopic(bootstrapServers, topicName);

        // Step 2: List Kafka Topics
        listTopics(bootstrapServers);

        // Step 3: Produce a message to the Kafka topic
        produceMessage(bootstrapServers, topicName);

        // Step 4: Consume the message from the Kafka topic
        consumeMessage(bootstrapServers, topicName);
    }

    // Method to create a Kafka topic
    private static void createTopic(String bootstrapServers, String topicName)
            throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        AdminClient adminClient = AdminClient.create(properties);

        NewTopic newTopic = new NewTopic(topicName, 1, (short) 1); // 1 partition, replication-factor 1
        try {
            adminClient.createTopics(Collections.singleton(newTopic)).all().get();
            System.out.println("Topic '" + topicName + "' created successfully.");
        } catch (TopicExistsException e) {
            System.out.println("Topic '" + topicName + "' already exists.");
        }

        adminClient.close();
    }

    // Method to list Kafka topics
    private static void listTopics(String bootstrapServers) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        AdminClient adminClient = AdminClient.create(properties);

        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(false); // Exclude internal topics
        Set<String> topics = adminClient.listTopics(options).names().get();

        System.out.println("Listing topics:");
        topics.forEach(System.out::println);

        adminClient.close();
    }

    // Method to produce a message to the Kafka topic
    private static void produceMessage(String bootstrapServers, String topicName) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String message = "Hello, Kafka! This is a test message.";
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, "key1", message);

        try {
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Message sent successfully to topic " + topicName);
                } else {
                    exception.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        producer.close();
    }

    // Method to consume messages from the Kafka topic
    private static void consumeMessage(String bootstrapServers, String topicName) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("group.id", "test-consumer-group");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singletonList(topicName));

        System.out.println("Consuming messages from topic " + topicName + "...");

        // Consume messages in an infinite loop
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Consumed message: " + record.value());
            }
        }
    }
}