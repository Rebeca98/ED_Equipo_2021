public class Escolar extends DePasajeros {
    private boolean lugarProyecto;

    public Escolar() {
    }

    public Escolar(boolean lugarProyecto, int totalPasaj, String marca, String numMotor, String placas, double costoCamion) {
        super(totalPasaj, marca, numMotor, placas, costoCamion);
        this.lugarProyecto=lugarProyecto;
    }

    public boolean isLugarProyecto() {
        return lugarProyecto;
    }

    public void setLugarProyecto(boolean lugarProyecto) {
        this.lugarProyecto = lugarProyecto;
    }
    
    public double calculaCostoServicio (int kmRec, int numPasajeros) {
        double costoServicio;
        
        costoServicio=((getCostoCamion()*0.0001)/numPasajeros*kmRec)*250;
        
    return costoServicio;
    }     
    
    
    
    
}
