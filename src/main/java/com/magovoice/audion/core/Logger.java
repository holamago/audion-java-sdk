package com.magovoice.audion.core;

import org.slf4j.LoggerFactory;

/**
 * Logger utility for Audion SDK
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public final class Logger {
    
    /**
     * Get logger for the specified class
     * 
     * @param clazz the class to get logger for
     * @return the logger instance
     */
    public static org.slf4j.Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
    
    /**
     * Get logger for the specified name
     * 
     * @param name the logger name
     * @return the logger instance
     */
    public static org.slf4j.Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private Logger() {
        throw new UnsupportedOperationException("Utility class");
    }
} 