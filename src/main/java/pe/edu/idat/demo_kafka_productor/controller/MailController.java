package pe.edu.idat.demo_kafka_productor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.demo_kafka_productor.service.ProducerMailService;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    private final ProducerMailService producerMailService;

    public MailController(ProducerMailService producerMailService) {
        this.producerMailService = producerMailService;
    }

    @GetMapping
    public ResponseEntity<String> enviarEmail(
            @RequestParam String email){
        producerMailService.enviarMail(email);
        return ResponseEntity.ok("Mensaje enviado a Kafka");
    }
}
