package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pitch outlier information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PitchOutlier {

    @JsonProperty("mean")
    private Double mean;

    @JsonProperty("label")
    private String label;

    @JsonProperty("start")
    private Double start;

    @JsonProperty("end")
    private Double end;

    public PitchOutlier() {
    }

    public PitchOutlier(Double mean, String label, Double start, Double end) {
        this.mean = mean;
        this.label = label;
        this.start = start;
        this.end = end;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        return "PitchOutlier{" +
                "mean=" + mean +
                ", label='" + label + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
