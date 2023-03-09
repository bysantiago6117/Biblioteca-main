package com.biblioteca.Repositorio;


import com.biblioteca.modelo.Prestamo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PrestamoRepositorio extends JpaRepository< Prestamo, Long>{

}
