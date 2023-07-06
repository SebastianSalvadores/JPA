/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

/**
 *
 * @author Sebastian
 */
public class ClienteServicio {
    private final ClienteDAO dao;
    private final Scanner leer;

    public ClienteServicio() {
        this.dao = new ClienteDAO();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Cliente crearCliente(){
        Cliente cliente = new Cliente();
        System.out.println("Ingrese documento:");
        Long documento = leer.nextLong();
        cliente.setDocumento(documento);
        System.out.println("Ingrese nombre:");
        String nombre = leer.next();
        cliente.setNombre(nombre);
        System.out.println("Ingrese apellido:");
        String apellido = leer.next();
        cliente.setApellido(apellido);
        System.out.println("Ingrese telefono:");
        String telefono = leer.next();
        cliente.setTelefono(telefono);
        dao.crearCliente(cliente);
        return cliente;
    }
    
    public Collection<Cliente> listarClientes(){
        Collection<Cliente> clientes = dao.listarClientes();
        return clientes;
    }
    
    public Cliente buscarClientePorId(Integer id){
        Cliente cliente = dao.buscarClientePorId(id);
        return cliente;
    }
}
