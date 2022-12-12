package HW1.functions;

import HW1.model.Message;

import HW1.model.MessageStatisticsResult;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MessageStatisticsApplyFunction implements WindowFunction<Message, MessageStatisticsResult, String, TimeWindow> {
    @Override
    public void apply(String key, TimeWindow window, Iterable<Message> iterable, Collector<MessageStatisticsResult> collector) throws Exception {
       MessageStatisticsAccumulator accumulator = new MessageStatisticsAccumulator();
        for (Message message : iterable) {
            accumulator.add(message);
        }


        MessageStatisticsResult result = accumulator.getResult();
        result.setKey(key);
        result.setStartTimeStamp(window.getStart());
        result.setEndTimestamp(window.getEnd());
        collector.collect(result);

    }
}
