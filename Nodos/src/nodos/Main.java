/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author Rogelio
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ LISTA ENLAZADA ---");
            System.out.println("1. Agregar nodo al inicio (Posición 0)");
            System.out.println("2. Insertar en posición específica");
            System.out.println("3. Eliminar por código");
            System.out.println("4. Ver tamaño de la lista");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el código del nodo: ");
                        int codInicio = sc.nextInt();
                        lista.add(0, new Nodo(codInicio));
                        System.out.println("Nodo agregado.");
                        break;

                    case 2:
                        System.out.print("Ingrese la posición (índice): ");
                        int idx = sc.nextInt();
                        System.out.print("Ingrese el código del nodo: ");
                        int codIdx = sc.nextInt();
                        try {
                            lista.add(idx, new Nodo(codIdx));
                            System.out.println("Nodo insertado.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el código a eliminar: ");
                        int codEli = sc.nextInt();
                        if (lista.remove(codEli)) {
                            System.out.println("Nodo eliminado exitosamente.");
                        } else {
                            System.out.println("No se encontró ningún nodo con ese código.");
                        }
                        break;

                    case 4:
                        System.out.println("La lista tiene " + lista.size() + " nodos.");
                        break;

                    case 5:
                        System.out.println("Estado de la lista:");
                        lista.mostrar();
                        break;

                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                sc.next(); // Limpiar el scanner
            }
        } while (opcion != 6);

        sc.close();
    }
}