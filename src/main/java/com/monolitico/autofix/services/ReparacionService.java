package com.monolitico.autofix.services;

import com.monolitico.autofix.entities.ReparacionEntity;
import com.monolitico.autofix.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReparacionService {
    @Autowired
    ReparacionRepository reparacionRepository;

    public ArrayList<ReparacionEntity> obtenerReparaciones(){
        return (ArrayList<ReparacionEntity>) reparacionRepository.findAll();
    }

    public ReparacionEntity guardarReparacion(ReparacionEntity usuario){
        return reparacionRepository.save(usuario);
    }

    public void guardarReparacion(String Patente, String Tipo_reparacion, Integer Monto_total, Timestamp Fecha_ingreso,
                                  Timestamp Fecha_retiro, Timestamp Fecha_salida){
        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente(Patente);
        reparacion.setTipo_reparacion(Tipo_reparacion);
        reparacion.setMonto_total(Monto_total);
        reparacion.setFecha_ingreso(Fecha_ingreso);
        reparacion.setFecha_retiro(Fecha_retiro);
        reparacion.setFecha_salida(Fecha_salida);
        reparacionRepository.save(reparacion);
    }
    public Optional<ReparacionEntity> obtenerPorId(String id){
        return reparacionRepository.findById(id);
    }

    public boolean eliminarReparacion(String id) {
        try{
            reparacionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}