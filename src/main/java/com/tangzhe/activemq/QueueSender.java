package com.tangzhe.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * queue消息发送者
 */
@Component
public class QueueSender {

    @Autowired
    @Qualifier("queueTemplate")
    private JmsTemplate template;

    public void send(String queueName, final String message) {
        template.send(queueName, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

}
