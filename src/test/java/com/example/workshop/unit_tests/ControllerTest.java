package com.example.workshop.unit_tests;

import com.example.workshop.Exceptions.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;

import org.skyscreamer.jsonassert.JSONAssert;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

public class ControllerTest {
    @Test
    public void retrieveNonExistentCode() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage("INVALID_COUNTRY_CODE");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/B"))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        JSONAssert.assertEquals(errorMessage.toString(), response.body(), false);
        Assert.assertEquals(500, response.statusCode());
    }

    @Test
    public void checkDatabaseConnection() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/BHR"))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        ErrorMessage errorMessage = new ErrorMessage("INTERNAL_ERROR");
        JSONAssert.assertEquals(errorMessage.toString(), response.body(), false);
        Assert.assertEquals(500, response.statusCode());
    }


}
