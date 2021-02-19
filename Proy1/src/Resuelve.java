
import java.util.ArrayList;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rebecaangulorojas
 */
public class Resuelve {

    public Resuelve() {
    }
    
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
        
        
        //si no estan balanceados los paréntesis
        balanceados = revisor.analisis();
        
        if(balanceados == true ){
            if(input.charAt(1) == '+' || input.charAt(1) == '-' || input.charAt(1) == '*' || input.charAt(1) == '/' || input.charAt(0) == '.' || input.charAt(f - 1) == '+' || input.charAt(f - 1) == '-' || input.charAt(f - 1) == '*' || input.charAt(f - 1) == '/' || input.charAt(f) == '.'){
                balanceados = false;   
            }
            if(balanceados == true){
                for(i = 0; i < f; i++){
                    if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '.'){
                        contoper++;
                    }
                }
                
                for(i = 0; i < f; i++){
                    
                    if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '.' ){
                        linoper++;
                        if(input.charAt(i + 1) == '.'){
                            balanceados = false;
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

        //Si el primer o ultimo caracter son operadores, no tiene operando: error
        return balanceados; //aun no hacemos nada
    }
    
    public String[] agregarCad(String cadena){
        String[] arr = new String[cadena.length()];
        
        StringTokenizer tokens = new StringTokenizer(cadena," ");
  
        int i=0;
        while(tokens.hasMoreTokens()){
            String str=tokens.nextToken(); //
            arr[i] = str;
            i++;
        }
        return arr;
        
    }

    
    
    public String Operador(String cad) { //método útil para hacer estas preguntas en otros métodos
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
    
    
    public  boolean JerarquiaOperaciones(String cadena, String elemPila) {
        boolean mayorJerarquia;
        //nos preguntamos si el simbolo de la cadena tiene mayor jerarquia que el que esta en el tope de la pila
        if( getPrioridad(Operador(cadena)) <= getPrioridad(Operador(elemPila))) {
            mayorJerarquia = false;
        }else {
		mayorJerarquia = true;
	}   		
        return mayorJerarquia;
    }
    
    public String convierteAPostfijo(String[] cad){
        String resultado;
        PilaA<String> pila;
        pila = new PilaA();
        int i = 0; 
        resultado = " ";
        //usaremos una pila para determinar jerarquia
        while(!(cad[i] == null)) { //while(i < cad.length) 
            if(Operador(cad[i]).equals("num")){
                resultado = resultado + cad[i]; //guarda el numero en resultado
                resultado += " ";
            }  
            else{
                //caso de los paréntesis
                if(Operador(cad[i]).equals("(")) 
                    pila.push(cad[i]); //lo mete a la pila
                
                else if(Operador(cad[i]).equals(")")) {
                    while(!pila.peek().equals("(")) {
                        resultado = resultado + pila.pop(); //solo se pasa los signos dentro de parentesis
                        resultado += " ";
                    }//termina while
                    pila.pop(); //eliminamos el '(', se vacia la pila
		}
                else { //caso jerarquia operaciones(6+3)+2*3/1
                    if(!pila.isEmpty()) {
                        if(JerarquiaOperaciones(cad[i],pila.peek())) { //como es verdad entonces agregamos + a pila
                                pila.push(cad[i]);
                        }
                        else { //esto sucederá porque * tiene más jerarquia que +
                            resultado = resultado + pila.pop(); //agregamos + al resultado y quitamos + de pila
                            resultado += " ";
                            if(!pila.isEmpty()) { //ahora que tenemos * en pila
                                while(!JerarquiaOperaciones(cad[i],pila.peek())) { //mientras no esten ordenadas, division es mejor que *
                                        resultado = resultado + pila.pop(); //quitamos * de pila y agregamos a resultado
                                        resultado += " ";
                                }
                            }
                            pila.push(cad[i]); //finalmente agregamos * a pila //despues agregamos / a pila
                        }
                    }
                    else { //si la pila esta vacia
                        pila.push(cad[i]);
                    }
                }
            }
            i++;
        }//termine while
        while(!pila.isEmpty()) {
            resultado = resultado + pila.pop(); //agregamos la division 
            resultado += " ";
        }
        return resultado;
    }
    
    
    //realizamos operaciones binarias
    public double resolverPosfijo(String cad[]){
        PilaA<Double> pila;
        pila = new PilaA();
        double num1, num2, num;
        num = 0;
        double operacion = 0;
        int i = 0;
        while(!(cad[i] == null)){   
//        for(int i = 0; i < 3; i ++){ //hay que parchar esto
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
}//finClase
