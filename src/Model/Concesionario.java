
package Model;

import java.util.ArrayList;
import People.*;


public class Concesionario {
    
    private final String nombre;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Seller> sellers;
    
    public Concesionario(){
        this.nombre= "Motorysa";
        this.vehicles = new ArrayList <>();
        this.sellers = new ArrayList<>();
    }
    
    public Concesionario (String nombre){
        
        this.vehicles = new ArrayList<>();
        this.sellers = new ArrayList<>();
        
        if(nombre==null||nombre.isBlank()||!nombre.matches("[a-z A-Z]+")){
            throw new IllegalArgumentException("Concessionaire is not valid");
        }else{
            this.nombre = nombre;
        }
    }
    
    public void addVehicle(Vehicle v){
    this.vehicles.add(v);
    }
    
    public void addSeller(Seller s){
        this.sellers.add(s);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }
    
    public ArrayList<Seller> getSellers(){
        return sellers;
    }
    
    public void sellVehicleByType(String type, String id, String customerName, Seller seller){

        Customer buyer = seller.findCustomer(customerName);

        if(buyer == null){
            System.out.println("Customer not found");
            return;
        }

        for(int i = 0; i < vehicles.size(); i++){

            Vehicle v = vehicles.get(i);

            if(v.getVehicleType().equalsIgnoreCase(type) 
            && v.getId().equalsIgnoreCase(id)){

                buyer.addVehicle(v);

                System.out.println("The " + v.getVehicleType() +
                        " with Id " + v.getId() +
                        " has been sold successfully to " + buyer.getName());
                
                System.out.println(buyer);

                vehicles.remove(i);
                return;
            }
        }

        System.out.println("Vehicle not found");
    }
    
    public void showVehiclesByType(String type){

        boolean found = false;

        for(Vehicle v : vehicles){

            if(v.getVehicleType().equalsIgnoreCase(type)){
                System.out.println("Id: " + v.getId() +
                                " Brand: " + v.getBrand() +
                                " Year: " + v.getYear());
                found = true;
            }
        }

        if(!found){
            System.out.println("No vehicles of type " + type + " available.");
        }
    }
  
    
    @Override
    public String toString() {
        String str = "Concesionario:\n";

        // Vehicles
        str += "\nVehicles:\n";
        boolean hayVehicles = false;

        for (Vehicle v : vehicles) {
            if (v != null) {
                str += v.toString() + "\n";
                hayVehicles = true;
            }
        }

        if (!hayVehicles) {
            str += "No vehicles available\n";
        }

        return str;
    }

}
