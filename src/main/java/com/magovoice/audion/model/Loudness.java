package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Loudness analysis data
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loudness {

    @JsonProperty("loudness_min")
    private Double loudnessMin;

    @JsonProperty("loudness_max")
    private Double loudnessMax;

    @JsonProperty("loudness_outliers")
    private List<LoudnessOutlier> loudnessOutliers;

    @JsonProperty("loudness_label")
    private String loudnessLabel;

    @JsonProperty("loudness_mean")
    private Double loudnessMean;

    @JsonProperty("loudness_std")
    private Double loudnessStd;

    public Loudness() {
    }

    public Loudness(Double loudnessMin, Double loudnessMax, List<LoudnessOutlier> loudnessOutliers,
                    String loudnessLabel, Double loudnessMean, Double loudnessStd) {
        this.loudnessMin = loudnessMin;
        this.loudnessMax = loudnessMax;
        this.loudnessOutliers = loudnessOutliers;
        this.loudnessLabel = loudnessLabel;
        this.loudnessMean = loudnessMean;
        this.loudnessStd = loudnessStd;
    }

    public Double getLoudnessMin() {
        return loudnessMin;
    }

    public void setLoudnessMin(Double loudnessMin) {
        this.loudnessMin = loudnessMin;
    }

    public Double getLoudnessMax() {
        return loudnessMax;
    }

    public void setLoudnessMax(Double loudnessMax) {
        this.loudnessMax = loudnessMax;
    }

    public List<LoudnessOutlier> getLoudnessOutliers() {
        return loudnessOutliers;
    }

    public void setLoudnessOutliers(List<LoudnessOutlier> loudnessOutliers) {
        this.loudnessOutliers = loudnessOutliers;
    }

    public String getLoudnessLabel() {
        return loudnessLabel;
    }

    public void setLoudnessLabel(String loudnessLabel) {
        this.loudnessLabel = loudnessLabel;
    }

    public Double getLoudnessMean() {
        return loudnessMean;
    }

    public void setLoudnessMean(Double loudnessMean) {
        this.loudnessMean = loudnessMean;
    }

    public Double getLoudnessStd() {
        return loudnessStd;
    }

    public void setLoudnessStd(Double loudnessStd) {
        this.loudnessStd = loudnessStd;
    }

    @Override
    public String toString() {
        return "Loudness{" +
                "loudnessMin=" + loudnessMin +
                ", loudnessMax=" + loudnessMax +
                ", loudnessOutliers=" + loudnessOutliers +
                ", loudnessLabel='" + loudnessLabel + '\'' +
                ", loudnessMean=" + loudnessMean +
                ", loudnessStd=" + loudnessStd +
                '}';
    }
}
