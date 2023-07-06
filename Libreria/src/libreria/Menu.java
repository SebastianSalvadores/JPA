/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Cliente;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;

/**
 *
 * @author Sebastian
 */
public class Menu {
    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public static LibroServicio libroServicio = new LibroServicio();
    public static AutorServicio autorServicio = new AutorServicio();
    public static EditorialServicio editorialServicio = new EditorialServicio();
    public static ClienteServicio clienteServicio = new ClienteServicio();
    public static PrestamoServicio prestamoServicio = new PrestamoServicio();
        
    public static void opc1() throws Exception{
        int opc = 0;
        do {            
            System.out.println("1. Crear Prestamo"
                    + "\n2. Crear Cliente"
                    + "\n3. Crear Libro"
                    + "\n4. Crear Autor"
                    + "\n5. Crear Editorial"
                    + "\n6. Volver al menu principal");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    prestamoServicio.crearPrestamo();
                    break;
                case 2:
                    clienteServicio.crearCliente();
                    break;
                case 3:
                    libroServicio.crearLibro();
                    break;
                case 4:
                    autorServicio.crearAutor();
                    break;
                case 5:
                    editorialServicio.crearEditorial();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 6);
        
    }
    
    public static void opc2() throws Exception{
        int opc = 0;
        do {            
            System.out.println("1. Devolver libro"
                    + "\n2. Modificar libro"
                    + "\n3. Modificar Autor"
                    + "\n4. Modificar Editorial"
                    + "\n5. Modificar Cliente"
                    + "\n6. Volver al menu principal");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    prestamoServicio.devolverLibro();
                    break;
                case 2:
                    Collection<Libro> libros = libroServicio.listarLibros();
                    for (Libro libro : libros) {
                        System.out.println(libro.toString());
                    }
                    System.out.println("Ingrese isbn de libro a editar:");
                    Long isbn = leer.nextLong();
                    libroServicio.modificarLibro(isbn);
                    break;
                case 3:
                    Collection<Autor> autores = autorServicio.listarAutores();
                    for (Autor autor : autores) {
                        System.out.println(autor.toString());
                    }
                    System.out.println("Ingrese id del autor a editar:");
                    Integer idAutor = leer.nextInt();
                    autorServicio.modificarAutor(idAutor);
                    break;
                case 4:
                    Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
                    for (Editorial editorial : editoriales) {
                        System.out.println(editorial.toString());
                    }
                    System.out.println("Ingrese id de la editorial a editar:");
                    Integer idEditorial = leer.nextInt();
                    editorialServicio.modificarEditorial(idEditorial);
                    break;
                case 5:
                    clienteServicio.modificarCliente();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 6);
    }
    
    public static void opc3() throws Exception{
        int opc = 0;
        do {            
            System.out.println("1.Dar de baja un libro"
                    + "\n2. Dar de baja un autor"
                    + "\n3. Dar de baja una editorial"
                    + "\n4. Volver al menu principal");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    Collection<Libro> libros = libroServicio.listarLibros();
                    for (Libro libro : libros) {
                        System.out.println(libro.toString());
                    }
                    System.out.println("Ingrese isbn de libro a dar de baja:");
                    Long isbn = leer.nextLong();
                    libroServicio.darDeBajaLibro(isbn);
                    break;
                case 2:
                    Collection<Autor> autores = autorServicio.listarAutores();
                    for (Autor autor : autores) {
                        System.out.println(autor.toString());
                    }
                    System.out.println("Ingrese id del autor a dar de baja:");
                    Integer idAutor = leer.nextInt();
                    autorServicio.darDeBajaAutor(idAutor);
                    break;
                case 3:
                    Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
                    for (Editorial editorial : editoriales) {
                        System.out.println(editorial.toString());
                    }
                    System.out.println("Ingrese id de la editorial a dar de baja:");
                    Integer idEditorial = leer.nextInt();
                    editorialServicio.darDeBajaEditorial(idEditorial);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
            
        } while (opc != 4);
    }
    
