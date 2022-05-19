package com.example.helloworld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public ResponseEntity<JsonNode> sendGreetings() throws JsonMappingException, JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String response = restTemplate.getForObject(
                "https://raw.githubusercontent.com/KoenomatachiSan/anao-denovo-nao/main/presentation.json",
                String.class);
        // JSONObject jsonObject = new JSONObject(response);
        // System.out.println(jsonObject.getString("title"));

        JsonNode json = mapper.readTree(response);
        return ResponseEntity.ok(json);
    }
}
