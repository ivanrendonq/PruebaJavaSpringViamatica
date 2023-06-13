
package com.IvanRendon.PruebaJavaSpringViamatica.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author usuario
 */
@Entity
@Table(schema = "pelicula_salacine")
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PeliculaSalacine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pelicula_sala;
    
   @JoinColumn(name = "id_sala_cine")
   @ManyToOne
   private SalaCine salaCine;
   
   @Column
   private Date fecha_publicacion;
   
   @Column
   private Date fecha_fin;
   
   @JoinColumn(name = "id_pelicula")
   @ManyToOne
   private Pelicula pelicula;

    public PeliculaSalacine(int id_pelicula_sala, SalaCine salaCine, Date fecha_publicacion, Date fecha_fin, Pelicula pelicula) {
        this.id_pelicula_sala = id_pelicula_sala;
        this.salaCine = salaCine;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_fin = fecha_fin;
        this.pelicula = pelicula;
    }
 
   
   
}
