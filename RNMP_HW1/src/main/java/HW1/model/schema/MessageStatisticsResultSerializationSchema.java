package HW1.model.schema;

import HW1.model.MessageStatisticsResult;
import org.apache.flink.api.common.serialization.SerializationSchema;

public class MessageStatisticsResultSerializationSchema implements SerializationSchema<MessageStatisticsResult> {
    @Override
    public byte[] serialize(MessageStatisticsResult messageStatisticsResult) {
        return messageStatisticsResult.toString().getBytes();
    }
}
