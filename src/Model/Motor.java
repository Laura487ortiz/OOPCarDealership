package Model;

import Main.Validation;

public class Motor {
    
    private double power;
    private String type;
    private int cylinders;
    
    
    public Motor(){
        this.power = 0.0;
        this.type = "unknown";
        this.cylinders = 0;
    }
    
    public Motor(double power, String type, int cylinders){
        this.setPower(power);
        this.setType(type);
        this.setCylinders(cylinders);
    }
    
    public final void setPower(double power){
        Validation.validatePositiveNumber(power, "Power power");
        this.power = power;
    }
    
    public final void setType(String type){
        Validation.validateString(type, "Type type");
        this.type = type;
    }
    
    public final void setCylinders(int cylinders){
        Validation.validatePositiveNumber(cylinders, "Cylinders cylinders");
        this.cylinders = cylinders;
    }
    
    public double getPower(){
        
        return this.power;
    }
    
    public String getType(){
        
        return this.type;
    }
    
    public int getCylinders(){
        
        return this.cylinders;
    }
    
    @Override
    
    public String toString(){
        String str = "Power: "+ this.power+ "\nType: "+this.type+"\nCylinders: "+this.cylinders; 
        return (str);
    }
    
}
