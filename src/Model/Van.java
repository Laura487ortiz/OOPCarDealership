
package Model;

import Main.Validation;

public class Van extends Vehicle{
    //Attributes
    private int passengerCapacity;
    private boolean slidingDoor; 
    
    //Default Constructor 
    
    public Van(){
        super(); //llama al constructor vacío de Vehicle, no es necesario llamarlo
        this.passengerCapacity = 0;
        this.slidingDoor = true;
    
        System.out.println("Default constructor Van called");
    }
    
    //Overloaded constructor
    public Van(String id, String brand, int year, double maxSpeed,
           double precioBase, int passengerCapacity, boolean slidingDoor) {

    super(id, brand, year, maxSpeed, precioBase); 

            this.setPassengerCapacity(passengerCapacity);
            this.setSlidingDoor(slidingDoor);
    }
    
    //Set methods
    public final void setPassengerCapacity(int passengerCapacity){
        Validation.validatePositiveInt(passengerCapacity, "Passenger capacity");
        this.passengerCapacity = passengerCapacity;
    }
    
    public final void setSlidingDoor(boolean slidingDoor){
        
            this.slidingDoor = slidingDoor;
    }
    //Get methods 
    
    public int getPassengerCapacity(){
        return this.passengerCapacity;
    }
    
    public boolean getSlidingDoor(){
        return this.slidingDoor;
    }
  
    //To String
    
    @Override
    public String getVehicleType(){
    return "Van";
    }

    @Override
    public String toString(){
        String str = "\nType: " + getVehicleType()+
                super.toString() + 
     
                "\nPassenger capacity:\n" + this.passengerCapacity + "\nSliding door:\n" + this.slidingDoor;
        return (str);
    }
    
    public String openSlidingDoor(){
        if(slidingDoor){
            return "\nSliding door opened.";
        
        }else{
            return "\nThis van does not have a sliding door.";
        }
    }
    
}  

