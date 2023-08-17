package org.rbernalop.springawspolly.speech.infrastructure.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rbernalop.springawspolly.speech.application.SpeechPlayer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/speech/play")
@AllArgsConstructor
public class SpeechPostPlayByTextController {
    private final SpeechPlayer speechPlayer;

    @PostMapping
    public void handle(@RequestBody SpeechPostPlayTextRequest request) {
        speechPlayer.play(request.getText());
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
class SpeechPostPlayTextRequest {
    private String text;
}
