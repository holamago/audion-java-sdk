package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Depression analysis information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepressionInfo {

    @JsonProperty("negative")
    private Double negative;

    @JsonProperty("positive")
    private Double positive;

    @JsonProperty("decoding_time")
    private Double decodingTime;

    public DepressionInfo() {
    }

    public DepressionInfo(Double negative, Double positive, Double decodingTime) {
        this.negative = negative;
        this.positive = positive;
        this.decodingTime = decodingTime;
    }

    public Double getNegative() {
        return negative;
    }

    public void setNegative(Double negative) {
        this.negative = negative;
    }

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }

    public Double getDecodingTime() {
        return decodingTime;
    }

    public void setDecodingTime(Double decodingTime) {
        this.decodingTime = decodingTime;
    }

    @Override
    public String toString() {
        return "DepressionInfo{" +
                "negative=" + negative +
                ", positive=" + positive +
                ", decodingTime=" + decodingTime +
                '}';
    }
}
