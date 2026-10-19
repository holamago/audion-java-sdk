package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @JsonProperty("dementia_info")
    private DementiaInfo dementiaInfo;

    @JsonProperty("depression_info")
    private DepressionInfo depressionInfo;

    @JsonProperty("words")
    private List<Object> words;

    @JsonProperty("principal_biomarker_evaluations")
    private Map<String, BiomarkerMetric> principalBiomarkerEvaluations;

    @JsonProperty("interpretations")
    private Map<String, BiomarkerMetric> interpretations;

    @JsonProperty("vad_scores")
    private Map<String, Double> vadScores;

    @JsonProperty("text_temporal_features")
    private Map<String, Double> textTemporalFeatures;

    @JsonProperty("vbm_emotion_class")
    private String vbmEmotionClass;

    private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public Utterance() {
    }

    public Utterance(Double start, Double end, String text, String speaker, String id,
                     String filename, Double score, String emotion, EmotionInfo emotionInfo,
                     SpeedInfo speedInfo, VoiceHighlight voiceHighlight,
                     DementiaInfo dementiaInfo, DepressionInfo depressionInfo) {
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
        this.dementiaInfo = dementiaInfo;
        this.depressionInfo = depressionInfo;
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

    public DementiaInfo getDementiaInfo() {
        return dementiaInfo;
    }

    public void setDementiaInfo(DementiaInfo dementiaInfo) {
        this.dementiaInfo = dementiaInfo;
    }

    public DepressionInfo getDepressionInfo() {
        return depressionInfo;
    }

    public List<Object> getWords() {
        return words;
    }

    public void setDepressionInfo(DepressionInfo depressionInfo) {
        this.depressionInfo = depressionInfo;
    }

    public void setWords(List<Object> words) {
        this.words = words;
    }

    public Map<String, BiomarkerMetric> getPrincipalBiomarkerEvaluations() {
        return principalBiomarkerEvaluations;
    }

    public void setPrincipalBiomarkerEvaluations(
            Map<String, BiomarkerMetric> principalBiomarkerEvaluations) {
        this.principalBiomarkerEvaluations = principalBiomarkerEvaluations;
    }

    public Map<String, BiomarkerMetric> getInterpretations() {
        return interpretations;
    }

    public void setInterpretations(Map<String, BiomarkerMetric> interpretations) {
        this.interpretations = interpretations;
    }

    public Map<String, Double> getVadScores() {
        return vadScores;
    }

    public void setVadScores(Map<String, Double> vadScores) {
        this.vadScores = vadScores;
    }

    public Map<String, Double> getTextTemporalFeatures() {
        return textTemporalFeatures;
    }

    public void setTextTemporalFeatures(Map<String, Double> textTemporalFeatures) {
        this.textTemporalFeatures = textTemporalFeatures;
    }

    public String getVbmEmotionClass() {
        return vbmEmotionClass;
    }

    public void setVbmEmotionClass(String vbmEmotionClass) {
        this.vbmEmotionClass = vbmEmotionClass;
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
                ", dementiaInfo=" + dementiaInfo +
                ", depressionInfo=" + depressionInfo +
                ", words=" + words +
                ", principalBiomarkerEvaluations=" + principalBiomarkerEvaluations +
                ", interpretations=" + interpretations +
                ", vadScores=" + vadScores +
                ", textTemporalFeatures=" + textTemporalFeatures +
                ", vbmEmotionClass='" + vbmEmotionClass + '\'' +
                '}';
    }
}
