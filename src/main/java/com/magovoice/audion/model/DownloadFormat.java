package com.magovoice.audion.model;

/**
 * Supported subtitle download formats
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.4
 */
public enum DownloadFormat {

    SRT("srt"),
    VTT("vtt");

    private final String value;

    DownloadFormat(String value) {
        this.value = value;
    }

    /**
     * @return the query parameter value (e.g. "srt", "vtt")
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the file extension including dot (e.g. ".srt", ".vtt")
     */
    public String getExtension() {
        return "." + value;
    }
}
