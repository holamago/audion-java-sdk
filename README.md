<div align="center">
  <!-- <img src="https://audion.magovoice.com/static/media/logo.10d2cf1b78c4088112afa09c702c5c2d.svg" width="200">
  <h1>Audion Java SDK</h1> -->

  <p>
    <strong>음성 AI 구현의 복잡함을 없애고, 비즈니스 가능성을 확장하세요.</strong>
  </p>

  <p>
    <a href="https://github.com/magovoice/audion-java-sdk/blob/main/LICENSE"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" alt="License"></a>
    <a href="https://java.com"><img src="https://img.shields.io/badge/java-11+-blue.svg" alt="Java version"></a>
  </p>
</div>

# Audion Java SDK

## 🌟 특징

- **간편한 음성 AI 통합**: 몇 줄의 코드로 강력한 음성 AI 기능을 Java 애플리케이션에 추가
- **다양한 입력 지원**: 로컬 파일 및 URL을 통한 음성/비디오 처리
- **광범위한 파일 형식**: 주요 오디오 및 비디오 형식 지원
- **유연한 Flow 시스템**: 다양한 음성 AI 워크플로우 지원
- **간단한 API**: 직관적이고 사용하기 쉬운 Java 인터페이스
- **Maven 지원**: Maven을 통한 쉬운 의존성 관리

## 📋 요구사항

