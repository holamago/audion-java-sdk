package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * YouTube information from the flow response
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YoutubeInfo {

    /**
     * YouTube video metadata
     */
    @JsonProperty("metadata")
    private YoutubeMetadata metadata;

    /**
     * Downloaded video file path
     */
    @JsonProperty("videoPath")
    private String videoPath;

    /**
     * Extracted audio file path
     */
    @JsonProperty("audioPath")
    private String audioPath;

    /**
     * Default constructor
     */
    public YoutubeInfo() {
    }

    /**
     * Constructor with all fields
     */
    public YoutubeInfo(YoutubeMetadata metadata, String videoPath, String audioPath) {
        this.metadata = metadata;
        this.videoPath = videoPath;
        this.audioPath = audioPath;
    }

    // Getters

    public YoutubeMetadata getMetadata() {
        return metadata;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getAudioPath() {
        return audioPath;
    }

    // Setters

    public void setMetadata(YoutubeMetadata metadata) {
        this.metadata = metadata;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    @Override
    public String toString() {
        return "YoutubeInfo{" +
                "metadata=" + metadata +
                ", videoPath='" + videoPath + '\'' +
                ", audioPath='" + audioPath + '\'' +
                '}';
    }
}
