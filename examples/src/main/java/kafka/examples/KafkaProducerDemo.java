package kafka.examples;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.Producer;
import java.util.Properties;

public class KafkaProducerDemo {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");

        props.put("linger.ms", 1);
        props.put("batch.size", 10); // default： 16384

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        System.out.println();
        long startTime = System.currentTimeMillis ();
        for (int i = 0; i < 100; i++){
            // send 异步
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)));
        }
        long endTime = System.currentTimeMillis (); //获取结束时间.
        System.out.println ("程序运行时间：" + (endTime - startTime) + "ms");
        producer.close();
    }
}
