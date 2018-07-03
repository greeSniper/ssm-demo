package com.tangzhe.activemq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * queue消息接收者1
 */
@Component("queueReceiver1")
public class QueueReceiver1 implements MessageListener {

    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage)message).getText();
            System.out.println("queueReceiver1----收到消息" + msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
