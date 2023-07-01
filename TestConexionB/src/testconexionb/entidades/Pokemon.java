/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconexionb.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {
    @Id
    private int numero_pokedex;
    private String nombre;
    private double peso;
    private double altura;

    public Pokemon() {
    }

    public Pokemon(int numero_pokedex, String nombre, double peso, double altura) {
        this.numero_pokedex = numero_pokedex;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public int getNumero_pokedex() {
        return numero_pokedex;
    }

    public void setNumero_pokedex(int numero_pokedex) {
        this.numero_pokedex = numero_pokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "numero_pokedex=" + numero_pokedex + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + '}';
    }

    
    
    
}
