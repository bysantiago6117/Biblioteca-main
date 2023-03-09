package com.biblioteca.modelo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table( name = "prestamo")
public class Prestamo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("identificador único del pedido de tipo Long")
    private Long id;

    @Column
    @ApiModelProperty("identificador único de un libro (campo alfanumérico de máximo 10 dígitos)")
    private String isbn;

    @Column
    @ApiModelProperty("número de la identificación del usuario (campo alfanumérico de maximo 10 digitos)")
    private String IdentificacionUsuario;

    @Column
    @ApiModelProperty("fecha maxima para la devolucion del libro depende del tipo de usuario")
    private LocalDate fechaMaximaDevolucion;

    @Column
    @ApiModelProperty("determina la relación que tiene el usuario con la biblioteca, puede ser: " +
            " 1. afiliado," +
            " 2. empleado de la biblioteca" +
            " 3. usuario invitado")
    private int tipoUsuario;


    public Prestamo(Long id,String isbn,String identificacionUsuario, int tipoUsuario, LocalDate fechaMaximaDevolucion) {
        this.id = id;
        this.isbn = isbn;
        this.IdentificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;

    }

    public Prestamo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
