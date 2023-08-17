package org.rbernalop.springawspolly.speech.application;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rbernalop.springawspolly.speech.domain.port.AudioManager;
import org.rbernalop.springawspolly.speech.domain.port.FileStorage;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
@AllArgsConstructor
public class SpeechGenerator {
    private final AudioManager audioManager;
    private final FileStorage fileStorage;

    public void generate(String text) {
        log.info("Generating speech for text");
        InputStream audio = audioManager.generate(text);
        fileStorage.saveInputStream(audio);
    }
}
