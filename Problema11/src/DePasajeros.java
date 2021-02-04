public abstract class DePasajeros extends Camion  {
    
    private int totalPasaj;

    public DePasajeros() {
        super();
    }
    
    public DePasajeros (String placas) {
        super (placas);
    }

    public DePasajeros(int totalPasaj, String marca, String numMotor, String placas, double costoCamion) {
        super( marca,  numMotor,  placas,  costoCamion);
        this.totalPasaj = totalPasaj;
    }
    
    public int getTotalPasaj() {
        return totalPasaj;
    }

    public void setTotalPasaj(int totalPasaj) {
        this.totalPasaj = totalPasaj;
    }

    public double calculaCostoServicio (int kmRec, int numPasajeros) {
        double costoServicio;
        
        costoServicio=(getCostoCamion()*0.0001)/numPasajeros*kmRec;
        
        return costoServicio;
    }       
            
    @Override
    public String toString() {
        return "DePasajeros\n" + "totalPasaj=" + totalPasaj + super.toString();
    }

}

    
    
    