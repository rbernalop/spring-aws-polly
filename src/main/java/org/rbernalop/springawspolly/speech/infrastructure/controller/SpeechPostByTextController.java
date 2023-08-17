package org.rbernalop.springawspolly.speech.infrastructure.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rbernalop.springawspolly.speech.application.SpeechGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/speech")
@AllArgsConstructor
public class SpeechPostByTextController {
    private final SpeechGenerator speechGenerator;

    @PostMapping
    public void handle(@RequestBody SpeechPostByTextRequest request) {
        speechGenerator.generate(request.getText());
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
class SpeechPostByTextRequest {
    private String text;
}
