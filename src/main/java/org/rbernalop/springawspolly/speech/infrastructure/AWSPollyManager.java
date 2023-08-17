package org.rbernalop.springawspolly.speech.infrastructure;

import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.*;
import org.rbernalop.springawspolly.speech.infrastructure.configuration.AWSConfig;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AWSPollyManager {

    private final AmazonPolly amazonPolly;

    public AWSPollyManager(AWSConfig awsConfig) {
        this.amazonPolly = AmazonPollyClientBuilder.standard().withCredentials(awsConfig.awsStaticCredentialsProvider())
            .withRegion(awsConfig.getRegion()).build();
    }

    public void play(String text) {
        InputStream speechStream = this.synthesize(text);
        AudioPlayer.play(speechStream);
    }

    public InputStream generate(String text) {
        return this.synthesize(text);
    }

    private InputStream synthesize(String text) {
        SynthesizeSpeechRequest synthReq = new SynthesizeSpeechRequest().withText(text)
            .withVoiceId(this.getVoice().getId()).withOutputFormat(OutputFormat.Mp3);

        SynthesizeSpeechResult synthRes = this.amazonPolly.synthesizeSpeech(synthReq);

        return synthRes.getAudioStream();
    }

    private Voice getVoice() {
        DescribeVoicesResult describeVoicesResult = this.amazonPolly.describeVoices(new DescribeVoicesRequest());
        return describeVoicesResult.getVoices().stream().filter(voice -> "Emma".equals(voice.getName())).findFirst()
                .orElse(null);
    }
}

