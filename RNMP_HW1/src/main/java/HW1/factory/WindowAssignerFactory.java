package HW1.factory;

import HW1.model.Message;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.*;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.windowing.windows.Window;

import static HW1.settings.ProjectSettings.*;

public class WindowAssignerFactory {

    public static WindowAssigner<Object, TimeWindow> getWindow(ParameterTool parameterTool)
    {
        String windowType = parameterTool.get(WINDOW_TYPE);

        boolean isEventTime = parameterTool.getBoolean(EVENT_TIME_PARAMETER, DEFAULT_EVENT_TIME);

        int windowIntervalSizeInSeconds = parameterTool.getInt(WINDOW_INTERVAL_SIZE, 1);
        int windowSlideSizeInSeconds = parameterTool.getInt(WINDOW_SLIDE_SIZE, 1);
        WindowAssigner<Object, TimeWindow> result;

        if(windowType.equalsIgnoreCase(WINDOW_TYPE_TUMBLING) && isEventTime)
        {
            result = TumblingEventTimeWindows.of(Time.seconds(windowIntervalSizeInSeconds));
        }
        else if(windowType.equalsIgnoreCase(WINDOW_TYPE_SLIDING) && isEventTime)
        {
            result = SlidingEventTimeWindows.of(Time.seconds(windowIntervalSizeInSeconds), Time.seconds(windowSlideSizeInSeconds));
        }
        else if(windowType.equalsIgnoreCase(WINDOW_TYPE_TUMBLING) && !isEventTime)
        {
            result = TumblingProcessingTimeWindows.of(Time.seconds(windowIntervalSizeInSeconds));
        }
        else
        {
            result = SlidingProcessingTimeWindows.of(Time.seconds(windowIntervalSizeInSeconds), Time.seconds(windowSlideSizeInSeconds));
        }
        System.out.println(result.getClass().getName());
        System.out.println(windowType);
        System.out.println(windowIntervalSizeInSeconds);
        System.out.println(windowSlideSizeInSeconds);
        return result;
    }
}
