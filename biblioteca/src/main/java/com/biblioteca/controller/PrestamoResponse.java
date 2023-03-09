package com.biblioteca.controller;

import com.biblioteca.modelo.Prestamo;

import java.time.format.DateTimeFormatter;


public class PrestamoResponse {

    private static final DateTimeFormatter FORMATER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private long id;
    private String isbn;
    private String IdentificacionUsuario;
    private String fechaMaximaDevolucion;
    private int tipoUsuario;

    public PrestamoResponse(long id, String isbn, String identificacionUsuario, String fechaMaximaDevolucion, int tipoUsuario) {
        this.id = id;
        this.isbn = isbn;
        IdentificacionUsuario = identificacionUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
        this.tipoUsuario = tipoUsuario;
    }

    public static PrestamoResponse buildPrestamoResponse(Prestamo prestamo) {
        String dateFormater =  prestamo.getFechaMaximaDevolucion().format(FORMATER);
        return new PrestamoResponse(
                prestamo.getId().longValue(),
                prestamo.getIsbn(),
                prestamo.getIdentificacionUsuario(),
                dateFormater,
                //prestamo.getFechaMaximaDevolucion(),
                prestamo.getTipoUsuario());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return IdentificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        IdentificacionUsuario = identificacionUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }



}
