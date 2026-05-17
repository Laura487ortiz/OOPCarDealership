
package People;
import Main.Validation;
import Model.*;

public class Customer {
    
    private String name;
    private int age;
    private double budget;
    private Vehicle vehicle;
    
    public Customer(){
        this.name = "unknown";
        this.age = 0;
        this.budget = 0.0;
        this.vehicle = new Car();
    }
    
    public Customer(String name, int age, double budget){
        
        this.setName(name);
        this.setAge(age);
        this.setBudget(budget);
    }
    
    public final void setName(String name){
        Validation.validateName(name, "Name name");
        this.name = name;
    }
    
    public final void setAge(int age){
        Validation.validateAge(age);
        this.age = age;
        
    }
    
    protected void setBudget(double budget){
        Validation.validatePositiveNumber(budget, "Budget budget");
        this.budget = budget;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public double getBudget(){
        return this.budget;
    }
    
    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    
    @Override
   
    public String toString(){
        String str = "Customer: " + this.name +
                     "\nAge: " + this.age +
                     "\nBudget: " + this.budget;
        
        if(this.vehicle != null){
            str += "\nVehicle selected: " + this.vehicle.toString();
            
            if(this.vehicle instanceof Car){
                Car temp = (Car) this.vehicle;
                str += temp.securityMode();
            }
            else if(this.vehicle instanceof Van){
                Van temp = (Van) this.vehicle;
                str += temp.openSlidingDoor();
            }
        }
        
        return str;
    }
   
    
}
