package HW1.model.schema;

import HW1.model.Message;
import com.google.gson.Gson;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.io.IOException;

public class MessageDeserializationSchema implements DeserializationSchema<Message> {
    @Override
    public Message deserialize(byte[] bytes) throws IOException {
        return new Gson().fromJson(new String(bytes), Message.class);
    }

    @Override
    public boolean isEndOfStream(Message message) {
        return false;
    }

    @Override
    public TypeInformation<Message> getProducedType() {
        return TypeInformation.of(Message.class);
    }
}
