package HW1.source;

import HW1.model.Message;
import com.google.gson.Gson;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Arrays;

public class MessageSource implements SourceFunction<Message> {

    private String [] messages = {
           "{\"key\": \"B\", \"value\": 370, \"timestamp\": 1669748895562}",
            "{\"key\": \"A\", \"value\": 250, \"timestamp\": 1669748897562}",
            "{\"key\": \"C\", \"value\": 500, \"timestamp\": 1669748899562}"
    };

    private Gson gson = new Gson();
    @Override
    public void run(SourceContext<Message> sourceContext) throws Exception {
        Thread.sleep(2000);
        Arrays.stream(messages)
                .forEach(message -> {
                    sourceContext.collect(gson.fromJson(message, Message.class));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Override
    public void cancel() {

    }
}
