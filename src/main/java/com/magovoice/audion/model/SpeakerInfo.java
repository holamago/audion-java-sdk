package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Speaker information from diarization
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeakerInfo {

    /**
     * Number of speakers detected
     */
    @JsonProperty("num_speakers")
    private Integer numSpeakers;

    /**
     * List of speaker labels
     */
    @JsonProperty("speakers")
    private List<String> speakers;

    /**
     * Duration (in seconds) for each speaker
     * Key: speaker label (e.g., "SPEAKER_00")
     * Value: duration in seconds
     */
    @JsonProperty("duration")
    private Map<String, Double> duration;

    /**
     * Default constructor
     */
    public SpeakerInfo() {
    }

    /**
     * Constructor with all fields
     */
    public SpeakerInfo(Integer numSpeakers, List<String> speakers, Map<String, Double> duration) {
        this.numSpeakers = numSpeakers;
        this.speakers = speakers;
        this.duration = duration;
    }

    // Getters

    public Integer getNumSpeakers() {
        return numSpeakers;
    }

    public List<String> getSpeakers() {
        return speakers;
    }

    public Map<String, Double> getDuration() {
        return duration;
    }

    /**
     * Get duration for a specific speaker
     *
     * @param speaker the speaker label
     * @return duration in seconds, or null if speaker not found
     */
    public Double getDurationForSpeaker(String speaker) {
        return duration != null ? duration.get(speaker) : null;
    }

    // Setters

    public void setNumSpeakers(Integer numSpeakers) {
        this.numSpeakers = numSpeakers;
    }

    public void setSpeakers(List<String> speakers) {
        this.speakers = speakers;
    }

    public void setDuration(Map<String, Double> duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "SpeakerInfo{" +
                "numSpeakers=" + numSpeakers +
                ", speakers=" + speakers +
                ", duration=" + duration +
                '}';
    }
}
