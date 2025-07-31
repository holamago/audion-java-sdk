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

### Maven을 사용한 설치

`pom.xml`에 다음 의존성을 추가하세요:

```xml
<dependency>
    <groupId>com.magovoice</groupId>
    <artifactId>audion-java-sdk</artifactId>
    <version>0.1.0</version>
</dependency>
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

### 2. 로컬 파일 처리

```java
// 로컬 오디오/비디오 파일 처리
Object result = client.flow(
    "audion_vu",
    "file",
    "path/to/your/audio.wav"
);
System.out.println(result);
```

### 3. URL 처리

```java
// YouTube URL 처리
Object result = client.flow(
    "audion_vu",
    "url",
    "https://youtu.be/your-video-id"
);
System.out.println(result);
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
Object flow(String flow, String inputType, String input) throws IOException
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

- `Object`: 처리 결과를 포함하는 JSON 응답

**예외:**

- `IllegalArgumentException`: 지원하지 않는 inputType인 경우
- `IOException`: API 호출 실패 시

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

### 완전한 예제

```java
import com.magovoice.audion.AudionClient;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 클라이언트 초기화
        AudionClient client = new AudionClient("your-api-key-here");

        try {
            // 로컬 파일 처리
            Object result = client.flow(
                "audion_vu",
                "file",
                "samples/audio.wav"
            );

            System.out.println("처리 결과: " + result);

        } catch (IllegalArgumentException e) {
            System.err.println("입력 오류: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("처리 오류: " + e.getMessage());
        }
    }
}
```

### 예외 처리

```java
try {
    Object result = client.flow("audion_vu", "url", "https://example.com/video.mp4");
    System.out.println("성공: " + result);
} catch (IllegalArgumentException e) {
    // 잘못된 입력 타입이나 파일 형식
    System.err.println("입력 오류: " + e.getMessage());
} catch (IOException e) {
    // 네트워크 오류나 API 오류
    System.err.println("API 오류: " + e.getMessage());
}
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

- **v0.1.0**: 초기 릴리스
  - 기본 flow API 지원
  - 파일 및 URL 입력 지원
  - 다중 오디오/비디오 형식 지원
  - Maven 프로젝트 구조
  - JUnit 테스트 포함

<div align="center">
  <p>Made with ❤️ by <a href="https://magovoice.com">MAGO</a></p>
</div>
