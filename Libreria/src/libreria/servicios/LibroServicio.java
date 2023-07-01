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
                Collection<Autor> autores = autorServicio.listarAutores();
                for (Autor aux : autores) {
                    System.out.println(aux.toString());
                }
                System.out.println("Ingrese id del autor:");
                int idAutor = leer.nextInt();
                Autor autor1 = autorServicio.buscarAutorPorId(idAutor);
                libro.setAutor(autor1);
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
                Collection<Editorial> editoriales = editorialServicio.listarEditoriales();
                for (Editorial aux : editoriales) {
                    System.out.println(aux.toString());
                }
                System.out.println("Ingrese id de la Editorial:");
                int idEditorial = leer.nextInt();
                Editorial editorial1 = editorialServicio.buscarEditorialPorId(idEditorial);
                libro.setEditorial(editorial1);
                break;
            
        }
        dao.guardarLibro(libro);
        return libro;
    }
}
