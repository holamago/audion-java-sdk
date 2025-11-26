package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Speech speed information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeedInfo {

    @JsonProperty("speed")
    private Double speed;

    @JsonProperty("speech_level")
    private String speechLevel;

    public SpeedInfo() {
    }

    public SpeedInfo(Double speed, String speechLevel) {
        this.speed = speed;
        this.speechLevel = speechLevel;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getSpeechLevel() {
        return speechLevel;
    }

    public void setSpeechLevel(String speechLevel) {
        this.speechLevel = speechLevel;
    }

    @Override
    public String toString() {
        return "SpeedInfo{" +
                "speed=" + speed +
                ", speechLevel='" + speechLevel + '\'' +
                '}';
    }
}
