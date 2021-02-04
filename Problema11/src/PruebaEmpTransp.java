/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class PruebaEmpTransp {

    public static void main(String[] args) {
        EmpTransp e= new EmpTransp("El rápido");
        
        System.out.println(e.altaCamion(true, 15, "Mercedes Benz", "001", "AAA000", 12000));
        System.out.println(e.altaCamion(40, "Renault", "002", "BBB000", 16000, true, true));
        System.out.println(e.altaCamion(true, 45, "Volvo", "003", "CCC000", 16000));
        System.out.println(e.altaCamion(50, "Renault", "004", "DDD000", 18000, true, false));
        System.out.println(e.altaCamion(true, 30, "Mercedes Benz", "005", "XXX000", 12000));
        System.out.println(e.altaCamion(40, "Renault", "006", "YYY000", 15000, false, true));
        System.out.println(e.altaCamion(40, "Renault", "007", "ZZZ000", 13000, false, false));
        
        System.out.println("\n"+e.rentaCamionTurista(35, 350));
        
        System.out.println("\n"+e.rentaEscolar(150));
        System.out.println(e.rentaEscolar(1200));
        
        System.out.println("\n"+e.disponibilidadCamion("SSS000"));
        System.out.println(e.disponibilidadCamion("XXX000"));
        
        System.out.println("\n"+e.imprimeCamionEscolar());
    }
    
}
