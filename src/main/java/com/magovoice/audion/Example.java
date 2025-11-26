package com.magovoice.audion;

import com.magovoice.audion.model.FlowResponse;

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
        AudionClient client = new AudionClient("mk-key-value");
        
        try {
            // Process a YouTube URL
            FlowResponse result = client.flow(
                "audion_vh",
                "url",
                "https://www.youtube.com/url-example"
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