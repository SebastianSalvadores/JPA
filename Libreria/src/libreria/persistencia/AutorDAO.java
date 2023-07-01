/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import libreria.entidades.Autor;

/**
 *
 * @author Sebastian
 */
public final class AutorDAO extends DAO{
    public void guardarAutor(Autor autor){
        guardar(autor);
    }
    
    public void modificarAutor(Autor autor){
        modificar(autor);
    }
    
    public void darDeBajaAutor(Integer id){
        Autor autor = buscarAutorPorId(id);
        autor.setAlta(false);
        modificar(autor);
    }
    
    public Autor buscarAutorPorId(Integer id){
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }
    
    public Autor buscarAutorPorNombre(String nombre){
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }
    
    public Collection<Autor> listarAutores(){
        conectar();
        Collection<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }
}
