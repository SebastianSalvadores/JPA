/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import javax.persistence.NoResultException;
import libreria.entidades.Autor;
import libreria.entidades.Libro;

/**
 *
 * @author Sebastian
 */
public final class LibroDAO extends DAO{
    public void guardarLibro(Libro libro) throws Exception{
        try {
            if(libro == null){
                throw new Exception("Debe indicar un libro.");
            }
            guardar(libro);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarLibro(Libro libro) throws Exception{
        try {
            if(libro == null){
                throw new Exception("Debe indicar un libro.");
            }
            modificar(libro);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void darDeBajaLibro(Long isbn){
        Libro libro = buscarLibroPorIsbn(isbn);
        libro.setAlta(false);
        modificar(libro);
    }
    
    public void darDeAltaLibro(Long isbn){
        Libro libro = buscarLibroPorIsbn(isbn);
        libro.setAlta(true);
        modificar(libro);
    }
    
    public Libro buscarLibroPorIsbn(Long isbn){
        try{
            conectar();
            Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn LIKE :isbn").setParameter("isbn", isbn).getSingleResult();
            desconectar();
            return libro;
        }catch(NoResultException nre){
            desconectar();
            return null;
        }
    }
    
    public Libro buscarLibroPorTitulo(String titulo){
        try{
            conectar();
            Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo").setParameter("titulo", titulo).getSingleResult();
            desconectar();
            return libro;
        }catch(NoResultException nre){
            desconectar();
            return null;
        }
    }
    
    public Collection<Libro> buscarLibroPorAutor(String nombre){
        conectar();
        Collection<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.autor.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }
    
    public Collection<Libro> buscarLibroPorEditorial(String nombre){
        conectar();
        Collection<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.editorial.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }
    
    public Collection<Libro> listarLibros(){
        conectar();
        Collection<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }
    
}
