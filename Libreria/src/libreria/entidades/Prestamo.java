/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import libreria.Convertidor.ConvertirLocalDate;

@Entity
@Table(name = "prestamos")
public class Prestamo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Convert(converter = ConvertirLocalDate.class)
    private LocalDate fechaPrestamo;
    
    @Temporal(TemporalType.DATE)
    @Convert(converter = ConvertirLocalDate.class)
    private LocalDate fechaDevolucion;
    
    @ManyToOne
    private Libro libro;
    
    @ManyToOne
    private Cliente cliente;
    
    private Boolean alta;

    public Prestamo() {
        this.alta = true;
    }

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
        this.alta = true;
    }

    public Integer getId() {
        return id;
    }


    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", libro=" + libro + ", cliente=" + cliente + ", alta=" + alta + '}';
    }

}
