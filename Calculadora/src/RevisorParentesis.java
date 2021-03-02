/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * <pre>
 * 
 * Clase RevisorParentesis
 * 
 * Esta clase revisa que las expresiones que se introduzcan en la calculadora, sean correctas y estén balanceadas en cuanto a paréntesis
 * 
 * </pre>
 * @author Benjamín Goñi, Fernando Medina, Marcos Medina, Francisca Flores Rosas, Mariana Luna, Rebeca Angulo Rojas
 * @version 1.0
 */

public class RevisorParentesis {
    private String cadenaRevisar;

    public RevisorParentesis() {
    }

    public RevisorParentesis(String cadenaRevisar) {
        this.cadenaRevisar = cadenaRevisar;
    }
    
/**  Que los paréntesis estén balanceados significa que cada símbolo de apertura 
*    tiene un símbolo de cierre correspondiente y que los paréntesis están
*    apropiadamente anidados. 
* 
* Este método analiza las cadenas que se introducen
*
* @return <ul>
*          <li> true: los paréntesis sí están balanceados </li>
*          <li> false: los paréntesis no están balanceados </li>
*       </ul>
*/
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
                }catch(Exception e){ 
                    balanceados = false; 
                }          
            indice = indice + 1;
        }
        if(balanceados && palabra.isEmpty())
                return balanceados;
            else
                return false;
    }
    
}
