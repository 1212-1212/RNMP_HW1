package HW1.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Objects;

@Generated("jsonschema2pojo")
public class MessageStatisticsResult implements Serializable{

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("count")
    @Expose
    private Long count;

    @SerializedName("min")
    @Expose
    private Double min;

    @SerializedName("max")
    @Expose
    private Double max;

    @SerializedName("average")
    @Expose
    private Double average;

    @SerializedName("start_timestamp")
    @Expose

    private Long startTimeStamp;

    @SerializedName("end_timestamp")
    @Expose

    private Long endTimestamp;

    public MessageStatisticsResult() {
    }

    public MessageStatisticsResult(String key, Long count, Double min, Double max, Double average, Long startTimeStamp, Long endTimestamp) {
        this.key = key;
        this.count = count;
        this.min = min;
        this.max = max;
        this.average = average;
        this.startTimeStamp = startTimeStamp;
        this.endTimestamp = endTimestamp;
    }



    public String getKey() {
        return key;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this, MessageStatisticsResult.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageStatisticsResult that = (MessageStatisticsResult) o;
        return Objects.equals(key, that.key) && Objects.equals(count, that.count) && Objects.equals(startTimeStamp, that.startTimeStamp) && Objects.equals(endTimestamp, that.endTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, count, startTimeStamp, endTimestamp);
    }


}
