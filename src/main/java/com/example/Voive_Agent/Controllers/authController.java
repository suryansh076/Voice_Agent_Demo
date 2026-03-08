package com.example.Voive_Agent.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {
    public Integer authkey;
    private final Object lock = new Object();

    @GetMapping
    public ResponseEntity<?> auth() throws InterruptedException {

        synchronized (lock) {

            if (authkey == null || authkey == 0) {
                lock.wait(15000); // wait max 15 sec
            }

            if (authkey != null && authkey != 0) {
                Integer temp= authkey;
                authkey = null; // reset authkey after use
                return ResponseEntity.status(200).body(temp);
            } else {
                return ResponseEntity.status(400).body(null);
            }
        }
    }
    @PostMapping("/setauthkey/{key}")
    public String setAuthKey(@PathVariable Integer key) {
        this.authkey = key;

        return "Auth key set to: " + authkey;
    }
}

