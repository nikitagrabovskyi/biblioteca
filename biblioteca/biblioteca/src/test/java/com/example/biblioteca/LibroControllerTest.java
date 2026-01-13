package com.example.biblioteca;


import com.example.biblioteca.controller.LibroController;
import com.example.biblioteca.entity.Libro;
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
class LibroControllerTest {

    @Mock
    private LibroServicelmpl libroServicelmpl;

    @InjectMocks
    private LibroController libroController;

    @Test
    void obtenerTodos_devuelveListaDeLibros() {
        Libro libro1 = new Libro(1L, "Titulo 1", "Autor 1");
        Libro libro2 = new Libro(2L, "Titulo 2", "Autor 2");
        List<Libro> librosEsperados = Arrays.asList(libro1, libro2);

        Mockito.when(libroServicelmpl.getLibros()).thenReturn(librosEsperados);

        List<Libro> resultado = libroController.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(librosEsperados, resultado);
        Mockito.verify(libroServicelmpl, Mockito.times(1)).getLibros();
    }

    @Test
    void getLibro_devuelveLibroCuandoExiste() {
        Long id = 1L;
        Libro libro = new Libro(id, "Titulo 1", "Autor 1");
        Mockito.when(libroServicelmpl.getLibro(id)).thenReturn(Optional.of(libro));

        Optional<Libro> resultado = libroController.getLibro(id);

        assertTrue(resultado.isPresent());
        assertEquals(libro, resultado.get());
        Mockito.verify(libroServicelmpl, Mockito.times(1)).getLibro(id);
    }

    @Test
    void getLibro_devuelveOptionalVacioCuandoNoExiste() {
        Long id = 99L;
        Mockito.when(libroServicelmpl.getLibro(id)).thenReturn(Optional.empty());

        Optional<Libro> resultado = libroController.getLibro(id);

        assertFalse(resultado.isPresent());
        Mockito.verify(libroServicelmpl, Mockito.times(1)).getLibro(id);
    }

    @Test
    void guardarOActualizarLibro_llamaAlServicio() {
        Libro libro = new Libro(1L, "Titulo 1", "Autor 1");

        libroController.guardarOActualizarLibro(libro);

        Mockito.verify(libroServicelmpl, Mockito.times(1)).guardarOActualizarLibro(libro);
    }

    @Test
    void eliminarLibro_llamaAlServicio() {
        Long id = 1L;

        libroController.eliminarLibro(id);

        Mockito.verify(libroServicelmpl, Mockito.times(1)).eliminarLibro(id);
    }
}