- Java 11+
- Maven 3.6+
- API 키 ([Audion 서비스 등록](https://audion.magovoice.com/signup) 필요)
  - 회원가입 후 API Key 발급 받아야 합니다.

## 🚀 설치

### Maven

```xml
<dependency>
    <groupId>com.magovoice</groupId>
    <artifactId>audion</artifactId>
    <version>0.1.5</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.magovoice:audion:0.1.5'
```

### 소스에서 빌드

```bash
git clone https://github.com/holamago/audion-java-sdk.git
cd audion-java-sdk
mvn clean install
```

## ⚡ 빠른 시작

### 1. 클라이언트 초기화

```java
import com.magovoice.audion.AudionClient;

// API 키로 클라이언트 초기화
AudionClient client = new AudionClient("your-api-key-here");
```

### 2. 로컬 파일 처리 (파일 경로)

```java
// 로컬 오디오/비디오 파일 경로를 지정하여 처리
FlowResponse result = client.flow(
    "audion_vu",
    "file",
    "path/to/your/audio.wav"
);
System.out.println(result);
```

### 3. 파일 업로드 (InputStream)

디스크에 파일을 저장하지 않고 `InputStream`으로 직접 업로드할 수 있습니다.
Spring Web의 `MultipartFile`, 메모리 내 바이트 배열, 네트워크 스트림 등 다양한 소스에 활용됩니다.

```java
import com.magovoice.audion.AudionClient;
import com.magovoice.audion.model.FlowResponse;
import java.io.*;
import java.nio.file.*;

// --- 예시 1: 파일에서 InputStream 생성 ---
File file = new File("path/to/your/audio.wav");
try (InputStream stream = new FileInputStream(file)) {
    FlowResponse result = client.flow("audion_vu", stream, file.getName(), file.length());
    System.out.println(result);
}

// --- 예시 2: 파일 크기를 모를 때 (chunked transfer) ---
try (InputStream stream = new FileInputStream("path/to/your/audio.wav")) {
    FlowResponse result = client.flow("audion_vu", stream, "audio.wav");
    System.out.println(result);
}

// --- 예시 3: 바이트 배열에서 업로드 ---
byte[] audioBytes = Files.readAllBytes(Paths.get("path/to/your/audio.wav"));
try (InputStream stream = new ByteArrayInputStream(audioBytes)) {
    FlowResponse result = client.flow("audion_vu", stream, "audio.wav", audioBytes.length);
    System.out.println(result);
}

// --- 예시 4: Spring Boot에서 MultipartFile 활용 ---
// @PostMapping("/upload")
// public String upload(@RequestParam MultipartFile file) throws IOException {
//     FlowResponse result = client.flow(
//         "audion_vu",
//         file.getInputStream(),
//         file.getOriginalFilename(),
//         file.getSize()
//     );
//     return result.toString();
// }
```

> **참고**: `contentLength`를 전달하면 서버가 정확한 크기를 미리 알 수 있어 효율적입니다.
> 크기를 모를 경우 `contentLength` 없이 호출하면 chunked transfer encoding이 사용됩니다.

### 4. URL 처리

```java
// YouTube URL 처리
FlowResponse result = client.flow(
    "audion_vu",
    "url",
    "https://youtu.be/your-video-id"
);
System.out.println(result);
```

### 5. 자막 다운로드 (SRT / VTT)

`download` 메서드는 flow 실행(audion_vu)과 자막 다운로드를 한 번에 처리합니다.

```java
import com.magovoice.audion.model.DownloadFormat;
import java.nio.file.*;
import java.util.Map;

// SRT만 다운로드 (경로 생략 → 현재 디렉토리에 {documentId}.srt로 저장)
Path srtPath = client.download("url", "https://youtu.be/your-video-id", DownloadFormat.SRT);

// VTT만 다운로드 (파일 경로 직접 지정)
Path vttPath = client.download(
    "url", "https://youtu.be/your-video-id",
    DownloadFormat.VTT, Paths.get("/home/user/output.vtt")
);

// 디렉토리를 지정하면 {documentId}.srt 형태로 자동 파일명 생성
Path auto = client.download(
    "url", "https://youtu.be/your-video-id",
    DownloadFormat.SRT, Paths.get("/home/user/downloads/")
);

// SRT + VTT 모두 다운로드 (포맷 생략 시 전체)
Map<DownloadFormat, Path> paths = client.download(
    "url", "https://youtu.be/your-video-id",
    Paths.get("/home/user/downloads/")
);
paths.forEach((format, path) -> System.out.println(format.getValue() + " → " + path));
```

## 📖 API 문서

### AudionClient

Audion 서비스의 메인 클라이언트 클래스입니다.

#### 생성자

```java
// 기본 생성자
AudionClient(String apiKey)

// 커스텀 URL과 함께
AudionClient(String apiKey, String baseUrl)

// 모든 옵션과 함께
AudionClient(String apiKey, String baseUrl, Integer timeout)
```

**매개변수:**

- `apiKey` (String, 필수): Audion 서비스 인증을 위한 API 키
- `baseUrl` (String, 선택): 서버의 기본 URL. 기본값은 프로덕션 서버
- `timeout` (Integer, 선택): HTTP 요청 타임아웃(초). 기본값은 300초

**예외:**

- `IllegalArgumentException`: apiKey가 제공되지 않은 경우

#### 메서드

##### `flow(flow, inputType, input)`

지정된 플로우로 음성/비디오 처리를 실행합니다.

```java
FlowResponse flow(String flow, String inputType, String input) throws IOException
```

**매개변수:**

- `flow` (String): 실행할 플로우의 이름
  - 현재 지원하는 플로우:
    - `audion_vu`: Voice Understanding
    - `audion_vh`: Voice Highlight
  - Custom Flow 지원 가능 (email:contact@holamago.com)
- `inputType` (String): 입력 타입. `"file"` 또는 `"url"`
- `input` (String): 처리할 파일의 경로 또는 URL

**반환값:**

- `FlowResponse`: 처리 결과를 포함하는 응답 객체

**예외:**

- `IllegalArgumentException`: 지원하지 않는 inputType인 경우
- `IOException`: API 호출 실패 시

##### `flow(flow, stream, filename, contentLength)`

InputStream을 사용하여 음성/비디오 처리를 실행합니다. 디스크에 파일을 저장하지 않고 바로 업로드할 수 있습니다.

```java
FlowResponse flow(String flow, InputStream stream, String filename, long contentLength) throws IOException
```

**매개변수:**

- `flow` (String): 실행할 플로우의 이름
- `stream` (InputStream): 업로드할 파일의 입력 스트림
- `filename` (String): 확장자를 포함한 원본 파일명 (예: `"audio.mp3"`)
- `contentLength` (long): 스트림의 바이트 크기. `-1`이면 chunked transfer 사용

**반환값:**

- `FlowResponse`: 처리 결과를 포함하는 응답 객체

**예외:**

- `IOException`: API 호출 실패 시

##### `flow(flow, stream, filename)`

contentLength를 생략하는 간편 오버로드입니다. chunked transfer encoding이 사용됩니다.

```java
FlowResponse flow(String flow, InputStream stream, String filename) throws IOException
```

##### `download(inputType, input, format)`

audion_vu flow를 실행하고 자막 파일을 현재 디렉토리에 `{documentId}.{ext}`로 저장합니다.

```java
Path download(String inputType, String input, DownloadFormat format) throws IOException
```

**매개변수:**

- `inputType` (String): 입력 타입. `"file"` 또는 `"url"`
- `input` (String): 처리할 파일의 경로 또는 URL
- `format` (DownloadFormat): 다운로드할 포맷. `DownloadFormat.SRT` 또는 `DownloadFormat.VTT`

**반환값:**

- `Path`: 저장된 파일의 경로

**예외:**

- `IOException`: API 호출 또는 파일 저장 실패 시

##### `download(inputType, input, format, outputPath)`

audion_vu flow를 실행하고 자막 파일을 지정된 경로에 저장합니다. `outputPath`가 디렉토리이면 `{documentId}.{ext}`로 자동 파일명이 생성됩니다.

```java
Path download(String inputType, String input,
              DownloadFormat format, Path outputPath) throws IOException
```

**매개변수:**

- `inputType` (String): 입력 타입. `"file"` 또는 `"url"`
- `input` (String): 처리할 파일의 경로 또는 URL
- `format` (DownloadFormat): 다운로드할 포맷. `DownloadFormat.SRT` 또는 `DownloadFormat.VTT`
- `outputPath` (Path): 저장할 파일 경로 또는 디렉토리

**반환값:**

- `Path`: 저장된 파일의 경로

**예외:**

- `IOException`: API 호출 또는 파일 저장 실패 시

##### `download(inputType, input, outputDir)`

audion_vu flow를 실행하고 SRT와 VTT 자막 파일을 모두 다운로드합니다.

```java
Map<DownloadFormat, Path> download(String inputType, String input,
                                   Path outputDir) throws IOException
```

**매개변수:**

- `inputType` (String): 입력 타입. `"file"` 또는 `"url"`
- `input` (String): 처리할 파일의 경로 또는 URL
- `outputDir` (Path): 저장할 디렉토리 경로. `{documentId}.srt`, `{documentId}.vtt` 파일이 생성됨

**반환값:**

- `Map<DownloadFormat, Path>`: 포맷별 저장된 파일 경로

**예외:**

- `IOException`: API 호출 또는 파일 저장 실패 시

> InputStream 오버로드도 동일하게 제공됩니다: `download(stream, filename, contentLength, format)`, `download(stream, filename, contentLength, format, outputPath)`, `download(stream, filename, contentLength, outputDir)`

##### `getFlows()`

사용 가능한 플로우 목록을 가져옵니다.

```java
Object getFlows() throws IOException
```

## 🎵 지원 파일 형식

### 오디오 형식

- `.wav` - WAV (Waveform Audio File Format)
- `.mp3` - MP3 (MPEG-1 Audio Layer III)
- `.m4a` - M4A (MPEG-4 Audio)
- `.ogg` - OGG (Ogg Vorbis)
- `.flac` - FLAC (Free Lossless Audio Codec)
- `.aac` - AAC (Advanced Audio Coding)
- `.wma` - WMA (Windows Media Audio)
- `.m4b`, `.m4p`, `.m4r`, `.m4v` - 기타 MPEG-4 오디오 형식

### 비디오 형식

- `.mp4` - MP4 (MPEG-4 Part 14)
- `.mov` - MOV (QuickTime File Format)
- `.avi` - AVI (Audio Video Interleave)
- `.mkv` - MKV (Matroska Video)
- `.webm` - WebM
- `.wmv` - WMV (Windows Media Video)
- `.flv` - FLV (Flash Video)
- `.mpeg`, `.mpg` - MPEG (Moving Picture Experts Group)

## 💡 사용 예제

### 완전한 예제: 자막 다운로드

```java
import com.magovoice.audion.AudionClient;
import com.magovoice.audion.model.DownloadFormat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AudionClient client = new AudionClient("your-api-key-here");

        try {
            // SRT 자막 다운로드 (현재 디렉토리에 {documentId}.srt로 저장)
            Path srtPath = client.download("file", "samples/audio.wav", DownloadFormat.SRT);
            System.out.println("SRT 저장 완료: " + srtPath);

            // 경로를 지정하여 VTT 자막 다운로드
            Path vttPath = client.download(
                "file", "samples/audio.wav",
                DownloadFormat.VTT, Paths.get("/home/user/output.vtt")
            );
            System.out.println("VTT 저장 완료: " + vttPath);

            // SRT + VTT 모두 다운로드 (디렉토리 지정)
            Map<DownloadFormat, Path> paths = client.download(
                "file", "samples/audio.wav",
                Paths.get("output")
            );
            paths.forEach((fmt, path) ->
                System.out.println(fmt.getValue() + " 저장 완료: " + path)
            );

        } catch (IllegalArgumentException e) {
            System.err.println("입력 오류: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("처리 오류: " + e.getMessage());
        }
    }
}
```

### 완전한 예제: InputStream 업로드 + 자막 다운로드 (Spring Boot)

```java
import com.magovoice.audion.AudionClient;
import com.magovoice.audion.model.DownloadFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class AudioController {

    private final AudionClient client = new AudionClient("your-api-key-here");

    @PostMapping("/transcribe")
    public String transcribe(@RequestParam MultipartFile file) throws IOException {
        // 경로 생략 → 현재 디렉토리에 {documentId}.srt로 저장
        Path srtPath = client.download(
            file.getInputStream(),
            file.getOriginalFilename(),
            file.getSize(),
            DownloadFormat.SRT
        );

        return "SRT 저장 완료: " + srtPath;
    }
}
```

### 예외 처리

```java
try {
    FlowResponse result = client.flow("audion_vu", "url", "https://example.com/video.mp4");
    System.out.println("성공: " + result);
} catch (IllegalArgumentException e) {
    // 잘못된 입력 타입이나 파일 형식
    System.err.println("입력 오류: " + e.getMessage());
} catch (IOException e) {
    // 네트워크 오류나 API 오류
    System.err.println("API 오류: " + e.getMessage());
}
```

## 🧪 예제 테스트하기

### Java 명령어 직접 실행

```bash
# SDK 빌드 및 설치
mvn clean install

# 의존성 JAR 파일들 복사
mvn dependency:copy-dependencies

# 예제 실행
java -cp "target/audion-java-sdk-0.1.0.jar:target/dependency/*" com.magovoice.audion.Example
```

## 🧪 테스트

테스트를 실행하려면:

```bash
mvn test
```

## 📄 라이선스

이 프로젝트는 [Apache License 2.0](LICENSE) 하에 라이선스됩니다.

## 📞 지원

- **문서**: [Audion 공식 문서](https://audion.magovoice.com)
- **이슈**: [GitHub Issues](https://github.com/holamago/audion-java-sdk/issues)
- **이메일**: contact@holamago.com

## 📈 버전 히스토리

- **v0.1.4**: 자막 다운로드 및 InputStream 지원
  - `download()` 메서드 추가 (SRT/VTT 자막 파일 다운로드)
  - `DownloadFormat` enum 추가
  - `flow()` InputStream 오버로드 추가 (디스크 I/O 없는 파일 업로드)
- **v0.1.0**: 초기 릴리스
  - 기본 flow API 지원
  - 파일 및 URL 입력 지원
  - 다중 오디오/비디오 형식 지원
  - Maven 프로젝트 구조
  - JUnit 테스트 포함

<div align="center">
  <p>Made with ❤️ by <a href="https://magovoice.com">MAGO</a></p>
</div>
