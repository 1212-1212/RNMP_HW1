package HW1.functions;

import HW1.model.Message;
import HW1.model.MessageStatisticsResult;
import org.apache.flink.api.common.functions.AggregateFunction;

public class MessageStatisticsAggregateFunction implements AggregateFunction<Message, MessageStatisticsAccumulator, MessageStatisticsResult> {
    @Override
    public MessageStatisticsAccumulator createAccumulator() {
        return new MessageStatisticsAccumulator();
    }

    @Override
    public MessageStatisticsAccumulator add(Message message, MessageStatisticsAccumulator messageStatisticsAccumulator) {
        return messageStatisticsAccumulator.add(message);
    }

    @Override
    public MessageStatisticsResult getResult(MessageStatisticsAccumulator messageStatisticsAccumulator) {
        return messageStatisticsAccumulator.getResult();
    }

    @Override
    public MessageStatisticsAccumulator merge(MessageStatisticsAccumulator messageStatisticsAccumulator, MessageStatisticsAccumulator other) {
        return messageStatisticsAccumulator.merge(other);
    }
}
