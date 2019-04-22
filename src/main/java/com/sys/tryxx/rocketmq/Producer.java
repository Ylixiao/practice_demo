package com.sys.tryxx.rocketmq;

import javax.annotation.PostConstruct;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

/**
 * @program: tryxx
 * @description:
 * @author: xiao
 * @create: 2018-12-07 16:15
 **/
@Component
public class Producer {

  public static void main(String[] args) {
    //首先我需要生产者组名
    //@Value("${apache.rocketmq.producer.producerGroup}")
    String producerGroup = "producer23";

    //oo 糟糕忘记了服务器地址啦啦
    //@Value("${apache.rocketmq.namesrvAddr")
    String namesvrAddr = "192.168.15.37:9876";

    DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
    producer.setNamesrvAddr(namesvrAddr);
    try {
      producer.start();
      for (int i = 0; i < 103; i++) {
        String messageBody = "看我的,请接收" + i;
        String message = new String((messageBody.getBytes()), "utf-8");
        //就可以开始构建信息啦
        Message msg = new Message("proTopic2", "push", message.getBytes());
        SendResult result = producer.send(msg);
        System.out.println("发送内容Id" + result.getMsgId() + "内容" + result.getSendStatus());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      producer.shutdown();
    }

  }
}
