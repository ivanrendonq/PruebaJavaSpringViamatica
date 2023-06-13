/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Controller;

import com.IvanRendon.PruebaJavaSpringViamatica.Model.Pelicula;
import com.IvanRendon.PruebaJavaSpringViamatica.Service.PeliculaService;
import java.util.List;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/pelicula")
@CrossOrigin(origins = {"*"})
@Builder
public class PeliculaController {
    
    
    private final PeliculaService peliculaService;
    
    @GetMapping()
    public ResponseEntity getTodasLasPeliculas()
    {
        //Obtiene todas las peliculas
        List<Pelicula> peliculas = peliculaService.getTodasLasPeliculas();
        
        //Si la lista está vacia devuelve HttpStatus.NOT_FOUND
        if(peliculas.isEmpty())
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND).body("No hay peliculas");
        }
        
        //Si encuentra peliculas, devuelve HttpStatus.OK
        return ResponseEntity.status(HttpStatus.OK).body(peliculas);
        
    }
    
    @GetMapping(value ="/id/{id_pelicula}")
    public ResponseEntity getPeliculaPorId(@PathVariable("id_pelicula") int id_pelicula)
    {
        List<Pelicula> pelicula = peliculaService.getPeliculaPorId(id_pelicula).stream().toList();
        
        if(pelicula.isEmpty())
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND).body("No se encontró");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(pelicula);
    }
    
     @GetMapping(value ="/nombre/{nombre}")
    public ResponseEntity getPeliculaPorNombre(@PathVariable("nombre") String nombre)
    {
        List<Pelicula> pelicula = peliculaService.getPeliculaPorNombre(nombre);
        
        if(pelicula.isEmpty())
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND).body("No se encontró");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(pelicula);
    }
    
     @PostMapping(value ="/crear")
    public ResponseEntity crearPelicula(Pelicula pelicula)
    {
        Pelicula p = peliculaService.crearPelicula(pelicula);
        if(p == null)
        {
            return ResponseEntity.status( HttpStatus.UNPROCESSABLE_ENTITY).body("No se pudo crear");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(pelicula);
    }
    
     @PostMapping(value ="/actualizar/{id_pelicula}")
    public ResponseEntity actualizarPelicula(@PathVariable("id_pelicula") int id_pelicula,   Pelicula pelicula)
    {
        return peliculaService.actualzarPelicula(id_pelicula, pelicula);
    }
    
    
    @PostMapping(value ="/borrar/{id_pelicula}")
    public ResponseEntity borrarPelicula(@PathVariable("id_pelicula") int id_pelicula)
    {
        return peliculaService.borrarPelicula(id_pelicula);
    }
    
    
    
    
    
}
