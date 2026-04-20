/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2_prueba1;

/**
 *
 * @author Rogelio
 */
public class EmailAccount {
    String correo, contraseña, nombre;
    Email[] inbox;
    public EmailAccount(String correo, String contraseña, String nombre){
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.inbox = new Email[100]; 
        
    }
    
    public String getCorreo(){
        return correo;
    }
    public String getContraseña(){
        return contraseña;
    }
    public String getNombre(){
        return nombre;
    }
    
    public boolean recibirCorreos(Email correo){
        for(int x=0; x<inbox.length ; x++){
            if(inbox[x]==null){
                inbox[x] = correo;
                return true;
            }
        }
        return false;
    }
    public void mostrarInbox(){
        int noLeido = 0;
        int total = 0;
        String mensaje;
        
        System.out.println("Direccion: "+correo);
        System.out.println("Nombre: "+nombre);
        
        for (int x=0 ; x<inbox.length ; x++){
            if(inbox[x].Leido()){
                mensaje = "Leido";
            }else{
                mensaje = "No leido";
            }
            System.out.println(x +" - "+inbox[x].getEmisor()+" - "+inbox[x].getAsunto()+" - "+mensaje);
            total++;
            if(!inbox[x].Leido()){
                noLeido++;
            }
        }
        System.out.println("Correos sin leer: "+noLeido);
        System.out.println("Correos totales recibidos: "+total);
        
    }
    
    public void leerCorreo(int posicion){ 
            if(posicion < 0 || posicion >= inbox.length || inbox[posicion] == null){
                System.out.println("Correo no existe");
            }else{
                inbox[posicion].mostrarCorreo();
                inbox[posicion].estaLeido();
            }
        }
        
        public void eliminarLeido(){
            for(int x=0 ; x<inbox.length ; x++){
                if(inbox[x]!=null && inbox[x].Leido()){
                    inbox[x]=null;
                }
            }
            System.out.println("Correos leidos eliminados");
        }
}
