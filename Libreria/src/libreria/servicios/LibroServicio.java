/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Sebastian
 */
public class LibroServicio {
    private final LibroDAO dao;
    private final Scanner leer;
    private final AutorServicio autorServicio;
    private final EditorialServicio editorialServicio;

    public LibroServicio() {
        dao = new LibroDAO();
        leer = new Scanner(System.in).useDelimiter("\n");
        autorServicio = new AutorServicio();
        editorialServicio = new EditorialServicio();
    }
    
    public Libro crearLibro() throws Exception{
        Libro libro = new Libro();
        System.out.println("Ingrese titulo:");
        String titulo = leer.next();
        libro.setTitulo(titulo);
        System.out.println("Ingrese año:");
        int anio = leer.nextInt();
        libro.setAnio(anio);
        System.out.println("Ingrese cantidad de ejemplares:");
        int ejemplares = leer.nextInt();
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresRestantes(ejemplares);
        int opc;
        do{
            System.out.println("Seleccione una opción:"
                    + "\n1. Crear nuevo autor."
                    + "\n2. Seleccionar autor existente.");
            opc = leer.nextInt();
            if(opc < 1 || opc > 2){
                System.out.println("Opcion incorrecta.");
            }
        }while(opc < 1 || opc > 2);
        switch (opc) {
            case 1:
                Autor autor = autorServicio.crearAutor();
                libro.setAutor(autor);
                break;
            case 2:
                Autor autor1;
                do{
                    Collection<Autor> autores = autorServicio.listarAutores();
                    for (Autor aux : autores) {
                        System.out.println(aux.toString());
                    }
                    System.out.println("Ingrese id del autor:");
                    int idAutor = leer.nextInt();
                    autor1 = autorServicio.buscarAutorPorId(idAutor);
                    if(autor1 == null){
                        System.out.println("El id ingresado no existe o fue dado de baja.");
                    }else{
                        libro.setAutor(autor1);
                    }
                }while(autor1 == null);
                break;
            
        }
        do {            
            System.out.println("Seleccione una opcion:"
                    + "\n1. Crear nueva editorial."
                    + "\n2. Seleccionar editorial existente.");
            opc = leer.nextInt();
            if(opc < 1 || opc > 2){
                System.out.println("Opcion incorrecta.");
            }
        } while (opc < 1 || opc > 2);
        switch (opc) {
            case 1:
                Editorial editorial = editorialServicio.crearEditorial();
                libro.setEditorial(editorial);
                break;
            case 2:
                Editorial editorial1;
                do{
                    Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
                    for (Editorial aux : editoriales) {
                        System.out.println(aux.toString());
                    }
                    System.out.println("Ingrese id de la Editorial:");
                    int idEditorial = leer.nextInt();
                    editorial1 = editorialServicio.buscarEditorialPorId(idEditorial);
                    if(editorial1 == null){
                        System.out.println("El id ingresado no existe o fue dado de baja.");
                    }else{
                        libro.setEditorial(editorial1);
                    }
                }while(editorial1 == null);
                break;
        }
        
        dao.guardarLibro(libro);
        return libro;
    }
    
    public void darDeBajaLibro(Long isbn) throws Exception{
        Libro libro = dao.buscarLibroPorIsbn(isbn);
        libro.setAlta(false);
        dao.modificarLibro(libro);
    }
    
    public void darDeAltaLibro(Long isbn) throws Exception{
        Libro libro = dao.buscarLibroPorIsbn(isbn);
        libro.setAlta(true);
        dao.modificarLibro(libro);
    }
    
