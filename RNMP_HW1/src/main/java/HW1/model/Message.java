package HW1.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Generated("jsonschema2pojo")

public class Message  implements Serializable {

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("value")
    @Expose
    private Integer value;

    @SerializedName("timestamp")
    @Expose
    private Long timestamp;

    public Message() {
    }

    public Message(String key, Integer value, Long timestamp) {
        super();
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this, Message.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(key, message.key) && Objects.equals(value, message.value) && Objects.equals(timestamp, message.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, timestamp);
    }
}
