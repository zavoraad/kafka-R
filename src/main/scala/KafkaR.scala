package com.zavoraad.kafka
import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.clients.consumer.{KafkaConsumer, ConsumerRecords}
import java.util.Collection

class KafkaR [A, B] (props: Properties) extends Serializable {

  lazy val consumer = new KafkaConsumer[A, B](props)
  lazy val producer = new KafkaProducer[A, B](props)
  /*
   Producer methods
   */


  def sendRecord(topic: String, key: A, value: B): Unit = {
    producer.send(new ProducerRecord(topic, key, value))
  }

  def flushProducer(){
    producer.flush
  }

  //Wait s Seconds before closing to wait for all requests to complete
  def closeProducer(s: Int = 1): Unit = {
    producer.close(s, java.util.concurrent.TimeUnit.SECONDS)
  }

  /*
   Consumer methods
   */

  def subscribe(topics: Collection[String]): Unit = {
    consumer.subscribe(topics)
  }

  def consume(): ConsumerRecords[A, B] = {
    return consumer.poll(10)
  }
}
