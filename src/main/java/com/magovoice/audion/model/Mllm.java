package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MLLM (Multimodal Large Language Model) output data
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mllm {

    /**
     * Summary of the content
     */
    @JsonProperty("summary")
    private String summary;

    /**
     * Keywords extracted from the content
     */
    @JsonProperty("keywords")
    private String keywords;

    /**
     * Emotion summary of the content
     */
    @JsonProperty("emotion")
    private String emotion;

    /**
     * Complete answer in JSON format
     */
    @JsonProperty("answer")
    private String answer;

    /**
     * Default constructor
     */
    public Mllm() {
    }

    /**
     * Constructor with all fields
     */
    public Mllm(String summary, String keywords, String emotion, String answer) {
        this.summary = summary;
        this.keywords = keywords;
        this.emotion = emotion;
        this.answer = answer;
    }

    // Getters

    public String getSummary() {
        return summary;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getEmotion() {
        return emotion;
    }

    public String getAnswer() {
        return answer;
    }

    // Setters

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Mllm{" +
                "summary='" + summary + '\'' +
                ", keywords='" + keywords + '\'' +
                ", emotion='" + emotion + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
