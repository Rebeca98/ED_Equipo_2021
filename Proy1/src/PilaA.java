/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rebecaangulorojas
 */
//ojo con la sintaxis, para hace una pila tipo T
public class PilaA<T> implements PilaADT<T>  {
    private T[] elementos; 
    private int tope;
    private final int MAX = 20; 
    
    public PilaA()
    {
        elementos = (T[]) new Object[MAX];
        tope = -1; //indica pila vacia
    }
    //para que me construya la pila con otra capacidad de almacenamiento
    public PilaA( int max)
    {
        elementos = (T[]) new Object[max];
        tope = -1; //indica pila vacia
    }
    
    //metodo para avisarnos si la pila esta vacia
    public boolean isEmpty(){
        return tope == -1;
    }
    
    //mostrarnos que hay en el tope
    //aprovechamos para usar try-catch, le damos nuestra exception
    //podemos crear exceptions especificas, crearemos una clase para esto
    
    //opcion A)
//    public T peek() //regresa algo tipo T
//    {
//        T resp = null; //es compatible con cualquier tipo que le haymos dado a la T
//        if(!isEmpty())
//            resp = elementos[tope];
//        return resp;
//    }
    public T peek(){
        if(isEmpty())
            throw new ExcepcionColeccionVacia("pila vacia no se puede consultar");
        else //es por claridad
            return elementos[tope];
    }
    
    public T pop(){
        if(isEmpty())
            throw new ExcepcionColeccionVacia("pila vacia no se puede consultar");
        else
        {
            T dato = elementos[tope];
            elementos[tope] = null;
            tope--;
            return dato;
        }
    }
    public void push(T dato){
        // ver si esta lleno, usaremos el lenght porque no sabemos que max usaremos
        if(tope == elementos.length-1 ) //esta lleno
            aumentaCapacidad();
        tope++;
        elementos[tope] = dato;
    }
    private void aumentaCapacidad()
    {
        T[] nuevo = (T[]) new Object[elementos.length*2];
        for(int i = 0; i<= tope; i++ )
            nuevo[i] = elementos[i];
        elementos = nuevo;
    }

    @Override
    public T multipop(int n) {
        int contador; 
        contador = 0;
        if(isEmpty())
            throw new ExcepcionColeccionVacia("pila vacia no se puede consultar");
        else
        {
            
               T dato = elementos[tope];
               elementos[tope] = null;
               tope--;
               return dato;
            
            
            
        }
    }
}
