package com.biblioteca.controller;


import com.biblioteca.modelo.Prestamo;
import com.biblioteca.servicios.IPrestamo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

    @Autowired
    private IPrestamo pr;

    @PostMapping
    @ApiOperation("permite crear un prestamo ")
    public ResponseEntity<?> Crear_prestamo(@ApiParam("Un objeto de tipo prestamo") @RequestBody Prestamo pre){
        PrestamoResponseError error = new PrestamoResponseError(String.format("El usuario con identificación %s ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",pre.getIdentificacionUsuario()));
        Optional<Prestamo> prestamo = pr.CrearPrestamo(pre);
        if (prestamo.isPresent()) {
            return new ResponseEntity<>(prestamo.get(), HttpStatus.OK);
        }
        else {
            if(!pr.Comprobar(pre)){
                return new ResponseEntity<>("{mensaje: 'Tipo de usuario no permitido en la biblioteca'}", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    @ApiOperation("permite buscar un prestamo por id")
    public ResponseEntity<?> BuscarPrestamo(@ApiParam("variable id corresponde al identificador del prestamo a encontrar")
                                                @PathVariable("id") Long id){
            Prestamo resourceById = pr.Prestamobyid(id);
            PrestamoResponse prestamoResponse = PrestamoResponse.buildPrestamoResponse(resourceById);
            return new ResponseEntity<>(prestamoResponse, HttpStatus.OK) ;
    }
}



