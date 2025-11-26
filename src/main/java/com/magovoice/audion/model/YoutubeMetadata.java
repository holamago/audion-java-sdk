package com.magovoice.audion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * YouTube metadata information
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YoutubeMetadata {

    /**
     * YouTube video ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * Video title
     */
    @JsonProperty("title")
    private String title;

    /**
     * Video duration in seconds
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * Thumbnail URL
     */
    @JsonProperty("thumbnail")
    private String thumbnail;

    /**
     * Webpage URL
     */
    @JsonProperty("webpage_url")
    private String webpageUrl;

    /**
     * Channel name
     */
    @JsonProperty("uploader")
    private String uploader;

    /**
     * Upload date (YYYYMMDD format)
     */
    @JsonProperty("upload_date")
    private String uploadDate;

    /**
     * View count
     */
    @JsonProperty("view_count")
    private Long viewCount;

    /**
     * Like count
     */
    @JsonProperty("like_count")
    private Long likeCount;

    /**
     * Dislike count
     */
    @JsonProperty("dislike_count")
    private Long dislikeCount;

    /**
     * Default constructor
     */
    public YoutubeMetadata() {
    }

    /**
     * Constructor with all fields
     */
    public YoutubeMetadata(String id, String title, Integer duration, String thumbnail,
                          String webpageUrl, String uploader, String uploadDate,
                          Long viewCount, Long likeCount, Long dislikeCount) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.thumbnail = thumbnail;
        this.webpageUrl = webpageUrl;
        this.uploader = uploader;
        this.uploadDate = uploadDate;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public String getUploader() {
        return uploader;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public Long getDislikeCount() {
        return dislikeCount;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public void setDislikeCount(Long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    @Override
    public String toString() {
        return "YoutubeMetadata{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", thumbnail='" + thumbnail + '\'' +
                ", webpageUrl='" + webpageUrl + '\'' +
                ", uploader='" + uploader + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                ", viewCount=" + viewCount +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                '}';
    }
}
