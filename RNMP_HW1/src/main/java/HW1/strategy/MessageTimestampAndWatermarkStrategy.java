package HW1.strategy;

import HW1.model.Message;
import org.apache.flink.api.common.eventtime.*;

public class MessageTimestampAndWatermarkStrategy implements WatermarkStrategy<Message> {
    @Override
    public WatermarkGenerator<Message> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
        return new WatermarkGenerator<Message>() {
            @Override
            public void onEvent(Message message, long l, WatermarkOutput watermarkOutput) {
                watermarkOutput.emitWatermark(new Watermark(message.getTimestamp()));
            }

            @Override
            public void onPeriodicEmit(WatermarkOutput watermarkOutput) {
                watermarkOutput.emitWatermark(new Watermark(System.currentTimeMillis()));
            }
        };
    }

    @Override
    public TimestampAssigner<Message> createTimestampAssigner(TimestampAssignerSupplier.Context context) {
        return (element, recordTimestamp) -> element.getTimestamp();
    }
}
