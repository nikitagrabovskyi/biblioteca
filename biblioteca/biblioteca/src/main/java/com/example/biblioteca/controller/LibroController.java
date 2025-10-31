package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.biblioteca.service.LibroServicelmpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class LibroController {

    @Autowired
    private LibroServicelmpl libroServiceImpl; // Se inyecta la dependencia

    @GetMapping
    public List<Libro> obtenerTodos() { return this.libroServiceImpl.getLibros(); }

    @GetMapping("/{id}")
    public Optional<Libro> getLibro(@PathVariable Long id) { return this.libroServiceImpl.getLibro(id); }

    @PostMapping
    public void guardarLibro(@RequestBody Libro libro) { this.libroServiceImpl.guardarOActualizarLibro(libro); }

    @DeleteMapping("{/libroid}")
    public void eliminarLibro(@PathVariable("id") Long libroId) { this.libroServiceImpl.eliminarLibro(libroId); }
}

