package HW1.factory;

import HW1.model.MessageCountResult;
import HW1.model.MessageStatisticsResult;
import HW1.model.schema.MessageCountResultSerializationSchema;
import HW1.model.schema.MessageStatisticsResultSerializationSchema;
import HW1.settings.ProjectSettings;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

public class KafkaSinkDataStream {

    public static SinkFunction<MessageStatisticsResult> getKafkaSinkMessageStatisticsResult(ParameterTool parameterTool)
    {

        return new FlinkKafkaProducer<MessageStatisticsResult> (
                ProjectSettings.SINK_TOPIC_NAME_TASK_2,
                new MessageStatisticsResultSerializationSchema(),
                parameterTool.getProperties()
        );

    }
    public static SinkFunction<MessageCountResult> getKafkaSinkMessageCountResult(ParameterTool parameterTool)
    {
        return  new FlinkKafkaProducer<MessageCountResult>(
                ProjectSettings.SINK_TOPIC_NAME_TASK_1,
                new MessageCountResultSerializationSchema(),
                parameterTool.getProperties()
        );
    }







}
