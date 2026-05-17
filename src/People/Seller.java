
package People;

import Main.Validation;
import java.util.ArrayList;


public class Seller {
    
    private String name;
    private ArrayList<Customer> customers;
    
    public Seller(){
        this.name = "Laura";
        this.customers = new ArrayList<>();
    }
    
    public Seller(String name){
        setName(name);
        this.customers =  new ArrayList<>();
    }
    
    public final void setName(String name){
        Validation.validateName(name, "Name name");
        this.name = name;
    }
    
    public void addCustomer(Customer c){
        if(c == null){
            throw new IllegalArgumentException("Customer cannot be null");
        }
        
        if(customers.size() >= 10){
            System.out.println("Customer list is full (max 10)");
            return;
        }
        
        customers.add(c);
    }
    
    public Customer findCustomer(String name){

        for(Customer c : customers){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }

        return null;
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    @Override
    public String toString(){
        String str = "Seller: " + name + "\nCustomers:\n";
        
        if(customers.isEmpty()){
            str += "No customers\n";
        }else{
            for(Customer c: customers){
                str += c.toString() + "\n";
            }
        }
        
        return str;
    }
    

}
