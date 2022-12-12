package HW1;

import HW1.factory.KafkaSinkDataStream;
import HW1.factory.SinkDataStreamFactory;
import HW1.factory.SourceDataStreamFactory;
import HW1.factory.WindowAssignerFactory;
import HW1.functions.MessageStatisticsAggregateFunction;
import HW1.model.Message;
import HW1.model.MessageCountResult;
import HW1.model.MessageStatisticsResult;
import HW1.settings.ProjectSettings;
import HW1.strategy.MessageTimestampAndWatermarkStrategy;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

public class Task1 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        ParameterTool parameterTool = ParameterTool.fromArgs(args);

        DataStream<Message> inputStream = SourceDataStreamFactory
                .getStream(parameterTool, env)
                .assignTimestampsAndWatermarks(new MessageTimestampAndWatermarkStrategy());

        KeyedStream<Message, String> messageByKeyStream = inputStream
                .keyBy(Message::getKey);


        WindowedStream<Message, String, TimeWindow> windowedStream = messageByKeyStream.window(WindowAssignerFactory.getWindow(parameterTool));


        DataStream<MessageCountResult> result = windowedStream.aggregate(new MessageStatisticsAggregateFunction())
                .map(MessageCountResult::mapToMessageCountResult);


        System.out.println(parameterTool.getProperties());
      //  result.print();

        result.addSink(SinkDataStreamFactory.getSinkMessageCountResult(parameterTool));


        env.execute(Task1.class.getName());
    }
}
