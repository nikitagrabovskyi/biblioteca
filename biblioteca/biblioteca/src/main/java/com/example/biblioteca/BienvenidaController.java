package com.example.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class BienvenidaController {

    @GetMapping
    public String Bienvenida() {
        return "Bienvenido al IES Monte";
    }
}
