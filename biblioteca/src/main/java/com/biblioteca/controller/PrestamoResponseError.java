package com.biblioteca.controller;

public class PrestamoResponseError {

    private String mensaje;

    public PrestamoResponseError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
