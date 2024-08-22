package com.aub.e_shop.service;

import java.io.IOException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aub.e_shop.model.TransferModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    private final OkHttpClient client = new OkHttpClient();
    private final String API_BASE_URL = "http://localhost:8443/aub";

    // Basic Authentication credentials
    private final String username = "sa";
    private final String password = "123456";

    public String processPayment(TransferModel transfer) throws IOException {
        String url = API_BASE_URL + "/transfer";

        // Convert products list to JSON
        String jsonProducts = convertProductsToJson(transfer);

        RequestBody body = RequestBody.create(
            jsonProducts,
            MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
            .url(url)
            .addHeader("Authorization", getBasicAuthHeader())
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    private String convertProductsToJson(Object transfer) {
        // Use a library like Jackson or Gson to convert the list to JSON
        // Example using Jackson:
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(transfer);
        } catch (JsonProcessingException e) {
           LOGGER.error("Exception has occured. ",e);
            return "[]";
        }
    }

    private String getBasicAuthHeader() {
        String credentials = username + ":" + password;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
        return basicAuth;
    }
}
