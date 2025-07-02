package org.example;

import java.io.UnsupportedEncodingException;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import java.util.List;

@RestController
@SpringBootApplication
public class MyApplication {

    @RequestMapping("/ping")
    public ResponseEntity<String> home(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException
    {
        // Get the headers from the HttpEntity
        HttpHeaders headers = requestEntity.getHeaders();

        // Iterate through the headers and print them
        headers.forEach((headerName, headerValues) -> {
            System.out.println(headerName + ": " + String.join(",", headerValues)); // Print each header and its values
        });

        ResponseEntity<String> responseEntity = ResponseEntity.ok("Hello World");

        System.out.println("Printing headers from ResponseEntity:");
        printResponseEntityHeaders(responseEntity);
        return responseEntity;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    public static void printResponseEntityHeaders(ResponseEntity<?> responseEntity) {
        HttpHeaders headers = responseEntity.getHeaders();

        // Iterate through the headers and print them
        for (MultiValueMap.Entry<String, List<String>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            String headerValue = String.join(", ", entry.getValue()); // Join multiple values if present
            System.out.println(headerName + ": " + headerValue);
        }
    }
}