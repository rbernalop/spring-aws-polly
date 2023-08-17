package org.rbernalop.springawspolly.speech.application;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rbernalop.springawspolly.speech.domain.port.AudioManager;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SpeechPlayer {
    private final AudioManager audioManager;

    public void play(String text) {
        log.info("Playing speech for text");
        audioManager.play(text);
    }
}
