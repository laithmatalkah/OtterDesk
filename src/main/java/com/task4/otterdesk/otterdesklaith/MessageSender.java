package com.task4.otterdesk.otterdesklaith;

import com.task4.otterdesk.otterdesklaith.model.BluePrint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

        private static final Logger logger = LoggerFactory.getLogger(MessageSender.class.getName());

        @Autowired
        private BluePrint bluePrint;

        @Autowired
        private AmqpTemplate rabbitTemplate;

        @Autowired
        private Queue queue;

        @Scheduled(fixedRate = 3000)
        public void send() {
            this.rabbitTemplate.convertAndSend(queue.getName(), bluePrint);
            logger.info(" [x] Sent '" + bluePrint + "'");
        }
    }


