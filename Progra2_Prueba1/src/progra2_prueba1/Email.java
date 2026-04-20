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
public class Email {
    String emisor, asunto, mensaje;
    boolean leido;
    public Email(String emisor, String asunto, String mensaje){
        this.emisor = emisor;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.leido = false;
    }
    
    //GETTERS
    public String getEmisor(){
        return emisor;
    }
    public String getAsunto(){
        return asunto;
    }
    public String getMensaje(){
        return mensaje;
    }
    public boolean Leido(){
        return leido;
    }
    
    public void estaLeido(){
        leido = true;
    }
    
    public void mostrarCorreo(){
        System.out.println("DE: "+emisor);
        System.out.println("ASUNTO: "+asunto);
        System.out.println("MENSAJE: "+mensaje);
    }
}
