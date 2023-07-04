/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import javax.persistence.NoResultException;
import libreria.entidades.Editorial;

/**
 *
 * @author Sebastian
 */
public final class EditorialDAO extends DAO{
    public void guardarEditorial(Editorial editorial){
        guardar(editorial);
    }
    
    public void modificarEditorial(Editorial editorial){
        modificar(editorial);
    }
    
    public void darDeBajaEditorial(Integer id){
        Editorial editorial = buscarEditorialPorId(id);
        editorial.setAlta(false);
        modificar(editorial);
    }
    
    public void darDeAltaEditorial(Integer id){
        Editorial editorial = buscarEditorialPorId(id);
        editorial.setAlta(true);
        modificar(editorial);
    }
    
    public Editorial buscarEditorialPorId(Integer id){
        try{
            conectar();
            Editorial editorial = (Editorial) em.createQuery("SELECT a FROM Editorial a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
            desconectar();
            return editorial;
        }catch(NoResultException nre){
            return null;
        }
    }
    
    public Collection<Editorial> listarEditoriales(){
        conectar();
        Collection<Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
        desconectar();
        return editoriales;
    }
}
