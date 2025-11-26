package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Voice highlight data (only available in audion_vh flow)
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoiceHighlight {

    @JsonProperty("pitch")
    private Pitch pitch;

    @JsonProperty("loudness")
    private Loudness loudness;

    @JsonProperty("audio_duration")
    private Double audioDuration;

    public VoiceHighlight() {
    }

    public VoiceHighlight(Pitch pitch, Loudness loudness, Double audioDuration) {
        this.pitch = pitch;
        this.loudness = loudness;
        this.audioDuration = audioDuration;
    }

    public Pitch getPitch() {
        return pitch;
    }

    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    public Loudness getLoudness() {
        return loudness;
    }

    public void setLoudness(Loudness loudness) {
        this.loudness = loudness;
    }

    public Double getAudioDuration() {
        return audioDuration;
    }

    public void setAudioDuration(Double audioDuration) {
        this.audioDuration = audioDuration;
    }

    @Override
    public String toString() {
        return "VoiceHighlight{" +
                "pitch=" + pitch +
                ", loudness=" + loudness +
                ", audioDuration=" + audioDuration +
                '}';
    }
}
