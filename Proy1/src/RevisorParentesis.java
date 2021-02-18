/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rebecaangulorojas
 */
public class RevisorParentesis {
    private String cadenaRevisar;

    public RevisorParentesis() {
    }

    public RevisorParentesis(String cadenaRevisar) {
        this.cadenaRevisar = cadenaRevisar;
    }
    
//    Que los paréntesis estén balanceados significa que cada símbolo de apertura 
//       tiene un símbolo de cierre correspondiente y que los paréntesis están
//       apropiadamente anidados.
    public boolean analisis()
    {
        PilaA <Character> palabra;
        palabra = new PilaA<Character>();
        
        boolean balanceados;
        balanceados = true;
        
        char simbolo;
        int indice;
        indice = 0;
        
        while(indice < cadenaRevisar.length() && balanceados == true)
        {
            simbolo = cadenaRevisar.charAt(indice);
            if( simbolo == '(')
                palabra.push(simbolo);
            else if( simbolo == ')')
                try{
                   palabra.pop(); 
                }catch(Exception e){ //aqui es donde pongo el catch porque aqui pudo suceder error
                    balanceados = false; //no logra sacarlo
                }          
//            if(palabra.isEmpty())
//                balanceados = true;
            indice = indice + 1;
        }
        if(balanceados && palabra.isEmpty()) //si la pila esta vacia entonces esta balanceada
                return balanceados;
            else
                return false;
    }
    
}
