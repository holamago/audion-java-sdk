package com.magovoice.audion;

import com.magovoice.audion.model.DownloadFormat;
import com.magovoice.audion.model.FlowResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;

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
     * Execute a flow with an InputStream
     *
     * @param flow the flow to execute
     * @param stream the input stream of the file
     * @param filename the original filename including extension (e.g. "audio.mp3")
     * @param contentLength the size of the stream in bytes, or -1 if unknown (uses chunked transfer)
     * @return the flow response
     * @throws IOException if the request fails
     */
    public FlowResponse flow(String flow, InputStream stream, String filename, long contentLength) throws IOException {
        return super.flow(flow, stream, filename, contentLength);
    }

    /**
     * Execute a flow with an InputStream (contentLength unknown, uses chunked transfer)
     *
     * @param flow the flow to execute
     * @param stream the input stream of the file
     * @param filename the original filename including extension (e.g. "audio.mp3")
     * @return the flow response
     * @throws IOException if the request fails
     */
    public FlowResponse flow(String flow, InputStream stream, String filename) throws IOException {
        return super.flow(flow, stream, filename);
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

    /**
     * Execute audion_vu flow and download a subtitle file.
     * <p>
     * If {@code outputPath} points to an existing directory, the file is saved as
     * {@code {documentId}.{ext}} inside that directory. Otherwise it is written
     * directly to the given path.
     *
     * @param inputType  the type of input (file or url)
     * @param input      the input data (file path or URL)
     * @param format     the subtitle format to download ({@link DownloadFormat#SRT} or {@link DownloadFormat#VTT})
     * @param outputPath destination file path, or a directory for auto-naming
     * @return the path of the saved file
     * @throws IOException if the request fails
     */
    public Path download(String inputType, String input,
                         DownloadFormat format, Path outputPath) throws IOException {
        return super.download(inputType, input, format, outputPath);
    }

    /**
     * Execute audion_vu flow and download a subtitle file to the current directory.
     * The file is saved as {@code {documentId}.{ext}} in the current working directory.
     *
     * @param inputType the type of input (file or url)
     * @param input     the input data (file path or URL)
     * @param format    the subtitle format to download
     * @return the path of the saved file
     * @throws IOException if the request fails
     */
    public Path download(String inputType, String input, DownloadFormat format) throws IOException {
        return super.download(inputType, input, format);
    }

    /**
     * Execute audion_vu flow and download both SRT and VTT subtitle files.
     * <p>
     * Files are saved as {@code {documentId}.srt} and {@code {documentId}.vtt}
     * inside the specified directory.
     *
     * @param inputType the type of input (file or url)
     * @param input     the input data (file path or URL)
     * @param outputDir directory to save the files in
     * @return a map of {@link DownloadFormat} to saved file path
     * @throws IOException if the request fails
     */
    public Map<DownloadFormat, Path> download(String inputType, String input,
                                              Path outputDir) throws IOException {
        return super.download(inputType, input, outputDir);
    }

    /**
     * Execute audion_vu flow with InputStream and download a subtitle file.
     *
     * @param stream        the input stream of the file
     * @param filename      the original filename including extension
     * @param contentLength the size of the stream in bytes, or -1 if unknown
     * @param format        the subtitle format to download
     * @param outputPath    destination file path, or a directory for auto-naming
     * @return the path of the saved file
     * @throws IOException if the request fails
     */
    public Path download(InputStream stream, String filename, long contentLength,
                         DownloadFormat format, Path outputPath) throws IOException {
        return super.download(stream, filename, contentLength, format, outputPath);
    }

    /**
     * Execute audion_vu flow with InputStream and download a subtitle file to the current directory.
     *
     * @param stream        the input stream of the file
     * @param filename      the original filename including extension
     * @param contentLength the size of the stream in bytes, or -1 if unknown
     * @param format        the subtitle format to download
     * @return the path of the saved file
     * @throws IOException if the request fails
     */
    public Path download(InputStream stream, String filename, long contentLength,
                         DownloadFormat format) throws IOException {
        return super.download(stream, filename, contentLength, format);
    }

    /**
     * Execute audion_vu flow with InputStream and download both SRT and VTT.
     *
     * @param stream        the input stream of the file
     * @param filename      the original filename including extension
     * @param contentLength the size of the stream in bytes, or -1 if unknown
     * @param outputDir     directory to save the files in
     * @return a map of {@link DownloadFormat} to saved file path
     * @throws IOException if the request fails
     */
    public Map<DownloadFormat, Path> download(InputStream stream, String filename,
                                              long contentLength, Path outputDir) throws IOException {
        return super.download(stream, filename, contentLength, outputDir);
    }
} 