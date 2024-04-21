package com.bitcamp.cadet.carbon.cadet.service;

import com.bitcamp.cadet.carbon.cadet.entities.CalculatorPojo;
import com.bitcamp.cadet.carbon.cadet.entities.Messages;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.*;
import com.theokanning.openai.service.FunctionExecutor;
import com.theokanning.openai.service.OpenAiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl {

    @Autowired
    Environment env;

    public String generateSuggestion(CalculatorPojo calcPojo) throws IOException, JSONException {

        String userInput = new ObjectMapper().writeValueAsString(calcPojo);
        String token = env.getProperty("OPENAI_TOKEN");

        String apiUrl = "https://api.openai.com/v1/chat/completions";
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        JSONObject systemPrompt = new JSONObject();
        systemPrompt.put("role", "system");
        systemPrompt.put("content", "You're an expert on tracking and managing carbon footprint and with respect to given parameters you've to suggest how to reduce carbon footprint");
        JSONObject userPrompt = new JSONObject();
        userPrompt.put("role", "user");
        userPrompt.put("content", userInput);
        JSONArray array = new JSONArray();
        array.put(systemPrompt);
        array.put(userPrompt);

        JSONObject request = new JSONObject();
        request.put("model", "gpt-3.5-turbo");
        request.put("max_tokens", 50);
        request.put("messages", array);
        request.put("temperature", 1.0);

        connection.setDoOutput(true);
        connection.getOutputStream().write(request.toString().getBytes());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.lines()
                .reduce((a, b) -> a + b)
                .get();

        JSONObject jsonObject = new JSONObject(response);

        // Extract message from choices array
        JSONArray choicesArray = jsonObject.getJSONArray("choices");
        if (choicesArray.length() > 0) {
            JSONObject firstChoice = choicesArray.getJSONObject(0);
            JSONObject message = firstChoice.getJSONObject("message");
            return message.getString("content");
        } else {
            System.out.println("No choices found in the JSON object.");
            return null;
        }
    }
}
