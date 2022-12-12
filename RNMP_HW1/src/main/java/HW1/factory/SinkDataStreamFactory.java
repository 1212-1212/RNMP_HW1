package HW1.factory;

import HW1.model.MessageCountResult;
import HW1.model.MessageStatisticsResult;
import HW1.settings.ProjectSettings;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.functions.sink.PrintSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

public class SinkDataStreamFactory {

    public static SinkFunction<MessageStatisticsResult> getSinkMessageStatisticsResult(ParameterTool parameterTool)
    {
        boolean test = parameterTool.getBoolean(
                ProjectSettings.TEST_MODE,
                ProjectSettings.DEFAULT_TEST_MODE
        );

        if(test)
        {
            return new PrintSinkFunction<>();
        }
        else {
            return KafkaSinkDataStream.getKafkaSinkMessageStatisticsResult(parameterTool);
        }
    }
    public static SinkFunction<MessageCountResult> getSinkMessageCountResult(ParameterTool parameterTool)
    {
        boolean test = parameterTool.getBoolean(
                ProjectSettings.TEST_MODE,
                ProjectSettings.DEFAULT_TEST_MODE
        );

        if(test)
        {
            return new PrintSinkFunction<>();
        }
        else {
            return KafkaSinkDataStream.getKafkaSinkMessageCountResult(parameterTool);
        }
    }
    }



