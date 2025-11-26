package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Segment time information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentTime {

    @JsonProperty("start")
    private Double start;

    @JsonProperty("end")
    private Double end;

    public SegmentTime() {
    }

    public SegmentTime(Double start, Double end) {
        this.start = start;
        this.end = end;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "SegmentTime{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
