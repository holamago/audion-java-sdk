package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Emotion scores
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Emotion {

    @JsonProperty("SURPRISE")
    private Integer surprise;

    @JsonProperty("SADNESS")
    private Integer sadness;

    @JsonProperty("HAPPINESS")
    private Integer happiness;

    @JsonProperty("ANGRY")
    private Integer angry;

    @JsonProperty("NEUTRAL")
    private Integer neutral;

    public Emotion() {
    }

    public Emotion(Integer surprise, Integer sadness, Integer happiness, Integer angry, Integer neutral) {
        this.surprise = surprise;
        this.sadness = sadness;
        this.happiness = happiness;
        this.angry = angry;
        this.neutral = neutral;
    }

    public Integer getSurprise() {
        return surprise;
    }

    public void setSurprise(Integer surprise) {
        this.surprise = surprise;
    }

    public Integer getSadness() {
        return sadness;
    }

    public void setSadness(Integer sadness) {
        this.sadness = sadness;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public Integer getAngry() {
        return angry;
    }

    public void setAngry(Integer angry) {
        this.angry = angry;
    }

    public Integer getNeutral() {
        return neutral;
    }

    public void setNeutral(Integer neutral) {
        this.neutral = neutral;
    }

    @Override
    public String toString() {
        return "Emotion{" +
                "surprise=" + surprise +
                ", sadness=" + sadness +
                ", happiness=" + happiness +
                ", angry=" + angry +
                ", neutral=" + neutral +
                '}';
    }
}
