package com.biblioteca.servicios;

import com.biblioteca.modelo.Prestamo;

import java.util.Optional;

public interface IPrestamo {
    Optional<Prestamo> CrearPrestamo(Prestamo pr);
    Prestamo Prestamobyid(Long id);
    boolean Comprobar(Prestamo pr);
}
