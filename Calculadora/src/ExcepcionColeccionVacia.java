/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rebecaangulorojas
 */
public class ExcepcionColeccionVacia extends RuntimeException {

    public ExcepcionColeccionVacia() {
        super("¡coleccion vacia!");
    }
    
    public ExcepcionColeccionVacia(String mensaje) {
        super(mensaje);
    } 
}
