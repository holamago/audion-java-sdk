package com.magovoice.audion.helper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Utils
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public class UtilsTest {
    
    @Test
    void testGetMediaTypeForAudioFiles() {
        assertEquals("audio/wav", Utils.getMediaType("test.wav"));
        assertEquals("audio/wav", Utils.getMediaType("test.mp3"));
        assertEquals("audio/wav", Utils.getMediaType("test.m4a"));
        assertEquals("audio/wav", Utils.getMediaType("test.ogg"));
        assertEquals("audio/wav", Utils.getMediaType("test.flac"));
        assertEquals("audio/wav", Utils.getMediaType("test.aac"));
        assertEquals("audio/wav", Utils.getMediaType("test.wma"));
    }
    
    @Test
    void testGetMediaTypeForVideoFiles() {
        assertEquals("video/mp4", Utils.getMediaType("test.mp4"));
        assertEquals("video/mp4", Utils.getMediaType("test.mov"));
        assertEquals("video/mp4", Utils.getMediaType("test.avi"));
        assertEquals("video/mp4", Utils.getMediaType("test.mkv"));
        assertEquals("video/mp4", Utils.getMediaType("test.webm"));
        assertEquals("video/mp4", Utils.getMediaType("test.wmv"));
        assertEquals("video/mp4", Utils.getMediaType("test.flv"));
        assertEquals("video/mp4", Utils.getMediaType("test.mpeg"));
        assertEquals("video/mp4", Utils.getMediaType("test.mpg"));
    }
    
    @Test
    void testGetMediaTypeWithPath() {
        assertEquals("audio/wav", Utils.getMediaType("/path/to/audio.wav"));
        assertEquals("video/mp4", Utils.getMediaType("/path/to/video.mp4"));
    }
    
    @Test
    void testGetMediaTypeWithUnsupportedExtension() {
        assertThrows(IllegalArgumentException.class, () -> {
            Utils.getMediaType("test.txt");
        });
    }
    
    @Test
    void testGetMediaTypeWithNoExtension() {
        assertThrows(IllegalArgumentException.class, () -> {
            Utils.getMediaType("testfile");
        });
    }
    
    @Test
    void testGetMediaTypeWithCaseInsensitive() {
        assertEquals("audio/wav", Utils.getMediaType("test.WAV"));
        assertEquals("video/mp4", Utils.getMediaType("test.MP4"));
    }
} 