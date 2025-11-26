package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Utterance (speech segment) data
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Utterance {

    @JsonProperty("start")
    private Double start;

    @JsonProperty("end")
    private Double end;

    @JsonProperty("text")
    private String text;

    @JsonProperty("speaker")
    private String speaker;

    @JsonProperty("id")
    private String id;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("score")
    private Double score;

    @JsonProperty("emotion")
    private String emotion;

    @JsonProperty("emotion_info")
    private EmotionInfo emotionInfo;

    @JsonProperty("speed_info")
    private SpeedInfo speedInfo;

    @JsonProperty("voice_highlight")
    private VoiceHighlight voiceHighlight;

    public Utterance() {
    }

    public Utterance(Double start, Double end, String text, String speaker, String id,
                     String filename, Double score, String emotion, EmotionInfo emotionInfo,
                     SpeedInfo speedInfo, VoiceHighlight voiceHighlight) {
        this.start = start;
        this.end = end;
        this.text = text;
        this.speaker = speaker;
        this.id = id;
        this.filename = filename;
        this.score = score;
        this.emotion = emotion;
        this.emotionInfo = emotionInfo;
        this.speedInfo = speedInfo;
        this.voiceHighlight = voiceHighlight;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public EmotionInfo getEmotionInfo() {
        return emotionInfo;
    }

    public void setEmotionInfo(EmotionInfo emotionInfo) {
        this.emotionInfo = emotionInfo;
    }

    public SpeedInfo getSpeedInfo() {
        return speedInfo;
    }

    public void setSpeedInfo(SpeedInfo speedInfo) {
        this.speedInfo = speedInfo;
    }

    public VoiceHighlight getVoiceHighlight() {
        return voiceHighlight;
    }

    public void setVoiceHighlight(VoiceHighlight voiceHighlight) {
        this.voiceHighlight = voiceHighlight;
    }

    @Override
    public String toString() {
        return "Utterance{" +
                "start=" + start +
                ", end=" + end +
                ", text='" + text + '\'' +
                ", speaker='" + speaker + '\'' +
                ", id='" + id + '\'' +
                ", filename='" + filename + '\'' +
                ", score=" + score +
                ", emotion='" + emotion + '\'' +
                ", emotionInfo=" + emotionInfo +
                ", speedInfo=" + speedInfo +
                ", voiceHighlight=" + voiceHighlight +
                '}';
    }
}
