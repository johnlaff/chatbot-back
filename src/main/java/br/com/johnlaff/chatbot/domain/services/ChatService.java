package br.com.johnlaff.chatbot.domain.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        InMemoryChatMemory memory = new InMemoryChatMemory();
        this.chatClient = builder
                .defaultAdvisors(new MessageChatMemoryAdvisor(memory),
                        new SimpleLoggerAdvisor())
                .build();
    }

    public String sendMessage(String message, String prompt) {
        return chatClient.prompt()
                .system(prompt)
                .user(message)
                .call()
                .content();
    }

}
