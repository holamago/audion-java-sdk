package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Emotion analysis information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmotionInfo {

    @JsonProperty("emotion")
    private Emotion emotion;

    @JsonProperty("best_emotion")
    private String bestEmotion;

    @JsonProperty("principal_vocal_biomarkers")
    private PrincipalVocalBiomarkers principalVocalBiomarkers;

    @JsonProperty("result_path")
    private String resultPath;

    @JsonProperty("decoding_time")
    private Double decodingTime;

    @JsonProperty("filename")
    private String filename;

    public EmotionInfo() {
    }

    public EmotionInfo(Emotion emotion, String bestEmotion, PrincipalVocalBiomarkers principalVocalBiomarkers,
                       String resultPath, Double decodingTime, String filename) {
        this.emotion = emotion;
        this.bestEmotion = bestEmotion;
        this.principalVocalBiomarkers = principalVocalBiomarkers;
        this.resultPath = resultPath;
        this.decodingTime = decodingTime;
        this.filename = filename;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public String getBestEmotion() {
        return bestEmotion;
    }

    public void setBestEmotion(String bestEmotion) {
        this.bestEmotion = bestEmotion;
    }

    public PrincipalVocalBiomarkers getPrincipalVocalBiomarkers() {
        return principalVocalBiomarkers;
    }

    public void setPrincipalVocalBiomarkers(PrincipalVocalBiomarkers principalVocalBiomarkers) {
        this.principalVocalBiomarkers = principalVocalBiomarkers;
    }

    public String getResultPath() {
        return resultPath;
    }

    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    public Double getDecodingTime() {
        return decodingTime;
    }

    public void setDecodingTime(Double decodingTime) {
        this.decodingTime = decodingTime;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "EmotionInfo{" +
                "emotion=" + emotion +
                ", bestEmotion='" + bestEmotion + '\'' +
                ", principalVocalBiomarkers=" + principalVocalBiomarkers +
                ", resultPath='" + resultPath + '\'' +
                ", decodingTime=" + decodingTime +
                ", filename='" + filename + '\'' +
                '}';
    }
}
