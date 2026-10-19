package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Output data from the flow response
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {

    /**
     * SRT file path
     */
    @JsonProperty("srt")
    private String srt;

    /**
     * MLLM (Multimodal Large Language Model) output
     */
    @JsonProperty("mllm")
    private Mllm mllm;

    /**
     * Utterances data
     */
    @JsonProperty("utterances")
    private List<Utterance> utterances;

    /**
     * VTT file path
     */
    @JsonProperty("vtt")
    private String vtt;

    /**
     * Media information
     */
    @JsonProperty("mediaInfo")
    private MediaInfo mediaInfo;

    /**
     * Speaker information
     */
    @JsonProperty("speakerInfo")
    private SpeakerInfo speakerInfo;

    /**
     * Speaker segments data
     */
    @JsonProperty("segments")
    private List<SpeakerSegment> segments;

    private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

    /**
     * Default constructor
     */
    public Output() {
    }

    /**
     * Constructor with all fields
     */
    public Output(String srt, Mllm mllm, List<Utterance> utterances, String vtt,
                  MediaInfo mediaInfo, SpeakerInfo speakerInfo, List<SpeakerSegment> segments) {
        this.srt = srt;
        this.mllm = mllm;
        this.utterances = utterances;
        this.vtt = vtt;
        this.mediaInfo = mediaInfo;
        this.speakerInfo = speakerInfo;
        this.segments = segments;
    }

    // Getters

    public String getSrt() {
        return srt;
    }

    public Mllm getMllm() {
        return mllm;
    }

    public List<Utterance> getUtterances() {
        return utterances;
    }

    public String getVtt() {
        return vtt;
    }

    public MediaInfo getMediaInfo() {
        return mediaInfo;
    }

    public SpeakerInfo getSpeakerInfo() {
        return speakerInfo;
    }

    public List<SpeakerSegment> getSegments() {
        return segments;
    }

    // Setters

    public void setSrt(String srt) {
        this.srt = srt;
    }

    public void setMllm(Mllm mllm) {
        this.mllm = mllm;
    }

    public void setUtterances(List<Utterance> utterances) {
        this.utterances = utterances;
    }

    public void setVtt(String vtt) {
        this.vtt = vtt;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public void setSpeakerInfo(SpeakerInfo speakerInfo) {
        this.speakerInfo = speakerInfo;
    }

    public void setSegments(List<SpeakerSegment> segments) {
        this.segments = segments;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public String toString() {
        return "Output{" +
                "srt='" + srt + '\'' +
                ", mllm=" + mllm +
                ", utterances=" + utterances +
                ", vtt='" + vtt + '\'' +
                ", mediaInfo=" + mediaInfo +
                ", speakerInfo=" + speakerInfo +
                ", segments=" + segments +
                '}';
    }
}
