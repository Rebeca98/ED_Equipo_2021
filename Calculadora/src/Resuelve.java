
import java.util.ArrayList;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <pre>
 * 
 * Clase Resuelve
 * 
 * Esta clase contiene los diversos métodos necesarios para el funcionamiento de la calculadora
 * 
 * </pre>
 * @author Benjamín Goñi, Fernando Medina, Marcos Medina, Francisca Flores Rosas, Mariana Luna, Rebeca Angulo Rojas
 * @version 1.0
 */
public class Resuelve {

    public Resuelve() {
    }
     /**
      * Este método analiza si existe algún error de sintaxis en la expresión que se introduce (antes de que ésta se convierta a postfjo)
      * 
      * @param input: recibe una cadena de String
      * @return <ul>
      *         <li> true: la expresión no tiene errores de sintaxis. </li>
      *         <li> false: Si el primer o ultimo caracter son operadores, no tiene operando: error </li>
      *     </ul>
      */
     public static boolean revisaErrores(String input) {
        boolean balanceados; 
        RevisorParentesis revisor;
        revisor = new RevisorParentesis(input);
        int f = input.length()-1;
        int i;
        int contoper;
        contoper = 0;
        int linoper;
        linoper = 0;
        
        balanceados = revisor.analisis();
        
        if(balanceados == true ){
            if(input.charAt(1) == '+' || input.charAt(1) == '-' || input.charAt(1) == '*' || input.charAt(1) == '/' || input.charAt(f - 1) == '+' || input.charAt(f - 1) == '-' || input.charAt(f - 1) == '*' || input.charAt(f - 1) == '/' ){
                balanceados = false;   
            }
            if(balanceados == true){
                for(i = 0; i < f; i++){
                    if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                        contoper++;
                    }
                }
                
                for(i = 0; i < f; i++){
                    
                    if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){                                              
                        linoper++;
                        if(input.charAt(i) == ')' || input.charAt(i) == '(' ){
                            if(i != 1 && i != f - 1){
                                if(input.charAt(i) == ')' && Character.isDigit(input.charAt(i + 2))){
                                    balanceados = false;    
                                }
                                else if(input.charAt(i) == '(' && Character.isDigit(input.charAt(i - 2))){
                                    balanceados = false;                
                                }                 
                            }
                        }    
                            
                        if(linoper < contoper && balanceados){
                            if(input.charAt(i + 3) == '+' || input.charAt(i + 3) == '-' || input.charAt(i + 3) == '*' || input.charAt(i + 3) == '/' ){
                                balanceados = false;
                            }  
                        }
                    }
                }               
            }      
        }
        return balanceados; 
    }
    
     /**
      * Este método convierte una cadena de String revisada a un arreglo en el que cada casilla existe un componente de la expresión, el StringTokenizer diferencía los componentes
      * @param cadena: recibe un String
      * @return <ul>
      *         <li> arr: la expresión separada por casillas. </li>
      *     </ul>
      */
    public static String[] agregarCad(String cadena){
        String[] arr = new String[cadena.length()];
        
        StringTokenizer tokens = new StringTokenizer(cadena," ");
  
        int i=0;
        while(tokens.hasMoreTokens()){
            String str=tokens.nextToken();
            arr[i] = str;
            i++;
        }
        return arr;
        
    }

     /**
      * Este método analiza los componentes y determina qué operador se utiliza
      * 
      * @param cad: recibe un String
      * 
      * @return <ul>
      *         <li> operadorActual </li>
      *     </ul>
      */
    public static String operador(String cad) { //método útil para hacer estas preguntas en otros métodos
        String operadorActual;
        switch(cad) {
            case "+":
                    operadorActual = "+";
                    break;
            case "-":
                    operadorActual = "-";
                    break;
            case "*":
                    operadorActual = "*";
                    break;
            case "/":
                    operadorActual = "/";
                    break;
            case "(":
                    operadorActual = "(";
                    break;
            case ")":
                    operadorActual = ")";
                    break;
            default:
                    operadorActual = "num";
                    break;
	}
        return operadorActual;
    }
    
     /**
      * Este método analiza y asigna la prioridad de operadores en la expresión
      * 
      * @param c: recibe un String
      * 
      * @return <ul>
      *         <li> la prioridad del operador </li>
      *     </ul>
      */
    public static int getPrioridad(String c){
        int ans = 0; 
        switch(c){
            case ("+"): 
                ans = 1; 
                break; 
            case("-"): 
                ans = 1; 
                break;
            case("*"): 
                ans = 2; 
                break; 
            case("/"): 
                ans = 2; 
                break;
        }
        return ans; 
    }
    
     /**
      * Este método analiza la jerarquía tomando en cuenta la prioridad de cada operador que compone
      * 
      * @param cadena: recibe un String
      * @param elemPila: recibe un String con elementos de la pila
      * 
      * @return <ul>
      *         <li> false: el elemento de la pila dada que tenga menor jerarquía que el otro </li>
      *         <li> true: el elemento de la pila dada que tenga mayor jerarquía que el otro </li>
      *     </ul>
      */
    public static  boolean jerarquiaOperaciones(String cadena, String elemPila) {
        boolean mayorJerarquia;
        if( getPrioridad(operador(cadena)) <= getPrioridad(operador(elemPila))) {
            mayorJerarquia = false;
        }else {
		mayorJerarquia = true;
	}   		
        return mayorJerarquia;
    }
    
     /**
      * Este método convierte a postfijo la expresión, analiza con una cadena para determinar la jeraquía y divide las posibilidades en casos específicos para después resolverlos
      * 
      * @param cad: recibe un arreglo de String
      * 
      * @return <ul>
      *         <li> resultado: la expresión que desea evaluarse </li>
      *     </ul>
      */
    public static String convierteAPostfijo(String[] cad){
        String resultado;
        PilaA<String> pila;
        pila = new PilaA();
        int i = 0; 
        resultado = " ";
        while(!(cad[i] == null)) {  
            if(operador(cad[i]).equals("num")){
                resultado = resultado + cad[i]; 
                resultado += " ";
            }  
            else{
 
                if(operador(cad[i]).equals("(")) 
                    pila.push(cad[i]); 
                
                else if(operador(cad[i]).equals(")")) {
                    while(!pila.peek().equals("(")) {
                        resultado = resultado + pila.pop();
                        resultado += " ";
                    }
                    pila.pop(); 
		}
                else { 
                    if(!pila.isEmpty()) {
                        if(jerarquiaOperaciones(cad[i],pila.peek())) {
                                pila.push(cad[i]);
                        }
                        else { 
                            resultado = resultado + pila.pop(); 
                            resultado += " ";
                            if(!pila.isEmpty()) { 
                                while(!pila.isEmpty() && !jerarquiaOperaciones(cad[i],pila.peek())) { 
                                        resultado = resultado + pila.pop(); 
                                        resultado += " ";
                                }
                            }
                            pila.push(cad[i]);
                        }
                    }
                    else { 
                        pila.push(cad[i]);
                    }
                }
            }
            i++;
        }
        while(!pila.isEmpty()) {
            resultado = resultado + pila.pop(); 
            resultado += " ";
        }
        return resultado;
    }
    
    
     /**
      * Este método resuelve la expresión ya convertida a postfija
      * 
      * @param cad: recibe un String
      * @return <ul>
      *         <li> operacion: el resultado final de la expresión </li>
      *     </ul>
      */
    public static double resolverPosfijo(String cad[]){
        PilaA<Double> pila;
        pila = new PilaA();
        double num1, num2, num;
        num = 0;
        double operacion = 0;
        int i = 0;
        while(!(cad[i] == null)){   
            if(cad[i].equals("+")) {
                num1 = pila.pop();
                num2 = pila.pop();
                operacion = num1 + num2;
                pila.push( operacion);
            }
            else if(cad[i].equals("-")) {
                num1 = pila.pop();
                num2 = pila.pop();
                operacion = num2 - num1;
                pila.push(operacion);
                
            }
            else if(cad[i].equals("*")){
                num1 = pila.pop();
                num2 = pila.pop();
                operacion = num1*num2;
                pila.push(operacion);
            }
            
            else if(cad[i].equals("/")){
                num1 = pila.pop();
                num2 = pila.pop();
                
                try{
                    operacion = num2/num1;    
                }
                catch(Exception e ){
                    System.out.println("Math Error");
                    
                }                 
                pila.push(operacion);
            }
            else {
                num = Double.parseDouble(cad[i]);
                pila.push(num);
            }
            i++;
        }  
       return operacion; 
    } 
}