/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rebecaangulorojas
 */
public interface PilaADT <T> {
    public void push(T dato);
    public T pop();
    public boolean isEmpty(); //saber si toda la pila esta vacia
    public T peek();
    public T multipop(int n);
}
