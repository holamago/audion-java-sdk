package com.magovoice.audion.helper;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility methods for Audion SDK
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public final class Utils {
    
    /**
     * Get the media type of the file based on its extension
     * 
     * @param filePath the path to the file
     * @return the media type string
     * @throws IllegalArgumentException if the file extension is not supported
     */
    public static String getMediaType(String filePath) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        String extension = getFileExtension(fileName).toLowerCase();
        
        if (Constants.AUDIO_FILE_EXTENSIONS.contains(extension)) {
            return "audio/wav";
        } else if (Constants.VIDEO_FILE_EXTENSIONS.contains(extension)) {
            return "video/mp4";
        } else {
            throw new IllegalArgumentException("Unsupported file extension: " + extension);
        }
    }
    
    /**
     * Extract file extension from filename
     * 
     * @param fileName the filename
     * @return the file extension including the dot
     */
    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex);
        }
        return "";
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private Utils() {
        throw new UnsupportedOperationException("Utility class");
    }
} 