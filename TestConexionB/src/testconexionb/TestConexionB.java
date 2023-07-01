/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconexionb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import testconexionb.entidades.Pokemon;

/**
 *
 * @author Sebastian
 */
public class TestConexionB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("TestConexionBPU").createEntityManager();
//        Pokemon pokemon = em.find(Pokemon.class, 1);
//        System.out.println(pokemon.toString());
        
        List<Pokemon> pokemones = em.createQuery("SELECT a FROM Pokemon a").getResultList();
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.toString());
        }
    }
    
}
