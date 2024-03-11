package com.opensql.opensql.controller;

import com.opensql.opensql.dto.GptSqlerRequest;
import com.opensql.opensql.dto.GptSqlerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BotController {
    @Value("${openai.model}")
    private String modelString;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt, Model model) {
        GptSqlerRequest request = new GptSqlerRequest(modelString, prompt);
        GptSqlerResponse gptSqlerResponse = template.postForObject(apiURL, request, GptSqlerResponse.class);

       String sqlQuery = gptSqlerResponse.getChoices().get(0).getMessage().getContent();
        model.addAttribute("sqlQuery", sqlQuery);
        return "home";
    }
}
