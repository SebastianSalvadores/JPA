/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;

/**
 *
 * @author Sebastian
 */
public class PrestamoServicio {
    private final PrestamoDAO dao;
    private final Scanner leer;
    private final LibroServicio libroServicio;
    private final ClienteServicio clienteServicio;

    public PrestamoServicio() {
        dao = new PrestamoDAO();
        leer = new Scanner(System.in).useDelimiter("\n");
        libroServicio = new LibroServicio();
        clienteServicio = new ClienteServicio();
    }
    
    public Prestamo crearPrestamo(){
        
        Prestamo prestamo = new Prestamo();
        int opc = 0;
        LocalDate fechaPrestamo = null;
        do {            
            System.out.println("Seleccione la fecha en la que se realizó el prestamo:"
                    + "\n1. Seleccionar la fecha de hoy"
                    + "\n2. Elegir otra fecha");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    fechaPrestamo = LocalDate.now();
                    break;
                case 2:
                    System.out.println("Ingrese dia:");
                    int dia = leer.nextInt();
                    System.out.println("Ingrese mes:");
                    int mes = leer.nextInt();
                    System.out.println("Ingrese año:");
                    int anio = leer.nextInt();
                    fechaPrestamo = LocalDate.of(anio, mes, dia);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 1 && opc != 2);
        prestamo.setFechaPrestamo(fechaPrestamo);
        
        LocalDate fechaDevolucion = null;
        do {            
            System.out.println("Seleccione fecha de devolucion:"
                    + "1. Calcular por cantidad de dias."
                    + "2. Ingresar fecha manualmente.");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese cantidad de dias que dura el prestamo:");
                    int dias = leer.nextInt();
                    fechaDevolucion = prestamo.getFechaPrestamo().plusDays(dias);
                    break;
                case 2:
                    System.out.println("Ingrese dia:");
                    int dia = leer.nextInt();
                    System.out.println("Ingrese mes:");
                    int mes = leer.nextInt();
                    System.out.println("Ingrese año:");
                    int anio = leer.nextInt();
                    fechaDevolucion = LocalDate.of(anio, mes, dia);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 1 && opc != 2);
        prestamo.setFechaDevolucion(fechaDevolucion);
        
        Collection<Libro> libros = libroServicio.listarLibros();
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
        
        Libro libro = null;
        boolean validacionPrestamo = false;
        do{
            do{
                System.out.println("Ingrese ISBN del libro a prestar:");
                Long isbn = leer.nextLong();
                libro = libroServicio.buscarLibroPorIsbn(isbn);
                if(libro == null){
                    System.out.println("ISBN incorrecto. Por favor, ingrese nuevamente.");
                }
            }while(libro == null);
            Integer ejemplaresRestantes = libro.getEjemplaresRestantes();
            if(ejemplaresRestantes == 0){
                System.out.println("No quedan mas ejemplares de ese libro.");
            }else{
                Integer ejemplaresPrestados = libro.getEjemplaresPrestados();
                ejemplaresPrestados++;
                ejemplaresRestantes--;
                libro.setEjemplaresPrestados(ejemplaresPrestados);
                libro.setEjemplaresRestantes(ejemplaresRestantes);
                validacionPrestamo = true;
            }
        }while(validacionPrestamo == false);
        
        prestamo.setLibro(libro);
        
        Cliente cliente = null;
        do {            
            System.out.println("1. Crear un cliente nuevo"
                    + "\n2. Seleccionar un cliente existente");
            System.out.println("Seleccione una opcion:");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    cliente = clienteServicio.crearCliente();
                    break;
                case 2:
                    Collection<Cliente> clientes = clienteServicio.listarClientes();
                    for (Cliente aux : clientes) {
                        System.out.println(aux.toString());
                    }
                    do {            
                        System.out.println("Ingrese id del cliente que realiza el prestamo:");
                        Integer id = leer.nextInt();
                        cliente = clienteServicio.buscarClientePorId(id);
                        if(cliente == null){
                            System.out.println("El id ingresado es incorrecto. Ingrese nuevamente.");
                        }
                    } while (cliente == null);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 1 && opc != 2);
        prestamo.setCliente(cliente);
        
        dao.crearPrestamo(prestamo);
        
        return prestamo;
    }
    
    
    
}
