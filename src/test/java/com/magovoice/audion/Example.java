package com.magovoice.audion;

import com.magovoice.audion.model.DownloadFormat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Example usage of Audion Java SDK
 *
 * @author Sukbong Kwon (Galois)
 * @since 0.1.0
 */
public class Example {

    public static void main(String[] args) {
        AudionClient client = new AudionClient("your-api-key-here");
        
        try {
            // SRT만 다운로드
            Path srtPath = client.download(
                "file", "path/to/your/audio.wav",
                DownloadFormat.SRT, Paths.get("output.srt")
            );
            System.out.println("SRT saved to: " + srtPath);

            // SRT + VTT 모두 다운로드
            Map<DownloadFormat, Path> paths = client.download(
                "file", "path/to/your/audio.wav",
                Paths.get("output")
            );
            paths.forEach((fmt, p) -> System.out.println(fmt.getValue() + " saved to: " + p));

        } catch (IOException e) {
            System.err.println("Error processing request: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 