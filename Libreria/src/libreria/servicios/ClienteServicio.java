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
    
    public void modificarCliente(){
        String resp = "";
        Collection<Cliente> clientes = listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
        Cliente cliente;
        do{
            System.out.println("Ingrese id del cliente a modificar:");
            Integer id = leer.nextInt();
            cliente = buscarClientePorId(id);
            if(cliente == null){
                System.out.println("El cliente no existe o fue dado de baja");
            }
        }while(cliente == null);
        do {            
            System.out.println("¿Desea modificar el documento del cliente? (S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        if(resp.equalsIgnoreCase("S")){
            System.out.println("Ingrese nuevo documento:");
            Long documento = leer.nextLong();
            cliente.setDocumento(documento);
        }
        
        do {            
            System.out.println("¿Desea modificar el nombre del cliente? (S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        if(resp.equalsIgnoreCase("S")){
            System.out.println("Ingrese nuevo nombre:");
            String nombre = leer.next();
            cliente.setNombre(nombre);
        }
        
        do {            
            System.out.println("¿Desea modificar el apellido del cliente? (S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        if(resp.equalsIgnoreCase("S")){
            System.out.println("Ingrese nuevo apellido:");
            String apellido = leer.next();
            cliente.setApellido(apellido);
        }
        
        do {            
            System.out.println("¿Desea modificar el telefono del cliente? (S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        if(resp.equalsIgnoreCase("S")){
            System.out.println("Ingrese nuevo telefono:");
            String telefono = leer.next();
            cliente.setTelefono(telefono);
        }
        
        dao.modificarCliente(cliente);
    }
}
