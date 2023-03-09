package com.biblioteca.servicios;

import com.biblioteca.Repositorio.PrestamoRepositorio;
import com.biblioteca.modelo.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServiciosPrestamo implements IPrestamo {


    @Autowired
    private PrestamoRepositorio pre;


    public ArrayList<Prestamo> prestamos = new ArrayList<>();


    @Override
    public Optional<Prestamo> CrearPrestamo(Prestamo pr) {

        pr.setFechaMaximaDevolucion(agregarlafecha(LocalDate.now(), pr.getTipoUsuario()));


        if (repetido(pr) && Comprobar(pr)) {
            prestamos.add(pr);
            return Optional.of(pre.save(pr));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Prestamo Prestamobyid(Long id) {
        return pre.findById(id).get();
    }

    public LocalDate agregarlafecha(LocalDate date, int tipousuario) {

        int days = 0;
        if (tipousuario == 1) {
            days = 10;
        }
        if (tipousuario == 2) {
            days = 8;
        }
        if (tipousuario == 3) {
            days = 7;
        }

        LocalDate result = date;
        int agregardias = 0;
        while (agregardias < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++agregardias;
            }
        }
        return result;
    }

    public boolean Comprobar(Prestamo pr) {
        if (pr.getTipoUsuario() == 3 || pr.getTipoUsuario() == 1 || pr.getTipoUsuario() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean repetido(Prestamo pr) {

        if(!prestamos.isEmpty()){
            for(int i = 0; i< prestamos.size(); i++){
                 Prestamo p = prestamos.get(i);
                if(p.getIdentificacionUsuario().equals(pr.getIdentificacionUsuario()) && pr.getTipoUsuario() == 3){
                    return false;
                }
            }
        }

        return true;
    }

}