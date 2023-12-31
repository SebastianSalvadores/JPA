/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author Sebastian
 */
public class EditorialServicio {
    private final EditorialDAO dao;
    private final Scanner leer;

    public EditorialServicio() {
        dao = new EditorialDAO();
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Editorial crearEditorial(){
        Editorial editorial = new Editorial();
        System.out.println("Ingrese nombre de la Editorial:");
        String nombre = leer.next();
        editorial.setNombre(nombre);
        dao.guardarEditorial(editorial);
        return editorial;
    }
    
    public Collection<Editorial> listarEditoriales(){
        Collection<Editorial> editoriales = dao.listarEditoriales();
        return editoriales;
    }
    
    public Editorial buscarEditorialPorId(int id){
        Editorial editorial = dao.buscarEditorialPorId(id);
        if(editorial != null && editorial.getAlta() == true){
            return editorial;
        }else{
            return null;
        }
    }
    
    public void darDeBajaEditorial(Integer id){
        dao.darDeBajaEditorial(id);
    }
    
    public void darDeAltaEditorial(Integer id){
        dao.darDeAltaEditorial(id);
    }
    
    public void modificarEditorial(Integer id){
        Editorial editorial = buscarEditorialPorId(id);
        System.out.println("Ingrese nuevo nombre de Editorial:");
        String nombre = leer.next();
        editorial.setNombre(nombre);
        dao.modificarEditorial(editorial);
    }
}
