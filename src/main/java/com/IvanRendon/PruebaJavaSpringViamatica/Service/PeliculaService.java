/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IvanRendon.PruebaJavaSpringViamatica.Service;


import com.IvanRendon.PruebaJavaSpringViamatica.Model.Pelicula;
import com.IvanRendon.PruebaJavaSpringViamatica.Repository.PeliculaRepository;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@Builder
public class PeliculaService {
    
    private final PeliculaRepository peliculaRepository;
    
    /**
     * Devuelve todas las peliculas registradas
     * @return Lista de todas las peliculas
     */
    public List<Pelicula> getTodasLasPeliculas()
    {
        return peliculaRepository.findAll();
    }
    
    
    /**
     * Busca pelicula por id y la devuelve en una lista
     * @param id_pelicula el id que va a buscar
     * @return Lista de peliculas que su id sea el del parametro
     */
    public Optional<Pelicula> getPeliculaPorId(int id_pelicula)
    {
        return peliculaRepository.findById( id_pelicula);
    }
    
    
    /**
     * Busca peliculas que contengan ese nombre  y la devuelve en una lista
     * @param nombre el nombre de las peliculas que va a buscar
     * @return Lista de las peliculas que contengan ese nombre
     */
    public List<Pelicula> getPeliculaPorNombre(String nombre)
    {
        return peliculaRepository.findByNombreContaining(nombre);
    }
    
    /**
     * Guarda una pelicula en la base de datos
     * @param pelicula Pelicula a guardar
     * @return Pelicula que se va a guardar
     */
    public Pelicula crearPelicula(Pelicula pelicula)
    {
        return peliculaRepository.save(pelicula);
    }
    
    /**
     * Actualiza la pelicula segun el id pasado por el parametro
     * @param id_pelicula el id de la pelicula a actualizar
     * @param pelicula Objeto de la pelicula con los nuevos datos
     * @return ResponseEntity con la respuesta de la actualización:
 *         - HttpStatus.OK y mensaje "Actualizado" si la película se actualizó correctamente.
 *         - HttpStatus.NOT_FOUND y mensaje "No se encontró" si no se encontró la película.
     */
    public ResponseEntity actualzarPelicula(int id_pelicula, Pelicula pelicula)
    {
        //Encontrar la pelicula
        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id_pelicula);
        
        //Comprueba que esté la pelciula
        if(peliculaOptional.isPresent())
        {
            //Asigna los nuevos datos a la pelicula
            Pelicula peliculaEncontrada = peliculaOptional.get();
            peliculaEncontrada.setNombre( pelicula.getNombre());
            peliculaEncontrada.setDuracion(pelicula.getDuracion());
            
            //Actualiza la pelicula
            peliculaRepository.save(peliculaEncontrada);
            
            //Devuelve la respuesta
            return ResponseEntity.status(HttpStatus.OK).body("Actulizado" );            
        }
        
        //Si no encuentra la pelicula devuelve un error
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró");
    }
    
    
    /**
     * Borra una pelicula por el id
     * @param id_pelicula el id de la pelicula a borrar
     * @return ResponseEntity con la respuesta de la eliminación:
     *                 -HttpStatus.OK si la pelciula se borró.
     *                 -HttpStatus.NOT_FOUND si la pelicula no se encontró
     */
    public ResponseEntity borrarPelicula(int id_pelicula)
    {
        //Encontrar la pelicula
        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id_pelicula);
        
        //Comprueba que esté la pelciula
        if(peliculaOptional.isPresent())
        {
            //Borra la pelicula
            peliculaRepository.deleteById(id_pelicula);
            
            //Devuelve la respuesta
            return ResponseEntity.status(HttpStatus.OK).body("Pelicula Borrada" );            
        }
        
        //Si no encuentra la pelicula devuelve un error
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró");
    }
    
}
