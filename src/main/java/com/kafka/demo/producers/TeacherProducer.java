package com.kafka.demo.producers;


import com.kafkademo.schemas.Teacher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@AllArgsConstructor
@Slf4j
public class TeacherProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public void send(Teacher teacher){

        ProducerRecord<String, Object> record = new ProducerRecord("SIMO.TEST.TOPIC1",null,teacher);

        ListenableFuture<SendResult<String, Object>> send =
                kafkaTemplate.send(record);
        send.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info(" message success 2: " + result);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info(" message failed : "  + ex.getMessage());

            }
        });
    }
}
