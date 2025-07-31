package com.magovoice.audion.helper;

import java.util.Arrays;
import java.util.List;

/**
 * Constants for supported file extensions
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public final class Constants {
    
    /**
     * Supported audio file extensions
     */
    public static final List<String> AUDIO_FILE_EXTENSIONS = Arrays.asList(
        ".wav", ".mp3", ".m4a", ".ogg", ".flac", ".aac", ".wma", 
        ".m4b", ".m4p", ".m4r", ".m4v"
    );
    
    /**
     * Supported video file extensions
     */
    public static final List<String> VIDEO_FILE_EXTENSIONS = Arrays.asList(
        ".mp4", ".mov", ".avi", ".mkv", ".webm", ".wmv", ".flv", 
        ".mpeg", ".mpg", ".m4v"
    );
    
    /**
     * Private constructor to prevent instantiation
     */
    private Constants() {
        throw new UnsupportedOperationException("Utility class");
    }
} 