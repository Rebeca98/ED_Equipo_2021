

import java.util.Objects;

public abstract class Camion {
    private String marca;
    private String numMotor;
    private String placas;
    private double costoCamion;
    private boolean disponibilidad;


    public Camion() {
    }
    
    public Camion (String placas){
        this.placas=placas;
    }

    public Camion(String marca, String numMotor, String placas, double costoCamion) {
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
        disponibilidad = true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getPlacas() {
        return placas;
    }

    public double getCostoCamion() {
        return costoCamion;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }
 
    @Override
    public boolean equals(Object obj) {
       Camion aux; 
       aux = (Camion)obj; 
       return this.placas.equals(aux.placas);
    }

    @Override
    public String toString() {
        return "Camion\n" + "marca=" + marca + ", numMotor=" + numMotor + ", placas=" + placas;
    }
    
}
