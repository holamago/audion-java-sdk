package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dementia analysis information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DementiaInfo {

    @JsonProperty("dementia")
    private Double dementia;

    @JsonProperty("control")
    private Double control;

    @JsonProperty("decoding_time")
    private Double decodingTime;

    public DementiaInfo() {
    }

    public DementiaInfo(Double dementia, Double control, Double decodingTime) {
        this.dementia = dementia;
        this.control = control;
        this.decodingTime = decodingTime;
    }

    public Double getDementia() {
        return dementia;
    }

    public void setDementia(Double dementia) {
        this.dementia = dementia;
    }

    public Double getControl() {
        return control;
    }

    public void setControl(Double control) {
        this.control = control;
    }

    public Double getDecodingTime() {
        return decodingTime;
    }

    public void setDecodingTime(Double decodingTime) {
        this.decodingTime = decodingTime;
    }

    @Override
    public String toString() {
        return "DementiaInfo{" +
                "dementia=" + dementia +
                ", control=" + control +
                ", decodingTime=" + decodingTime +
                '}';
    }
}
