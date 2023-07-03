/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Sebastian
 */
public class AutorServicio {
    private final AutorDAO dao;
    private final Scanner leer;

    public AutorServicio() {
        dao = new AutorDAO();
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Autor crearAutor(){
        Autor autor = new Autor();
        System.out.println("Ingrese nombre del Autor:");
        String nombre = leer.next();
        autor.setNombre(nombre);
        dao.guardarAutor(autor);
        return autor;
    }
    
    public Collection<Autor> listarAutores(){
        Collection<Autor> autores = dao.listarAutores();
        return autores;
    }
    
    public Autor buscarAutorPorId(int id){
        Autor autor = dao.buscarAutorPorId(id);
        if(autor != null && autor.getAlta() == true){
            return autor;
        }else{
            return null;
        }
    }
    
    public void darDeBajaAutor(Integer id){
        dao.darDeBajaAutor(id);
    }
    
    public void darDeAltaAutor(Integer id){
        dao.darDeAltaAutor(id);
    }
    
    public void modificarAutor(Integer id){
        Autor autor = buscarAutorPorId(id);
        System.out.println("Ingrese nuevo nombre de Autor:");
        String nombre = leer.next();
        autor.setNombre(nombre);
        dao.modificarAutor(autor);
    }
}
