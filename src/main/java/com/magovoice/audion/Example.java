package com.magovoice.audion;

import java.io.IOException;

/**
 * Example usage of Audion Java SDK
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public class Example {
    
    public static void main(String[] args) {
        // Initialize the client with your API key
        AudionClient client = new AudionClient("mk-h19xW7wb_tjMyja8OpOYeGgjWtzSnGajtRSF55yH7L-qvYes");
        
        try {
            // Process a YouTube URL
            Object result = client.flow(
                "audion_vu",
                "url",
                "https://youtube.com/shorts/HIpBeKKxQWg?si=671h6ncNkUlSe8nE"
            );
            
            System.out.println("Result: " + result);
            
        } catch (IOException e) {
            System.err.println("Error processing request: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 