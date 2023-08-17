package org.rbernalop.springawspolly.speech.domain.port;

import java.io.InputStream;

public interface AudioManager {
    InputStream generate(String text);

    void play(String text);
}
