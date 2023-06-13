/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Controller;

/**
 *
 * @author usuario
 */


import com.IvanRendon.PruebaJavaSpringViamatica.Model.PeliculasEnFecha;
import com.IvanRendon.PruebaJavaSpringViamatica.Model.SalaCine;
import com.IvanRendon.PruebaJavaSpringViamatica.Service.PeliculaSalaCineService;
import com.IvanRendon.PruebaJavaSpringViamatica.Service.SalaCineService;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/peliculaSalaCine")
@CrossOrigin(origins = {"*"})
@Builder
public class PeliculaSalaCineController {
    
    
    private PeliculaSalaCineService peliculaSalaCineService;
    private SalaCineService salaCineService;
    
    @GetMapping(value="/{fecha_publicacion}")
    public ResponseEntity getPeliculasEnFecha(@PathVariable("fecha_publicacion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_publicacion)
    {
        PeliculasEnFecha peliculasEnFecha = peliculaSalaCineService.getPeliculasEnFecha(fecha_publicacion);
        
        if(peliculasEnFecha == null)
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND).body("No hay peliculas en esa fecha");
        }
        
        return ResponseEntity.status( HttpStatus.OK).body(peliculasEnFecha);
    }
    
    @GetMapping(value="/sala/{nombre}")
    public ResponseEntity getSalaCinePorNombre(@PathVariable("nombre") String nombre)
    {
        List<SalaCine> cines = salaCineService.getSalaCinePorNombre(nombre);
        
        if( !cines.isEmpty())
        {
            SalaCine salaCine = cines.get(0);
            int cantidad = peliculaSalaCineService.getCantidadPeliculasEnSalaCine( salaCine.getId_sala());
            
            if(cantidad < 3 )
            {
                return ResponseEntity.status( HttpStatus.OK).body("Sala Casi Vacia");
            }
            else if (cantidad >= 3 && cantidad <= 5)
            {
                return ResponseEntity.status( HttpStatus.OK).body("Sala Casi Llena");
            }
            else if (cantidad > 5){
                return ResponseEntity.status( HttpStatus.OK).body("Sala Llena");
            }
            
            
        }
        
        return ResponseEntity.status( HttpStatus.NOT_FOUND).body("No hay");
        
    }
    
    
}
