package Model;
import Main.*;
public class Car extends Vehicle {
    
    //Attributes
    private String plate; 
    
    //Default Constructor 
    
    public Car(){
        super(); 
        this.plate = " ";
    
        System.out.println("Default constructor Car called");
    }
    
    //Overloaded constructor
    public Car(String id, String brand, int year, double maxSpeed, double precioBase, String plate){

            super(id, brand, year, maxSpeed, precioBase); 

            this.setPlate(plate);
    }
    
    //Set methods
    public final void setPlate(String plate){
        Validation.validateStringNumbers(plate, "Plate plate");
        this.plate = plate;
    }
    //Get methods 
    
    public String getPlate(){
        return this.plate;
    }
  
    //To String
    @Override
    public String getVehicleType(){
    return "Car";
}
    @Override
    public String toString(){
        String str = "\nType: " + getVehicleType()+
                super.toString() + 
     
                "\nPlate:\n" + this.plate;
        return (str);
    }
    
    public String securityMode(){
        return "\nSecurity mode activated for car with plate" + this.plate;
    }
    
}  

