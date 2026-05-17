
package Main;

import Model.Car;
import Model.Concesionario;
import Model.Van;
import Model.Vehicle;
import People.*;
import java.util.Scanner;
public class ConcessionaireProject {
 
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String id, brand, type, plate, name;
        double precioBase, power, maxSpeed, budget;
        int cylinders, option, year, passengerCapacity, age; 
        boolean slidingDoor;
        boolean askData = true;
        Vehicle vehicles = null;
        Car car = null;
        Van van = null;
        
        //crear concesionario
        Concesionario concesionario = new Concesionario("Motorysa");
        
        Seller seller = new Seller("Carlos");

        Customer c1 = new Customer("Ana",25,20000);
        Customer c2 = new Customer("Luis",32,25000);
        Customer c3 = new Customer("Maria",28,22000);
        Customer c4 = new Customer("Pedro",40,30000);
        Customer c5 = new Customer("Laura",27,18000);
        Customer c6 = new Customer("Sofia",22,15000);
        Customer c7 = new Customer("Miguel",35,27000);
        Customer c8 = new Customer("Valeria",29,26000);

        seller.addCustomer(c1);
        seller.addCustomer(c2);
        seller.addCustomer(c3);
        seller.addCustomer(c4);
        seller.addCustomer(c5);
        seller.addCustomer(c6);
        seller.addCustomer(c7);
        seller.addCustomer(c8);

        concesionario.addSeller(seller);
        
        while(askData){
            
            try{
                System.out.println("\n\nINFORMATION SYSTEM");
                System.out.println("1 Register Car");
                System.out.println("2 Register Van");
                System.out.println("3 Register new customer (max 2)");
                System.out.println("4 Show vehicles");
                System.out.println("5 Show seller and customers");
                System.out.println("6 Sell vehicle");
                System.out.println("7 Modify seller name");
                System.out.println("8 Exit");
                System.out.println("Please enter the desired option:");
                option = scanner.nextInt();
                scanner.nextLine();
                
                switch(option){
                    case 1:
                        System.out.println("Input the Id: ");
                        id = scanner.nextLine();
                
                        System.out.println("Input the car brand: ");
                        brand = scanner.nextLine();
                
                        System.out.println("Year: ");
                        year = scanner.nextInt();
                        scanner.nextLine();
                
                        System.out.println("Input the max speed: ");
                        maxSpeed = scanner.nextDouble();
                        scanner.nextLine();
                
                        System.out.println("Price: ");
                        precioBase = scanner.nextDouble();
                        scanner.nextLine();
                
                        System.out.println("Power: ");
                        power = scanner.nextDouble();
                        scanner.nextLine();
                
                        System.out.println("Type: ");
                        type = scanner.nextLine();
                
                        System.out.println("Number of cylinders: ");
                        cylinders = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Car plate: ");
                        plate = scanner.nextLine();
                        
                        // crear carro 
                        car = new Car(id, brand, year, maxSpeed, precioBase, plate);
                        System.out.println("Car created successfully");
                        
                        car.registrarMotor(power, type, cylinders);
                        // asignarlo al concesionario
                        concesionario.addVehicle(car);
                        break;
                        
                    case 2:
                        
                        System.out.println("Input the Id: ");
                        id = scanner.nextLine();
                
                        System.out.println("Input the car brand: ");
                        brand = scanner.nextLine();
                
                        System.out.println("Year: ");
                        year = scanner.nextInt();
                        scanner.nextLine();
                
                        System.out.println("Input the max speed: ");
                        maxSpeed = scanner.nextDouble();
                        scanner.nextLine();
                
                        System.out.println("Price: ");
                        precioBase = scanner.nextDouble();
                        scanner.nextLine();
                
                        System.out.println("Power: ");
                        power = scanner.nextDouble();
                        scanner.nextLine();
                
                        System.out.println("Type: ");
                        type = scanner.nextLine();
                
                        System.out.println("Number of cylinders: ");
                        cylinders = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Passenger capacity: ");
                        passengerCapacity  = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Does the car have a sliding door? (yes/no): ");
                        String respuesta = scanner.next();

                        slidingDoor = respuesta.equalsIgnoreCase("yes");
                        
                        //Crear Van
                        van = new Van(id, brand, year, maxSpeed, precioBase, passengerCapacity, slidingDoor);
                        System.out.println("Van created successfully");
                        
                        van.registrarMotor(power, type, cylinders);
                        
                        // asignarlo al concesionario
                        concesionario.addVehicle(van);
                        break;
                    
                    case 3:
                        
                        System.out.println("Name: ");
                        name = scanner.nextLine();
                        
                        System.out.println("Age: ");
                        age = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Budget: ");
                        budget = scanner.nextDouble();
                        scanner.nextLine();
                        
                        Customer c = new Customer(name, age, budget);
                        
                        seller.addCustomer(c);
                        break;
                        
                    case 4:
                        
                        String str = concesionario.toString();
                        System.out.println(str);
                        break;
                        
                    case 5:
                        
                        System.out.println(seller);
                        break;
                        
                    case 6:
                        System.out.println("Do you want to sell a Car or a Van?");
                        String typeVehicle = scanner.nextLine();

                        System.out.println("Enter the id of the vehicle to sell:");
                        String idSell = scanner.nextLine();

                        System.out.println("Enter the name of the customer:");
                        String customerName = scanner.nextLine();

                        concesionario.sellVehicleByType(typeVehicle, idSell, customerName, seller);
                        
                        break;
                        
                    case 7:
                        
                        System.out.println("Enter new seller name:");
                        String newName = scanner.nextLine();

                        seller.setName(newName);

                        System.out.println("Seller updated successfully");
                        
                        break;
                        
                        
                    case 8:
                        
                        askData = false;
                        System.out.println("Program completed");
                        break;
                        
                    default:
                        System.out.println("Invalid option");
                        
                    }
                    
                }catch(Exception e){ 
                    System.out.println("There was an error in the input data: " +e.getMessage());
                    System.out.println("Try again\n");
                    scanner.nextLine();
                    }
        }
        scanner.close();   
    
    }
}
