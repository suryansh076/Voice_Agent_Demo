package com.example.Voive_Agent.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {
    public Integer authkey;
    private final Object lock = new Object();

    @GetMapping
    public String auth() throws InterruptedException {

        synchronized (lock) {

            if (authkey == null || authkey == 0) {
                lock.wait(15000); // wait max 15 sec
            }

            if (authkey != null && authkey != 0) {
                Integer temp= authkey;
                authkey = null; // reset authkey after use
                return "Key: " + temp;
            } else {
                return "Auth key not set within 15 seconds";
            }
        }
    }
    @PostMapping("/setauthkey/{key}")
    public String setAuthKey(@PathVariable Integer key) {
        this.authkey = key;

        return "Auth key set to: " + authkey;
    }
}

