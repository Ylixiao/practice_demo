package com.sys.tryxx.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: tryxx
 * @description:
 * @author: xiao
 * @create: 2019-04-26 15:28
 **/
public class Consumer2 {

  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(Consumer.class);

    String pushConsumer = "PushConsumer23";
//服了我了 原来是端口号写错了 怪不得我总是消费不了
    //@Value("${apache.rocketmq.namesrvAddr")
    String namesvrAddr = "192.168.15.37:9876";

    logger.info("kankand------------------------");
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(pushConsumer);
    consumer.setNamesrvAddr(namesvrAddr);
    consumer.setMessageModel(MessageModel.BROADCASTING);
    try {
      consumer.subscribe("proTopic2", "push");
      consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
      consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {
        try {
          for (MessageExt messageExt : list) {
            System.out.println("22222222messageExt" + messageExt);//输出消息内容

//          String messageBody = new String(messageExt.getBody(), "utf-8");
//
//          System.out.println("消费响应222" + messageExt.getMsgId() + " msgbody222" + messageBody);
          }
        } catch (Exception e) {
          e.printStackTrace();
          return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
      });

      consumer.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}