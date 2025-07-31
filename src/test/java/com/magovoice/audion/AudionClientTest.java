package com.magovoice.audion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AudionClient
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public class AudionClientTest {
    
    private AudionClient client;
    
    @BeforeEach
    void setUp() {
        client = new AudionClient("test-api-key");
    }
    
    @Test
    void testConstructorWithValidApiKey() {
        assertNotNull(client);
    }
    
    @Test
    void testConstructorWithNullApiKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudionClient(null);
        });
    }
    
    @Test
    void testConstructorWithEmptyApiKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudionClient("");
        });
    }
    
    @Test
    void testConstructorWithWhitespaceApiKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudionClient("   ");
        });
    }
    
    @Test
    void testConstructorWithCustomBaseUrl() {
        AudionClient customClient = new AudionClient("test-api-key", "https://custom.example.com");
        assertNotNull(customClient);
    }
    
    @Test
    void testConstructorWithCustomTimeout() {
        AudionClient customClient = new AudionClient("test-api-key", null, 60);
        assertNotNull(customClient);
    }
} 