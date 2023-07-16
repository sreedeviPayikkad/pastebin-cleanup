package com.example.pastebincleanupservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cleanup")
public class CleanupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CleanupController.class);
    @GetMapping
    public ResponseEntity<Object> getExpiredKeys() {
        return ResponseEntity.status(200).body("responseData");
    }

    @DeleteMapping ResponseEntity<Object> deleteExpiredKeys() {
        return ResponseEntity.status(200).body("responseData");
    }

    @DeleteMapping ResponseEntity<Object> deletePasteForExpiredKeys() {
        return ResponseEntity.status(200).body("responseData");
    }
}
