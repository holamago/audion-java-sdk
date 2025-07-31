package com.magovoice.audion.config;

/**
 * Configuration constants for Audion SDK
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public final class AudionConfig {
    
    /**
     * Production server URL
     */
    public static final String PRODUCTION_URL = "https://audion.magovoice.com/go-framework/v1/go";
    
    /**
     * Default timeout in seconds
     */
    public static final int TIMEOUT = 300;
    
    /**
     * Private constructor to prevent instantiation
     */
    private AudionConfig() {
        throw new UnsupportedOperationException("Utility class");
    }
} 