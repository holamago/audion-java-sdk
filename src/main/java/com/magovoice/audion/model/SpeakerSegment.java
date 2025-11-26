package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Speaker segment information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeakerSegment {

    @JsonProperty("segment")
    private SegmentTime segment;

    @JsonProperty("track")
    private Integer track;

    @JsonProperty("label")
    private String label;

    public SpeakerSegment() {
    }

    public SpeakerSegment(SegmentTime segment, Integer track, String label) {
        this.segment = segment;
        this.track = track;
        this.label = label;
    }

    public SegmentTime getSegment() {
        return segment;
    }

    public void setSegment(SegmentTime segment) {
        this.segment = segment;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "SpeakerSegment{" +
                "segment=" + segment +
                ", track=" + track +
                ", label='" + label + '\'' +
                '}';
    }
}
