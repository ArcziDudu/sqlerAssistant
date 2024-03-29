package com.opensql.opensql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiConfig {
    @Value("${openai.api.key}")
    String openApiKey;

    @Bean
    public RestTemplate template() {
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openApiKey);
            request.getHeaders().add("OpenAI-Beta", "assistants=v1");
            return execution.execute(request, body);
        });
        return template;
    }
}
