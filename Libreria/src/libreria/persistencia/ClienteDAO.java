/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.Collection;
import javax.persistence.NoResultException;
import libreria.entidades.Cliente;

/**
 *
 * @author Sebastian
 */
public class ClienteDAO extends DAO{
    
    public void crearCliente(Cliente cliente){
        guardar(cliente);
    }
    
    public void modificarCliente(Cliente cliente){
        modificar(cliente);
    }
    
    public void darDeBajaCliente(Cliente cliente){
        cliente.setAlta(false);
        modificar(cliente);
    }
    
    public void darDeAltaCliente(Cliente cliente){
        cliente.setAlta(true);
        modificar(cliente);
    }
    
    public Cliente buscarClientePorId(Integer id){
        try{
            conectar();
            Cliente cliente = (Cliente) em.createQuery("SELECT a FROM Cliente a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
            desconectar();
            return cliente;
        }catch(NoResultException nre){
            desconectar();
            return null;
        }
    }
    
    public Collection<Cliente> listarClientes(){
        conectar();
        Collection<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a").getResultList();
        desconectar();
        return clientes;
    }
}
