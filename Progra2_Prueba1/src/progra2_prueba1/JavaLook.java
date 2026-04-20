/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2_prueba1;

import java.util.Scanner;

/**
 *
 * @author Rogelio
 */
public class JavaLook {
 
    static EmailAccount[] cuentas = new EmailAccount[100];
    static EmailAccount cuentaActiva = null;
    static Scanner n = new Scanner(System.in);
 
    public static void main(String[] args){
        menuInicial();
    }
    
    public static void menuInicial(){
        int opcion = 0;
 
        while(opcion !=1 && opcion !=2){
            System.out.println("\n===== MENU INICIAL =====");
            System.out.println("1. Login");
            System.out.println("2. Crear cuenta");
            System.out.print("Opcion: ");
            opcion = n.nextInt();
            n.nextLine();
 
            if(opcion == 1){
                login();
            }else if (opcion == 2){
                crearCuenta();
            }else{
                System.out.println("Opcion invalida.");
            }
 
            opcion = 0; 
        }
    }
 
    public static void login(){
        System.out.print("Correo: ");
        String correo = n.nextLine();
        System.out.print("Contraseña: ");
        String pass = n.nextLine();
 
        EmailAccount cuenta = buscarCuenta(correo);
 
        if (cuenta != null && cuenta.getContraseña().equals(pass)){
            cuentaActiva = cuenta;
            System.out.println("Sesion iniciada. Bienvenido, " + cuentaActiva.getNombre());
            menuPrincipal();
        } else {
            System.out.println("Correo o contraseña incorrectos.");
        }
    }
 
    public static void crearCuenta(){
        System.out.print("Correo: ");
        String correo = n.nextLine();
 
        if (buscarCuenta(correo) != null){
            System.out.println("Ese correo ya existe.");
            return;
        }
 
        System.out.print("Nombre: ");
        String nombre = n.nextLine();
        System.out.print("Contraseña: ");
        String pass = n.nextLine();
 
        EmailAccount nueva = new EmailAccount(correo, pass, nombre);
 
        boolean guardado = false;
        for (int i = 0; i < cuentas.length; i++){
            if (cuentas[i] == null) {
                cuentas[i] = nueva;
                guardado = true;
                break;
            }
        }
 
        if (guardado){
            cuentaActiva = nueva;
            System.out.println("Cuenta creada exitosamente.");
            menuPrincipal();
        }else{
            System.out.println("No hay espacio para mas cuentas.");
        }
    }
 
    public static void menuPrincipal(){
        int opcion = 0;
 
        while (opcion != 5) {
            System.out.println("\n=====MENU PRINCIPAL=====");
            System.out.println("Cuenta: " + cuentaActiva.getCorreo());
            System.out.println("1. Ver inbox");
            System.out.println("2. Mandar correo");
            System.out.println("3. Leer un correo");
            System.out.println("4. Limpiar inbox");
            System.out.println("5. Cerrar sesion");
            System.out.print("Opcion: ");
            opcion = n.nextInt();
            n.nextLine();
 
            if(opcion == 1){
                cuentaActiva.mostrarInbox();
            }else if (opcion == 2){
                mandarCorreo();
            }else if (opcion == 3){
                leerCorreo();
            }else if (opcion == 4){
                cuentaActiva.eliminarLeido();
            }else if (opcion == 5){
                cuentaActiva = null;
                System.out.println("Sesion cerrada.");
            }else{
                System.out.println("Opcion invalida.");
            }
        }
    }
 
    public static void mandarCorreo(){
        System.out.print("Destinatario: ");
        String destCorreo = n.nextLine();
 
        EmailAccount destino = buscarCuenta(destCorreo);
 
        if (destino == null) {
            System.out.println("El destinatario no existe.");
            return;
        }
 
        System.out.print("Asunto: ");
        String asunto = n.nextLine();
        System.out.print("Contenido: ");
        String contenido = n.nextLine();
 
        Email email = new Email(cuentaActiva.getCorreo(), asunto, contenido);
 
        if (destino.recibirCorreos(email)) {
            System.out.println("Correo enviado exitosamente.");
        } else {
            System.out.println("No se pudo enviar. El inbox del destinatario esta lleno.");
        }
    }
 
    public static void leerCorreo() {
        System.out.print("Posicion del correo: ");
        int pos = n.nextInt();
        n.nextLine();
        cuentaActiva.leerCorreo(pos);
    }
 
    public static EmailAccount buscarCuenta(String correo) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null && cuentas[i].getCorreo().equals(correo)) {
                return cuentas[i];
            }
        }
        return null;
    }
}
