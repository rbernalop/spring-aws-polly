package org.rbernalop.springawspolly.speech.domain.port;

import java.io.InputStream;

public interface FileStorage {
    void saveInputStream(InputStream inputStream);
}