    public void modificarLibro(Long isbn) throws Exception{
        Libro libro = dao.buscarLibroPorIsbn(isbn);
        String resp;
        do{
            System.out.println("¿Desea modificar el titulo del libro? (S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }else{
                if(resp.equalsIgnoreCase("S")){
                    System.out.println("Ingrese nuevo titulo:");
                    String titulo = leer.next();
                    libro.setTitulo(titulo);
                }
            }
        }while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        do {            
            System.out.println("¿Desea modificar el año de publicacion?(S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }else{
                if(resp.equalsIgnoreCase("S")){
                    System.out.println("Ingrese nuevo año:");
                    Integer anio = leer.nextInt();
                    libro.setAnio(anio);
                }
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        do {            
            System.out.println("¿Desea modificar la cantidad de ejemplares?(S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }else{
                if(resp.equalsIgnoreCase("S")){
                    Integer ejemplares;
                    Integer ejemplaresPrestados;
                    do{
                        System.out.println("Ingrese cantidad de ejemplares:");
                        ejemplares = leer.nextInt();
                        ejemplaresPrestados = libro.getEjemplaresPrestados();
                        if(ejemplaresPrestados > ejemplares){
                            System.out.println("La nueva cantidad de ejemplares no puede ser menor a la cantidad de ejemplares que ya fueron prestados.");
                        }
                    }while(ejemplaresPrestados > ejemplares);
                    Integer ejemplaresRestantes = ejemplares - ejemplaresPrestados;
                    libro.setEjemplares(ejemplares);
                    libro.setEjemplaresRestantes(ejemplaresRestantes);
                }
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        do{
            System.out.println("¿Desea modificar el autor?(S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }else{
                if(resp.equalsIgnoreCase("S")){
                    int opc;
                    do{
                        System.out.println("Seleccione una opción:"
                                + "\n1. Crear nuevo autor."
                                + "\n2. Seleccionar autor existente."
                                + "\n3. Modificar autor actual.");
                        opc = leer.nextInt();
                        if(opc < 1 || opc > 3){
                            System.out.println("Opcion incorrecta.");
                        }
                    }while(opc < 1 || opc > 3);
                    switch (opc) {
                        case 1:
                            Autor autor = autorServicio.crearAutor();
                            libro.setAutor(autor);
                            break;
                        case 2:
                            Autor autor1;
                            do{
                                Collection<Autor> autores = autorServicio.listarAutores();
                                for (Autor aux : autores) {
                                    System.out.println(aux.toString());
                                }
                                System.out.println("Ingrese id del autor:");
                                int idAutor = leer.nextInt();
                                autor1 = autorServicio.buscarAutorPorId(idAutor);
                                if(autor1 == null){
                                    System.out.println("El id ingresado no existe o fue dado de baja.");
                                }else{
                                    libro.setAutor(autor1);
                                }
                            }while(autor1 == null);
                            break;
                        case 3:
                            autorServicio.modificarAutor(libro.getAutor().getId());
                            break;

                    }
                }
            }
        }while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        do {            
            System.out.println("¿Desea modificar la Editorial?(S/N)");
            resp = leer.next();
            if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                System.out.println("Respuesta incorrecta.");
            }else{
                if(resp.equalsIgnoreCase("S")){
                    int opc;
                    do {            
                        System.out.println("Seleccione una opcion:"
                                + "\n1. Crear nueva editorial."
                                + "\n2. Seleccionar editorial existente."
                                + "\n3. Modificar editorial actual.");
                        opc = leer.nextInt();
                        if(opc < 1 || opc > 3){
                            System.out.println("Opcion incorrecta.");
                        }
                    } while (opc < 1 || opc > 3);
                    switch (opc) {
                        case 1:
                            Editorial editorial = editorialServicio.crearEditorial();
                            libro.setEditorial(editorial);
                            break;
                        case 2:
                            Editorial editorial1;
                            do{
                                Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
                                for (Editorial aux : editoriales) {
                                    System.out.println(aux.toString());
                                }
                                System.out.println("Ingrese id de la Editorial:");
                                int idEditorial = leer.nextInt();
                                editorial1 = editorialServicio.buscarEditorialPorId(idEditorial);
                                if(editorial1 == null){
                                    System.out.println("El id ingresado no existe o fue dado de baja.");
                                }else{
                                    libro.setEditorial(editorial1);
                                }
                            }while(editorial1 == null);
                            break;
                        case 3:
                            editorialServicio.modificarEditorial(libro.getEditorial().getId());
                            break;

                    }
                }
            }
        } while (!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
        dao.modificarLibro(libro);
    }
    
    public Collection<Libro> listarPorAutor(){
        Autor autor;
        Collection<Libro> libros = null;
        do{
            Collection<Autor> autores = autorServicio.listarAutores();
            for (Autor aux : autores) {
                System.out.println(aux.toString());
            }
            System.out.println("Ingrese id del autor:");
            int idAutor = leer.nextInt();
            autor = autorServicio.buscarAutorPorId(idAutor);
            if(autor == null){
                System.out.println("El id ingresado no existe o fue dado de baja.");
            }else{
                String nombre = autor.getNombre();
                libros = dao.buscarLibroPorAutor(nombre);
                
            }
        }while(autor == null);
        return libros;
    }
    
    public Collection<Libro> listarPorEditorial(){
        Editorial editorial;
        Collection<Libro> libros = null;
        do{
            Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
            for (Editorial aux : editoriales) {
                System.out.println(aux.toString());
            }
            System.out.println("Ingrese id de la editorial:");
            int idEditorial = leer.nextInt();
            editorial = editorialServicio.buscarEditorialPorId(idEditorial);
            if(editorial == null){
                System.out.println("El id ingresado no existe o fue dado de baja.");
            }else{
                String nombre = editorial.getNombre();
                libros = dao.buscarLibroPorEditorial(nombre);
            }
        }while(editorial == null);
        return libros;
    }
    
    public Collection<Libro> listarLibros(){
        Collection<Libro> libros = dao.listarLibros();
        return libros;
    }
    
    public Libro buscarLibroPorTitulo(String titulo){
        Libro libro = dao.buscarLibroPorTitulo(titulo);
        return libro;
    }
    
    public Libro buscarLibroPorIsbn(Long isbn){
        Libro libro = dao.buscarLibroPorIsbn(isbn);
        return libro;
    }
    
    public void actualizarPrestamosLibro(Libro libro) throws Exception{
        dao.modificarLibro(libro);
    }
}
