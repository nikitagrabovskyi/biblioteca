package com.example.biblioteca;


import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroServicelmpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LibroServicelmplTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServicelmpl libroServicelmpl;

    @Test
    void getLibros_devuelveListaDeLibros() {
        Libro libro1 = new Libro(1L, "Titulo 1", "Autor 1");
        Libro libro2 = new Libro(2L, "Titulo 2", "Autor 2");
        List<Libro> librosEsperados = Arrays.asList(libro1, libro2);

        Mockito.when(libroRepository.findAll()).thenReturn(librosEsperados);

        List<Libro> resultado = libroServicelmpl.getLibros();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(librosEsperados, resultado);
        Mockito.verify(libroRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getLibro_devuelveLibroCuandoExiste() {
        Long id = 1L;
        Libro libroEsperado = new Libro(id, "Titulo 1", "Autor 1");
        Mockito.when(libroRepository.findById(id)).thenReturn(Optional.of(libroEsperado));

        Optional<Libro> resultado = libroServicelmpl.getLibro(id);

        assertTrue(resultado.isPresent());
        assertEquals(libroEsperado, resultado.get());
        Mockito.verify(libroRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void getLibro_devuelveOptionalVacioCuandoNoExiste() {
        Long id = 99L;
        Mockito.when(libroRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Libro> resultado = libroServicelmpl.getLibro(id);

        assertFalse(resultado.isPresent());
        Mockito.verify(libroRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void guardarOActualizarLibro_llamaAlRepositorioSave() {
        Libro libro = new Libro(1L, "Titulo 1", "Autor 1");

        libroServicelmpl.guardarOActualizarLibro(libro);

        Mockito.verify(libroRepository, Mockito.times(1)).save(libro);
    }

    @Test
    void eliminarLibro_llamaAlRepositorioDeleteById() {
        Long id = 1L;

        libroServicelmpl.eliminarLibro(id);

        Mockito.verify(libroRepository, Mockito.times(1)).deleteById(id);
    }
}
