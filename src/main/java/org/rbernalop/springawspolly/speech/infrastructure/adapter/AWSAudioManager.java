package org.rbernalop.springawspolly.speech.infrastructure.adapter;

import lombok.AllArgsConstructor;
import org.rbernalop.springawspolly.speech.infrastructure.AWSPollyManager;
import org.rbernalop.springawspolly.speech.domain.port.AudioManager;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@AllArgsConstructor
public class AWSAudioManager implements AudioManager {
    private final AWSPollyManager awsPollyManager;

    @Override
    public InputStream generate(String text) {
        return awsPollyManager.generate(text);
    }

    @Override
    public void play(String text) {
        awsPollyManager.play(text);
    }
}
