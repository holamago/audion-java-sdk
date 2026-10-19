package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A vocal-biomarker measurement and its classification.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BiomarkerMetric {

    @JsonProperty("value")
    private Object value;

    @JsonProperty("level")
    private Object level;

    @JsonProperty("unit")
    private String unit;

    public BiomarkerMetric() {
    }

    public BiomarkerMetric(Object value, Object level) {
        this.value = value;
        this.level = level;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getLevel() {
        return level;
    }

    public void setLevel(Object level) {
        this.level = level;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "BiomarkerMetric{" +
                "value=" + value +
                ", level=" + level +
                ", unit='" + unit + '\'' +
                '}';
    }
}