    public static void opc4() throws Exception{
        int opc = 0;
        do {            
            System.out.println("1. Dar de alta un libro"
                    + "\n2. Dar de alta un autor"
                    + "\n3. Dar de alta una editorial"
                    + "\n4. Volver al menu principal");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    Collection<Libro> libros = libroServicio.listarLibros();
                    for (Libro libro : libros) {
                        System.out.println(libro.toString());
                    }
                    System.out.println("Ingrese isbn de libro a dar de alta:");
                    Long isbn = leer.nextLong();
                    libroServicio.darDeAltaLibro(isbn);
                    break;
                case 2:
                    Collection<Autor> autores = autorServicio.listarAutores();
                    for (Autor autor : autores) {
                        System.out.println(autor.toString());
                    }
                    System.out.println("Ingrese id del autor a dar de alta:");
                    Integer idAutor = leer.nextInt();
                    autorServicio.darDeAltaAutor(idAutor);
                    break;
                case 3:
                    Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
                    for (Editorial editorial : editoriales) {
                        System.out.println(editorial.toString());
                    }
                    System.out.println("Ingrese id de la editorial a dar de alta:");
                    Integer idEditorial = leer.nextInt();
                    editorialServicio.darDeAltaEditorial(idEditorial);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 4);
    }
    
    public static void opc5(){
        int opc = 0;
        do {            
            System.out.println("1. Buscar un Autor por Nombre"
                    + "\n2. Buscar un libro por titulo"
                    + "\n3. Buscar un libro por ISBN"
                    + "\n4. Buscar un libro/s por nombre de autor"
                    + "\n5. Buscar un libro/s por nombre de editorial"
                    + "\n6. Buscar prestamo/s por cliente"
                    + "\n7. Volver al menu principal");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese nombre del autor a buscar: ");
                    String nombre = leer.next();
                    Autor autor = autorServicio.buscarAutorPorNombre(nombre);
                    if(autor != null){
                        System.out.println(autor.toString());
                    }else{
                        System.out.println("Autor no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese titulo del libro a buscar:");
                    String titulo = leer.next();
                    Libro libro = libroServicio.buscarLibroPorTitulo(titulo);
                    if(libro != null){
                        System.out.println(libro.toString());
                    }else{
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese ISBN del libro a buscar:");
                    Long isbn = leer.nextLong();
                    Libro libro2 = libroServicio.buscarLibroPorIsbn(isbn);
                    if(libro2 != null){
                        System.out.println(libro2.toString());
                    }else{
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    Collection<Libro> librosAutor = libroServicio.listarPorAutor();
                    for (Libro libroAutor : librosAutor) {
                        System.out.println(libroAutor.toString());
                    }
                    break;
                case 5:
                    Collection<Libro> librosEditorial = libroServicio.listarPorEditorial();
                    for (Libro libroEditorial : librosEditorial) {
                        System.out.println(libroEditorial.toString());
                    }
                    break;
                case 6:
                    Collection<Cliente> clientes = clienteServicio.listarClientes();
                    for (Cliente aux : clientes) {
                        if(aux.getAlta()){
                            System.out.println(aux.toString());
                        }
                    }
                    Cliente cliente;
                    Integer idCliente;
                    do{
                        System.out.println("Ingrese id del cliente:");
                        idCliente = leer.nextInt();
                        cliente = clienteServicio.buscarClientePorId(idCliente);
                        if(cliente == null || cliente.getAlta() == false){
                            System.out.println("El cliente no fue encontrado.");
                        }
                    }while(cliente == null);
                    
                    Collection<Prestamo> prestamos = prestamoServicio.listarPrestamosPorCliente(idCliente);
                    for (Prestamo prestamo : prestamos) {
                        System.out.println(prestamo.toString());
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 7);
    }
}
