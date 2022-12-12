package HW1.factory;

import HW1.model.Message;
import HW1.model.schema.MessageDeserializationSchema;
import HW1.settings.ProjectSettings;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

public class KafkaSourceDataStream {

    public static DataStream<Message> getDataStream(ParameterTool parameterTool, StreamExecutionEnvironment env)
    {
        String topic = parameterTool.get(
                ProjectSettings.MESSAGE_TOPIC_NAME,
                ProjectSettings.MESSAGE_TOPIC
        );

        String brokers = parameterTool.get(
                "bootstrap.servers",
                "localhost:9092"
        );
        boolean eventTime = parameterTool.getBoolean(
                ProjectSettings.EVENT_TIME_PARAMETER,
                ProjectSettings.DEFAULT_EVENT_TIME
        );
        String timestampProperty = parameterTool.get(
                ProjectSettings.TIMESTAMP_PROPERTY_NAME,
                ProjectSettings.DEFAULT_TIMESTAMP_PROPERTY
        );
        FlinkKafkaConsumer<Message> kafkaConsumer = new FlinkKafkaConsumer<Message>(
                topic,
                new MessageDeserializationSchema(),
                parameterTool.getProperties()
        );

        return env.addSource(kafkaConsumer);
    }
}
