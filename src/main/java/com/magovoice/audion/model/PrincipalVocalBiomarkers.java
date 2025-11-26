package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Principal vocal biomarkers data
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrincipalVocalBiomarkers {

    @JsonProperty("rms")
    private Double rms;

    @JsonProperty("snr")
    private Double snr;

    @JsonProperty("pitch")
    private Double pitch;

    @JsonProperty("pitch_variation")
    private Double pitchVariation;

    @JsonProperty("brightness")
    private Double brightness;

    public PrincipalVocalBiomarkers() {
    }

    public PrincipalVocalBiomarkers(Double rms, Double snr, Double pitch, Double pitchVariation, Double brightness) {
        this.rms = rms;
        this.snr = snr;
        this.pitch = pitch;
        this.pitchVariation = pitchVariation;
        this.brightness = brightness;
    }

    public Double getRms() {
        return rms;
    }

    public void setRms(Double rms) {
        this.rms = rms;
    }

    public Double getSnr() {
        return snr;
    }

    public void setSnr(Double snr) {
        this.snr = snr;
    }

    public Double getPitch() {
        return pitch;
    }

    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    public Double getPitchVariation() {
        return pitchVariation;
    }

    public void setPitchVariation(Double pitchVariation) {
        this.pitchVariation = pitchVariation;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "PrincipalVocalBiomarkers{" +
                "rms=" + rms +
                ", snr=" + snr +
                ", pitch=" + pitch +
                ", pitchVariation=" + pitchVariation +
                ", brightness=" + brightness +
                '}';
    }
}
