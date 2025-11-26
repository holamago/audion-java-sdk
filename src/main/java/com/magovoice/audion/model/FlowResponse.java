package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response model for flow API calls
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlowResponse {

    /**
     * Response status (e.g., "success", "error")
     */
    @JsonProperty("status")
    private String status;

    /**
     * Response message
     */
    @JsonProperty("message")
    private String message;

    /**
     * Flow execution result content
     */
    @JsonProperty("content")
    private FlowContent content;

    /**
     * Default constructor
     */
    public FlowResponse() {
    }

    /**
     * Constructor with all fields
     */
    public FlowResponse(String status, String message, FlowContent content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    // Getters

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public FlowContent getContent() {
        return content;
    }

    // Setters

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(FlowContent content) {
        this.content = content;
    }

    /**
     * Check if the response indicates success
     *
     * @return true if status is "success"
     */
    public boolean isSuccess() {
        return "success".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "FlowResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
