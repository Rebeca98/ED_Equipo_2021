
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
    
    public boolean revisaErrores(String input) {
        boolean correcto, balanceados; 
        RevisorParentesis revisor;
        revisor = new RevisorParentesis(input);
        correcto = true;
        
        //si no estan balanceados los paréntesis
        balanceados = revisor.analisis();
        if(balanceados == false)
            System.out.println("Error, no estan balanceados paréntesis");

        //Si el primer o ultimo caracter son operadores, no tiene operando: error
        return true; //aun no hacemos nada
    }
    
    public String[] agregarCad(String cadena){
        String[] arr = new String[cadena.length()];
        
        StringTokenizer tokens = new StringTokenizer(cadena," ");
        int nDatos=tokens.countTokens();
        
        int i=0;
        while(tokens.hasMoreTokens()){
            String str=tokens.nextToken(); //
            arr[i] = str;

            System.out.print(arr[i]);
            i++;
        }
        return arr;
        
    }
//    
//    public static String[] agregarCad(String cadena){
//        String[] arr;
//        String aux;
//        int cont=cadena.length();
//        int j=0;
//        
//        arr= new String[cont];
//        for(int i = 0; i < cont; i++){
//            aux = Character.toString(cadena.charAt(i)).trim();
//            //j=i;
//            try{
//            while(!aux.equals("+") || !aux.equals("-") ||!aux.equals("*") ||!aux.equals("/")){
//                aux = Character.toString(cadena.charAt(j)).trim();
//                arr[i]+=""+cadena.charAt(j);
//                j++;
//            }
//            }
//            catch(Exception e){
//                System.out.println("AQUÍ");
//            }
//            arr[i] = aux;
//        }
// 
//        return arr;
//    }
    public String[] ingresaCadena(String cadena)
    {
        //suponiendo que no hay errores
        String cad[];
        cad = new String[cadena.length()];
        int i; 
        String aux;
        for(i = 0; i < cadena.length(); i++)
        {
            aux = Character.toString(cadena.charAt(i)).trim();
            cad[i] = aux;
        }
        return cad;
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
        if(Operador(cadena).equals("+") && Operador(elemPila).equals("*")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("+") && Operador(elemPila).equals("/")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("-") && Operador(elemPila).equals("*")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("-") && Operador(elemPila).equals("/")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("+") && Operador(elemPila).equals("+")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("-") && Operador(elemPila).equals("-")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("*") && Operador(elemPila).equals("*")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("/") && Operador(elemPila).equals("*")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("*") && Operador(elemPila).equals("/")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("/") && Operador(elemPila).equals("*")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("+") && Operador(elemPila).equals("-")) {
			mayorJerarquia = false;
		}
		else if(Operador(cadena).equals("-") && Operador(elemPila).equals("+")) {
			mayorJerarquia = false;
		}
		else {
			mayorJerarquia = true;
		}
        return mayorJerarquia;
    }
    public String convierteAPostfijo(String[] cad){
        String resultado;
        PilaA<String> pila;
        pila = new PilaA();
        int i = 0; 
        resultado = "";
        //usaremos una pila para determinar jerarquia
        while(i < cad.length) {
            if(Operador(cad[i]).equals("num")){
                resultado = resultado + cad[i]; //guarda el numero en resultado
                resultado += "";
            }  
            else{
                //caso de los paréntesis
                if(Operador(cad[i]).equals("(")) 
                    pila.push(cad[i]); //lo mete a la pila
                
                else if(Operador(cad[i]).equals(")")) {
                    while(!pila.peek().equals("(")) {
                        resultado = resultado + pila.pop(); //solo se pasa los signos dentro de parentesis
                        resultado += "";
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
                            resultado += "";
                            if(!pila.isEmpty()) { //ahora que tenemos * en pila
                                while(!JerarquiaOperaciones(cad[i],pila.peek())) { //mientras no esten ordenadas, division es mejor que *
                                        resultado = resultado + pila.pop(); //quitamos * de pila y agregamos a resultado
                                        resultado += "";
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
            resultado += "";
        }
        return resultado.trim();
    }
    
    
    //realizamos operaciones binarias
    public double resolverPosfijo(String cad[]){
        PilaA<Double> pila;
        pila = new PilaA();
        double num1, num2, num;
        num = 0;
        double operacion = 0;
        for(int i = 0; i < cad.length; i ++) {
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
                operacion = num1/num2;
                if(num2 == 0)
                    System.out.println("Error");
                pila.push(operacion);
            }
            else {
                num = Double.parseDouble(cad[i]);
                pila.push(num);
            }
        }  
       return operacion; 
    } 
}//finClase
