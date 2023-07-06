/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import libreria.entidades.Prestamo;

/**
 *
 * @author Sebastian
 */
public class PrestamoDAO extends DAO{
    public void crearPrestamo(Prestamo prestamo){
        guardar(prestamo);
    }
    
    public void modificarPrestamo(Prestamo prestamo){
        modificar(prestamo);
    }
    
    public void darDeBajaPrestamo(Prestamo prestamo){
        prestamo.setAlta(false);
        modificar(prestamo);
    }
    
    public void darDeAltaPrestamo(Prestamo prestamo){
        prestamo.setAlta(true);
        modificar(prestamo);
    }
    
    public Collection<Prestamo> buscarPrestamosPorCliente(Integer idCliente){
        conectar();
        Collection<Prestamo> prestamos = em.createQuery("SELECT a FROM Prestamo a WHERE a.cliente.id LIKE :id").setParameter("id", idCliente).getResultList();
        desconectar();
        return prestamos;
    }
}
