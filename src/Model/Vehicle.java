
package Model;

import Main.Validation;

public abstract class Vehicle {
    
    private String id;
    private String brand;
    private int year;
    private double maxSpeed;
    private final double precioBase;
    private double precioContado;
    private double precioCredito;
    private Motor motor;
    
    public Vehicle(){
        this.id = "";
        this.brand = "";
        this.year = 0;
        this.maxSpeed = 0.0;
        this.precioBase = 0.0;
        this.precioContado = 0.0;
        this.precioCredito = 0.0;
        this.motor = new Motor();
    }
    
    public Vehicle(String id, String brand, int year, double maxSpeed, double precioBase){
        
        this.setId(id);
        this.setBrand(brand);
        this.setYear(year);
        this.setMaxSpeed(maxSpeed);
        
        if(precioBase<0){
            throw new IllegalArgumentException("The car price is not valid");
        }
        else{
            this.precioBase = precioBase;
        }
        
        this.motor = new Motor();
        this.setPrecioContado();
        this.setPrecioCredito();
        
    }
    
    public abstract String getVehicleType();
    
    public final void setId(String id){
        Validation.validateStringNumbers(id, "Id id");
        this.id = id;
        
    }
    
    public final void setBrand(String brand){
        Validation.validateString(brand, "Brand brand");
        this.brand = brand;
    }
    
    public final void setYear(int year){
        Validation.validatePositiveInt(year, "Year year");
        this.year = year;
    }
    
    public final void setMaxSpeed(double maxSpeed){
        Validation.validatePositiveNumber(maxSpeed, "MaxSpeed maxSpeed");
        this.maxSpeed = maxSpeed;
    }
    
    public void registrarMotor(double power, String type, int cylinders){
        this.motor = new Motor(power, type, cylinders);
    }
  
    public final void setPrecioContado(){
        double result = precioBase - (precioBase*0.1);
        this.precioContado = result;
    }
   
    public final void setPrecioCredito(){
        double result = precioBase + (precioBase*0.15);
        this.precioCredito = result;
    }
    
    public String getId(){
        return this.id;     
    }
    
    public String getBrand(){
        return this.brand;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public double getMaxSpeed(){
        return this.maxSpeed;
    }
    
    public double getPrecioBase(){
        return this.precioBase;
    }
    
    public Motor getMotor(){
    return this.motor;
    }
    
    public double getPrecioContado(){
        return this.precioContado;
    }
    public double getPrecioCredito(){
        return this.precioCredito;
    }
    
    @Override
    public String toString(){
        String str;
        str = "\nBrand: " + this.brand + "\nId: " + this.id + "\nYear: " +
                this.year + "\nMax speed: " + this.maxSpeed + "\nPrice: " + this.precioBase +
                "\nPrecio contado: " + this.precioContado + "\n Credit price: " + this.precioCredito
                + "\nMotor:\n" + motor.toString();
        return str;
    }  
    
}
