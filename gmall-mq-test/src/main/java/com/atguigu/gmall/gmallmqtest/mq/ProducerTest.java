package com.atguigu.gmall.gmallmqtest.mq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class ProducerTest {
    //发送消息
    public static void main(String[] args) throws JMSException {
    //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.62.128:61616");
    //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
    //打开链接
        connection.start();
    //创建session
        //第一个参数表示是否支持事务，false时，第二个参数Session.AUTO_ACKNOWLEDGE，Session.CLIENT_ACKNOWLEDGE，DUPS_OK_ACKNOWLEDGE其中一个
        // 第一个参数设置为true时，第二个参数可以忽略 服务器设置为SESSION_TRANSACTED
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列
        Queue queue = session.createQueue("Atguigu");
    //创建生产者
        MessageProducer producer = session.createProducer(queue);
        // 创建消息对象
        ActiveMQTextMessage activeMQTextMessage = new ActiveMQTextMessage();
        activeMQTextMessage.setText("hello ActiveMq! 情人节快乐！！！");
        // 发送消息
        producer.send(activeMQTextMessage);
        //关闭链接
        producer.close();
        session.close();
        connection.close();


    }
}
