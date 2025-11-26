package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Media information from the flow response
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaInfo {

    /**
     * Codec type (e.g., "video", "audio")
     */
    @JsonProperty("codec_type")
    private String codecType;

    /**
     * Duration in seconds
     */
    @JsonProperty("duration")
    private Double duration;

    /**
     * Sample rate
     */
    @JsonProperty("sample_rate")
    private String sampleRate;

    /**
     * Number of channels
     */
    @JsonProperty("channels")
    private Integer channels;

    /**
     * Sample format
     */
    @JsonProperty("sample_format")
    private String sampleFormat;

    /**
     * Codec name
     */
    @JsonProperty("codec_name")
    private String codecName;

    /**
     * Default constructor
     */
    public MediaInfo() {
    }

    /**
     * Constructor with all fields
     */
    public MediaInfo(String codecType, Double duration, String sampleRate,
                     Integer channels, String sampleFormat, String codecName) {
        this.codecType = codecType;
        this.duration = duration;
        this.sampleRate = sampleRate;
        this.channels = channels;
        this.sampleFormat = sampleFormat;
        this.codecName = codecName;
    }

    // Getters

    public String getCodecType() {
        return codecType;
    }

    public Double getDuration() {
        return duration;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public Integer getChannels() {
        return channels;
    }

    public String getSampleFormat() {
        return sampleFormat;
    }

    public String getCodecName() {
        return codecName;
    }

    // Setters

    public void setCodecType(String codecType) {
        this.codecType = codecType;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public void setSampleFormat(String sampleFormat) {
        this.sampleFormat = sampleFormat;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    @Override
    public String toString() {
        return "MediaInfo{" +
                "codecType='" + codecType + '\'' +
                ", duration=" + duration +
                ", sampleRate='" + sampleRate + '\'' +
                ", channels=" + channels +
                ", sampleFormat='" + sampleFormat + '\'' +
                ", codecName='" + codecName + '\'' +
                '}';
    }
}
