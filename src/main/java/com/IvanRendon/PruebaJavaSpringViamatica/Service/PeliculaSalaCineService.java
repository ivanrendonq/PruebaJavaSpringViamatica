/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Service;

import com.IvanRendon.PruebaJavaSpringViamatica.Model.Pelicula;
import com.IvanRendon.PruebaJavaSpringViamatica.Model.PeliculasEnFecha;
import com.IvanRendon.PruebaJavaSpringViamatica.Repository.PeliculaSalaCineRepository;
import java.util.Date;

import java.util.List;
import lombok.Builder;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@Builder
public class PeliculaSalaCineService {
    
    private final PeliculaSalaCineRepository peliculaSalaCineRepository;
    
    
    public PeliculasEnFecha getPeliculasEnFecha(Date fecha_publicacion)
    {
        List<Pelicula> peliculas =  peliculaSalaCineRepository.getPeliculaEnFecha(fecha_publicacion);
        
        PeliculasEnFecha peliculasEnFecha = new PeliculasEnFecha(peliculas);
        
        return peliculasEnFecha;
    }
    
    public int getCantidadPeliculasEnSalaCine (int id_sala_cine)
    {
        return peliculaSalaCineRepository.getCantidadDeSalaCine(id_sala_cine);
    }
    
}
