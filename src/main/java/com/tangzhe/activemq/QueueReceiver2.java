package com.tangzhe.activemq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * queue消息接收者2
 */
@Component("queueReceiver2")
public class QueueReceiver2 implements MessageListener {

    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage)message).getText();
            System.out.println("queueReceiver2----收到消息" + msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
