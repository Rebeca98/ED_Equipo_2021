/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class EmpTransp {
    private String nombreEmp;
    private int totalCamiones;
    private Camion [] camiones;
    private final int MAX=100; // Supuesto

    public EmpTransp() {
        camiones = new Camion [MAX];
        totalCamiones=0;
    }

    public EmpTransp(String nombreEmp) {
        this();
        this.nombreEmp = nombreEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }
    
    //Alta camion Escolar
    public boolean altaCamion (boolean lugarProyecto, int totalPasaj, String marca, String numMotor, String placas, double costoCamion){
        boolean resp=false;
        
        if (totalCamiones<MAX){
            camiones[totalCamiones]=new Escolar (lugarProyecto, totalPasaj, marca, numMotor, placas, costoCamion);
            totalCamiones++;
            resp=true;
        }
        
        return resp;
    }    

    //Alta camion Turismo 
    public boolean altaCamion (int totalPasaj, String marca, String numMotor, String placas, double costoCamion, boolean asientoCama, boolean serviBar){
         boolean resp=false;
        
        if (totalCamiones<MAX){
              camiones[totalCamiones]=new Turismo (totalPasaj, marca, numMotor, placas, costoCamion, asientoCama, serviBar);
              totalCamiones++;
              resp=true;
         }
         return resp;
    }
    
    public int buscaCamion (String placas) {
        int i=0, pos=0;
        boolean resp=false;
        
        while (i<totalCamiones && resp==false) {
            if (placas.equals(camiones[i].getPlacas())) {
                pos=i;
                resp=true;
            }
            i++; 
        }

        if (i==totalCamiones-1 && !placas.equals(camiones[i].getPlacas())){
            i=-1;
        }
        
      return pos;  
    }
    
    // 1) Algo pasa que no calcula el costo de servicio correctamente y arroja siempre cero
    public String rentaCamionTurista(int cantPasajeros, int km){
        StringBuilder cad; 
        cad = new StringBuilder();
        int i; 
        
        for(i = 0; i < totalCamiones; i++){
            if(camiones[i] instanceof Turismo){
                //camiones[i].setDisponibilidad(false);
                cad = cad.append(camiones[i].toString());
                cad = cad.append("\nCosto de servicio: "+((Turismo)camiones[i]).calculaCostoServicio(km, cantPasajeros));
            }
        }
        return cad.toString();
    }
    
    // 2)
    public boolean rentaEscolar(int ninos){
        boolean res= false;
        int cont=0;
        int i=0;
        
        while(i<totalCamiones && !res){
            cont+=((DePasajeros)camiones[i]).getTotalPasaj();
            if(cont>=ninos){
                res=true;
                //camiones[i].setDisponibilidad(false);
            }
            i++;
        }
        
        return res;
    }
   
    // 3 
    public String disponibilidadCamion(String placas) {
        int i = 0;
        boolean indicador = false;
        String tipo = "ERROR";
        
        while(i < totalCamiones && indicador == false) {
            if(camiones[i].getPlacas().equals(placas)) {
                if(camiones[i].getDisponibilidad() == true){
                    if(camiones[i] instanceof Turismo) {   
                        tipo = "Turismo";
                    }
                    else {
                        tipo = "Escolar";
                    }                  
                }
                else {
                    tipo = "No disponible";
                }
                indicador = true;
            }
            i++;
        }
        
        return tipo;
    }
    
    // 4)
    public String imprimeCamionEscolar(){
        int i;
        StringBuilder cad; 
        cad = new StringBuilder();
        
        for( i = 0; i < totalCamiones; i++){
            if(camiones[i] instanceof Escolar){
                if(((Escolar)camiones[i]).getTotalPasaj() > 20 && ((Escolar)camiones[i]).isLugarProyecto() == true){
                    cad = cad.append("\nNúmero de placas: "+ camiones[i].getPlacas());
                }
            }
        }
        return cad.toString();
    }

    
    // 5) 
    public int totalCamionesMarca (String marca, double costoServicio, int kmRec, int numPasajeros) {
        int totalCamMarca=0;
        
        for (int i=0; i<totalCamiones; i++) {
            if (camiones [i] instanceof Turismo && camiones[i].getMarca().equals(marca)) {
                if (((Turismo)camiones [i]).isServiBar()) {
                    if (((Turismo)camiones[i]).calculaCostoServicio(kmRec, numPasajeros)<costoServicio){
                        totalCamMarca++;
                    }
                }
            }
        }
        return totalCamMarca;
    }
    
}

