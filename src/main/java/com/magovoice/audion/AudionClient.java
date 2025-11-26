package com.magovoice.audion;

import com.magovoice.audion.model.FlowResponse;

import java.io.IOException;

/**
 * Main client class for Audion SDK
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public class AudionClient extends BaseAudionClient {
    
    /**
     * Constructor for AudionClient
     * 
     * @param apiKey the API key for authentication (required)
     * @param baseUrl the base URL of the server (optional)
     * @param timeout the timeout in seconds (optional)
     * @throws IllegalArgumentException if apiKey is null or empty
     */
    public AudionClient(String apiKey, String baseUrl, Integer timeout) {
        super(apiKey, baseUrl, timeout);
        
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("api_key is required");
        }
    }
    
    /**
     * Constructor for AudionClient with default settings
     * 
     * @param apiKey the API key for authentication (required)
     * @throws IllegalArgumentException if apiKey is null or empty
     */
    public AudionClient(String apiKey) {
        this(apiKey, null, null);
    }
    
    /**
     * Constructor for AudionClient with custom base URL
     * 
     * @param apiKey the API key for authentication (required)
     * @param baseUrl the base URL of the server
     * @throws IllegalArgumentException if apiKey is null or empty
     */
    public AudionClient(String apiKey, String baseUrl) {
        this(apiKey, baseUrl, null);
    }
    
    /**
     * Execute a flow with the given parameters
     *
     * @param flow the flow to execute
     * @param inputType the type of input (file or url)
     * @param input the input data (file path or URL)
     * @return the flow response
     * @throws IOException if the request fails
     * @throws IllegalArgumentException if the input type is not supported
     */
    public FlowResponse flow(String flow, String inputType, String input) throws IOException {
        return super.flow(flow, inputType, input);
    }
    
    /**
     * Get available flows from the server
     * 
     * @return the flows response
     * @throws IOException if the request fails
     */
    public Object getFlows() throws IOException {
        return super.getFlows();
    }
} 