package br.com.johnlaff.chatbot.application.controllers;

import br.com.johnlaff.chatbot.domain.services.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public String conversation(@RequestParam String message, @RequestParam(defaultValue = "") String prompt){
        return chatService.sendMessage(message, prompt);
    }

}
