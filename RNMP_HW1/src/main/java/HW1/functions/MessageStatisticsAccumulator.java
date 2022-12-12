package HW1.functions;

import HW1.model.Message;
import HW1.model.MessageStatisticsResult;

import java.io.Serializable;
import java.util.DoubleSummaryStatistics;

public class MessageStatisticsAccumulator implements Serializable {

    private String key;

    private DoubleSummaryStatistics statistics;

    public MessageStatisticsAccumulator() {
        this.statistics = new DoubleSummaryStatistics();
    }

    public MessageStatisticsAccumulator(String key) {
        this.key = key;
        this.statistics = new DoubleSummaryStatistics();
    }

    public MessageStatisticsAccumulator(String key, DoubleSummaryStatistics statistics) {
        this.key = key;
        this.statistics = statistics;
    }

    public MessageStatisticsAccumulator add(Message message)
    {

        statistics.accept(message.getValue());
        return new MessageStatisticsAccumulator(
                message.getKey(),
                statistics);

    }

    public MessageStatisticsResult getResult()
    {
        MessageStatisticsResult result = new MessageStatisticsResult();
        result.setCount(statistics.getCount());
        result.setAverage(statistics.getAverage());
        result.setMax(statistics.getMax());
        result.setMin(statistics.getMin());
        result.setKey(this.key);
        return result;
    }

    public MessageStatisticsAccumulator merge(MessageStatisticsAccumulator other)
    {
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
        doubleSummaryStatistics.combine(this.statistics);
        doubleSummaryStatistics.combine(other.statistics);
        return new MessageStatisticsAccumulator(
                this.key,
                doubleSummaryStatistics
        );
    }
}


