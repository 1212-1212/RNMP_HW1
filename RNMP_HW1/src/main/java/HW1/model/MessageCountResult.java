package HW1.model;

import com.google.gson.Gson;

import java.io.Serializable;

public class MessageCountResult implements Serializable {

    private String key;

    private Long count;



    public MessageCountResult(String key, Long count) {
        this.key = key;
        this.count = count;
    }



    public static MessageCountResult mapToMessageCountResult(MessageStatisticsResult messageStatisticsResult)
    {
        return new MessageCountResult(messageStatisticsResult.getKey(), messageStatisticsResult.getCount());
    }

    @Override
    public String toString() {
        return new Gson().toJson(this, MessageCountResult.class);
    }



}
