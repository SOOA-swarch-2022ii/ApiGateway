package sooa.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import sooa.domain.subjects_ms.RecordStudentCourse;
@Getter
@Service
public class RMQMessagingService {
    /*public String student_consumer ;
    public String course_consumer ;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RegisterSubjectsService registerSubjectsService;

    public RMQMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendSimpleMessage(RecordStudentCourse message) {
        rabbitTemplate.convertAndSend("registros",message);
    }

    @RabbitListener(queues = "registros")
    public void receiveMessage(RecordStudentCourse message) {
        System.out.println("RECIVED MESAGGE: " + "STUDENT: " + message.getStudent_id() + " COURSE: " + message.getCourse_id());

        //makeSlow();
    }

    private void makeSlow(){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }*/

}
