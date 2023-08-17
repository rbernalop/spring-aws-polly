# Text to Speech with AWS Polly and Spring Boot

This project utilizes the AWS Polly service to convert text into audio. It integrates seamlessly with Spring Boot, providing two API endpoints that allow you to generate and play audio from text using HTTP calls.

## Setup ⚙️

Before running the project, ensure you have the following environment variables set in your development environment:

- `AWS_ACCESS_KEY`: Your AWS access key for authentication.
- `AWS_SECRET_KEY`: Your AWS secret key for authentication.
- `AWS_REGION`: The AWS Region where the Polly service is located.

## How to Use the Project 📚

1. Clone the project repository from GitHub: [Repository Link](https://github.com/rbernalop/spring-aws-polly).
2. Set the aforementioned environment variables on your system.
3. Open a terminal and navigate to the project directory.
4. Run the project using the `mvnw spring-boot:run` command.

## Generate Text-to-Speech Audio 🎤

To generate audio from text, use the following curl request:

```bash
curl --location 'http://localhost:8080/api/v1/speech' \
--header 'Content-Type: application/json' \
--data '{
    "text": "Sample text"
}'
```

Replace "Sample text" with the text you want to convert into audio. The generated audio file will be named "speech.mp3."

## Play Text-to-Speech Audio 🔊

To play the generated audio, use the following curl request:

```bash
curl --location 'http://localhost:8080/api/v1/speech/play' \
--header 'Content-Type: application/json' \
--data '{
    "text": "Sample text"
}'
```

Replace "Sample text" with the text you want to play as audio. The audio will be streamed and played.

## Project Workflow 📝

1. An HTTP request is received to generate audio from text at the /api/v1/speech endpoint.
2. The provided text is sent to the AWS Polly service using the specified AWS credentials and Region.
3. AWS Polly processes the text and generates an audio file (speech.mp3).
4. The generated audio file is returned as an HTTP response to the client.
