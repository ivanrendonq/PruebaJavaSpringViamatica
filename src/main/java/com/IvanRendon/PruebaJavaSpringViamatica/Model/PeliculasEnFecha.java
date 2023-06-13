/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author usuario
 */

@Getter
@Setter
public class PeliculasEnFecha {
    
    private List<Pelicula> peliculas;
    private int cantidadPeliculas;

    public PeliculasEnFecha(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
        cantidadPeliculas = peliculas.size();
    }
    
    
    
}
