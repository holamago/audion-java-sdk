package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Content data from the flow response
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlowContent {

    /**
     * Unique document ID
     */
    @JsonProperty("documentId")
    private String documentId;

    /**
     * Flow execution time in seconds
     */
    @JsonProperty("flowingTime")
    private Double flowingTime;

    /**
     * Path to the result file
     */
    @JsonProperty("resultPath")
    private String resultPath;

    /**
     * Original uploaded filename
     */
    @JsonProperty("uploadFilename")
    private String uploadFilename;

    /**
     * File path on the server
     */
    @JsonProperty("filePath")
    private String filePath;

    /**
     * Thumbnail image path
     */
    @JsonProperty("thumbnailPath")
    private String thumbnailPath;

    /**
     * YouTube information (if input was a YouTube URL)
     */
    @JsonProperty("youtubeInfo")
    private YoutubeInfo youtubeInfo;

    /**
     * Flow output data
     */
    @JsonProperty("output")
    private Output output;

    /**
     * Default constructor
     */
    public FlowContent() {
    }

    /**
     * Constructor with all fields
     */
    public FlowContent(String documentId, Double flowingTime, String resultPath,
                      String uploadFilename, String filePath, String thumbnailPath,
                      YoutubeInfo youtubeInfo, Output output) {
        this.documentId = documentId;
        this.flowingTime = flowingTime;
        this.resultPath = resultPath;
        this.uploadFilename = uploadFilename;
        this.filePath = filePath;
        this.thumbnailPath = thumbnailPath;
        this.youtubeInfo = youtubeInfo;
        this.output = output;
    }

    // Getters

    public String getDocumentId() {
        return documentId;
    }

    public Double getFlowingTime() {
        return flowingTime;
    }

    public String getResultPath() {
        return resultPath;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public YoutubeInfo getYoutubeInfo() {
        return youtubeInfo;
    }

    public Output getOutput() {
        return output;
    }

    // Setters

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setFlowingTime(Double flowingTime) {
        this.flowingTime = flowingTime;
    }

    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public void setYoutubeInfo(YoutubeInfo youtubeInfo) {
        this.youtubeInfo = youtubeInfo;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "FlowContent{" +
                "documentId='" + documentId + '\'' +
                ", flowingTime=" + flowingTime +
                ", resultPath='" + resultPath + '\'' +
                ", uploadFilename='" + uploadFilename + '\'' +
                ", filePath='" + filePath + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                ", youtubeInfo=" + youtubeInfo +
                ", output=" + output +
                '}';
    }
}
