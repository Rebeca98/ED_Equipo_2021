public class Turismo extends DePasajeros {
    private boolean asientoCama;
    private boolean serviBar;
    
    public Turismo (){
        super ();
    }
    
    public Turismo (String placas) {
        super (placas);
    }

    public Turismo( int totalPasaj, String marca, String numMotor, String placas, double costoCamion, boolean asientoCama, boolean serviBar) {
        super (totalPasaj, marca, numMotor, placas, costoCamion);
        this.asientoCama = asientoCama;
        this.serviBar = serviBar;
    }

    public boolean isAsientoCama() {
        return asientoCama;
    }

    public void setAsientoCama(boolean asientoCama) {
        this.asientoCama = asientoCama;
    }

    public boolean isServiBar() {
        return serviBar;
    }

    public void setServiBar(boolean serviBar) {
        this.serviBar = serviBar;
    }
    
     public double calculaCostoServicio (int kmRec, int numPasajeros) {
        double costoServicio;
                
        costoServicio=((getCostoCamion())*0.0001)/numPasajeros*kmRec;
        //System.out.println(costoServicio);
        
        if (serviBar) {
            costoServicio=costoServicio*1.05;
        }
        if (asientoCama) {
            costoServicio=costoServicio*1.05;
        }
        //System.out.println(costoServicio);

     return costoServicio;
    }    
     
    @Override
    public String toString() {
        return  "Turismo{" + "asientoCama=" + asientoCama + ", serviBar=" + serviBar + '}'+ super.toString();
    }
    
}
