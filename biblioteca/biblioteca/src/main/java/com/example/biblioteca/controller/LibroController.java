package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Libro;

import com.example.biblioteca.service.LibroServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "/api")
public class LibroController {

    @Autowired
    private LibroServicelmpl libroServiceImpl;

    @GetMapping
    public List<Libro> obtenerTodos(){
        return this.libroServiceImpl.getLibros();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibro(@PathVariable Long id){
        return this.libroServiceImpl.getLibro(id);
    }

    @PostMapping
     public void guardarOActualizarLibro(@RequestBody Libro libro){
        this.libroServiceImpl.guardarOActualizarLibro(libro);
    }

    @DeleteMapping("/{libroId}")
     public void eliminarLibro(@PathVariable("libroId") Long libroId){
        this.libroServiceImpl.eliminarLibro(libroId);
    }
}


