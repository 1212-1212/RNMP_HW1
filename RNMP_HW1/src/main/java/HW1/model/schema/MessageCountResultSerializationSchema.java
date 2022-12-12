package HW1.model.schema;

import HW1.model.MessageCountResult;
import org.apache.flink.api.common.serialization.SerializationSchema;

public class MessageCountResultSerializationSchema implements SerializationSchema<MessageCountResult> {
    @Override
    public byte[] serialize(MessageCountResult messageCountResult) {
        return messageCountResult.toString().getBytes();
    }
}
