package com.atguigu.gmall.gmallmqtest.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerTest {
    public static void main(String[] args) throws JMSException {
        //创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://192.168.62.128:61616");
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开链接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列
        Queue queue = session.createQueue("Atguigu");
        // 创建Consumer
        MessageConsumer consumer = session.createConsumer(queue);
        // 接收消息   消息监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                // 参数就是收到的消息 判断消息的类型
                if (message instanceof  TextMessage){
                    try {
                        String text = ((TextMessage) message).getText();
                        System.out.println(text+"接收的消息！");
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
