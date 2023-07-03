/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Collection;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
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
        AutorServicio autorServicio = new AutorServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        
//        Libro libro = libroServicio.crearLibro();
//        autorServicio.darDeBajaAutor(2);
//        editorialServicio.darDeBajaEditorial(1);
//        autorServicio.darDeAltaAutor(2);
//        editorialServicio.darDeAltaEditorial(1);
//        Collection<Libro> libros = libroServicio.listarPorAutor();
//        for (Libro libro : libros) {
//            System.out.println(libro.toString());
//        }
//        Collection<Libro> libros = libroServicio.listarPorEditorial();
//        for (Libro libro : libros) {
//            System.out.println(libro.toString());
//        }
    }
    
}
