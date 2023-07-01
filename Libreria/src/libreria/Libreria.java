/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import libreria.entidades.Libro;
import libreria.servicios.LibroServicio;

/**
 *
 * @author Sebastian
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LibroServicio libroServicio = new LibroServicio();
        
        Libro libro = libroServicio.crearLibro();
        
        
    }
    
}
