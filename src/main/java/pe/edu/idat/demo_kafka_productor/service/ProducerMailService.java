package pe.edu.idat.demo_kafka_productor.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerMailService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "idat-topic";

    public ProducerMailService(
            KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMail(String email){
        kafkaTemplate.send(TOPIC, email);
    }

}
