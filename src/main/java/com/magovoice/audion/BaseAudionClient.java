package com.magovoice.audion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magovoice.audion.config.AudionConfig;
import com.magovoice.audion.core.Logger;
import com.magovoice.audion.helper.Utils;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Base class for all Audion clients
 * 
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public abstract class BaseAudionClient {
    
    private static final org.slf4j.Logger logger = Logger.getLogger(BaseAudionClient.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    protected final String apiKey;
    protected final String baseUrl;
    protected final int timeout;
    protected final OkHttpClient httpClient;
    
    /**
     * Constructor for BaseAudionClient
     * 
     * @param apiKey the API key for authentication
     * @param baseUrl the base URL of the server
     * @param timeout the timeout in seconds
     */
    protected BaseAudionClient(String apiKey, String baseUrl, Integer timeout) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl != null ? baseUrl : AudionConfig.PRODUCTION_URL;
        this.timeout = timeout != null ? timeout : AudionConfig.TIMEOUT;
        
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(this.timeout, TimeUnit.SECONDS)
                .readTimeout(this.timeout, TimeUnit.SECONDS)
                .writeTimeout(this.timeout, TimeUnit.SECONDS)
                .build();
                
        logger.info("Initialized Audion client with base URL: {}", this.baseUrl);
    }
    
    /**
     * Execute a flow with the given parameters
     * 
     * @param flow the flow to execute
     * @param inputType the type of input (file or url)
     * @param input the input data (file path or URL)
     * @return the response as a JSON object
     * @throws IOException if the request fails
     * @throws IllegalArgumentException if the input type is not supported
     */
    public Object flow(String flow, String inputType, String input) throws IOException {
        String url = baseUrl + "/flow";
        logger.info("Calling flow API: {}", url);
        
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + apiKey);
        
        RequestBody requestBody;
        
        if ("file".equals(inputType)) {
            logger.info("Uploading file: {}", input);
            String mediaType = Utils.getMediaType(input);
            logger.info("Media type: {}, File: {}", mediaType, input);
            
            File file = new File(input);
            if (!file.exists()) {
                throw new IllegalArgumentException("File does not exist: " + input);
            }
            
            MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("flow", flow)
                    .addFormDataPart("input_type", inputType)
                    .addFormDataPart("input", input)
                    .addFormDataPart("file", input, 
                            RequestBody.create(MediaType.parse(mediaType), file));
            
            requestBody = multipartBuilder.build();
            
        } else if ("url".equals(inputType)) {
            FormBody.Builder formBuilder = new FormBody.Builder()
                    .add("flow", flow)
                    .add("input_type", inputType)
                    .add("input", input);
            
            requestBody = formBuilder.build();
            
        } else {
            throw new IllegalArgumentException("Unsupported input type: " + inputType);
        }
        
        Request request = requestBuilder.post(requestBody).build();
        
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.error("API call failed with status: {}", response.code());
                // Save response for debugging
                if (response.body() != null) {
                    String responseBody = response.body().string();
                    logger.error("Response body: {}", responseBody);
                }
                throw new IOException("API call failed with status: " + response.code());
            }
            
            if (response.body() != null) {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, Object.class);
            }
            
            return null;
        } catch (Exception e) {
            logger.error("Failed to call the API: {}", e.getMessage(), e);
            throw e;
        }
    }
    
    /**
     * Get available flows from the server
     * 
     * @return the flows response
     * @throws IOException if the request fails
     */
    public Object getFlows() throws IOException {
        logger.info("Getting flows from the server");
        String url = baseUrl + "/flow";
        
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + apiKey)
                .get()
                .build();
        
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to get flows: " + response.code());
            }
            
            if (response.body() != null) {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, Object.class);
            }
            
            return null;
        }
    }
} 