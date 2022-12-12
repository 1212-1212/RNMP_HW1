package HW1.factory;

import HW1.model.Message;
import HW1.settings.ProjectSettings;
import HW1.source.MessageSource;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class SourceDataStreamFactory {

    public static DataStream<Message> getStream(ParameterTool parameterTool, StreamExecutionEnvironment env)
    {
        boolean testMode = parameterTool.getBoolean(
                ProjectSettings.TEST_MODE,
                ProjectSettings.DEFAULT_TEST_MODE
        );

        if(testMode)
            return env.addSource(new MessageSource());
        else
            return KafkaSourceDataStream.getDataStream(parameterTool, env);
    }
}
