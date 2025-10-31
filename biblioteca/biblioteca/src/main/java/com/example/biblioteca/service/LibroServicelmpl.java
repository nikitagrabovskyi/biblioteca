package com.example.biblioteca.service;

import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LibroServicelmpl implements LIbroService.LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro>getLibro(Long id) { return 
        libroRepository.findById(id);
    }

    @Override
    public void guardarOActualizarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
