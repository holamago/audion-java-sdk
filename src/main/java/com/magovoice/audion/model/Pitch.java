package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Pitch analysis data
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pitch {

    @JsonProperty("pitch_mean")
    private Double pitchMean;

    @JsonProperty("pitch_std")
    private Double pitchStd;

    @JsonProperty("pitch_min")
    private Double pitchMin;

    @JsonProperty("pitch_max")
    private Double pitchMax;

    @JsonProperty("pitch_outliers")
    private List<PitchOutlier> pitchOutliers;

    public Pitch() {
    }

    public Pitch(Double pitchMean, Double pitchStd, Double pitchMin, Double pitchMax, List<PitchOutlier> pitchOutliers) {
        this.pitchMean = pitchMean;
        this.pitchStd = pitchStd;
        this.pitchMin = pitchMin;
        this.pitchMax = pitchMax;
        this.pitchOutliers = pitchOutliers;
    }

    public Double getPitchMean() {
        return pitchMean;
    }

    public void setPitchMean(Double pitchMean) {
        this.pitchMean = pitchMean;
    }

    public Double getPitchStd() {
        return pitchStd;
    }

    public void setPitchStd(Double pitchStd) {
        this.pitchStd = pitchStd;
    }

    public Double getPitchMin() {
        return pitchMin;
    }

    public void setPitchMin(Double pitchMin) {
        this.pitchMin = pitchMin;
    }

    public Double getPitchMax() {
        return pitchMax;
    }

    public void setPitchMax(Double pitchMax) {
        this.pitchMax = pitchMax;
    }

    public List<PitchOutlier> getPitchOutliers() {
        return pitchOutliers;
    }

    public void setPitchOutliers(List<PitchOutlier> pitchOutliers) {
        this.pitchOutliers = pitchOutliers;
    }

    @Override
    public String toString() {
        return "Pitch{" +
                "pitchMean=" + pitchMean +
                ", pitchStd=" + pitchStd +
                ", pitchMin=" + pitchMin +
                ", pitchMax=" + pitchMax +
                ", pitchOutliers=" + pitchOutliers +
                '}';
    }
}
