/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Scanner;

public class Libreria {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc = 0;
        
        do {            
            System.out.println("Base de Datos JPA - Libreria"
                    + "\n1. Crear/Persistir una entidad."
                    + "\n2. Devolver libro/Modificar una entidad."
                    + "\n3. Dar de baja una entidad."
                    + "\n4. Dar de alta una entidad."
                    + "\n5. Realizar una busqueda."
                    + "\n6. Salir");
            System.out.println("Seleccione una opcion:");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    Menu.opc1();
                    break;
                case 2:
                    Menu.opc2();
                    break;
                case 3:
                    Menu.opc3();
                    break;
                case 4:
                    Menu.opc4();
                    break;
                case 5:
                    Menu.opc5();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 6);
    }
    
}
