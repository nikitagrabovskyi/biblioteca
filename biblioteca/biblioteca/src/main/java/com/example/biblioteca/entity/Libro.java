package com.example.biblioteca.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name ="libro")
    public class Libro {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Se generará automáticamente el id;
        private Long id;

        @Column(nullable = false) //Al ponerlo a posteriori, hay que modificar la base de datos;
        private String titulo;

        private String autor;
    }

