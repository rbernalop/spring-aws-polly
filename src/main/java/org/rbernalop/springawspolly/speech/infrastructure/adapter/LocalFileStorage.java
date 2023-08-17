package org.rbernalop.springawspolly.speech.infrastructure.adapter;

import org.rbernalop.springawspolly.speech.domain.port.FileStorage;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class LocalFileStorage implements FileStorage {
    @Override
    public void saveInputStream(InputStream inputStream) {
        try {
            File file = new File("speech.mp3");
            OutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
