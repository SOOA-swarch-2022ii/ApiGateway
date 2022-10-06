package sooa.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RMQMessagingService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RMQMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendSimpleMessage(String string) {
        rabbitTemplate.convertAndSend("cola_prueba","Probando RabbitMQ");
    }

    public String receiveMessage() {
        return (String) rabbitTemplate.receiveAndConvert("cola_prueba");
    }

}
