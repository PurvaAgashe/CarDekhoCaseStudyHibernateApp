package com.jspiders.Hibernate.Dao;
import java.util.Scanner;
import com.jspiders.Hibernate.Dao.CarOperation1;

public class CarDekhoMenu1 {
	private static CarOperation1 carOperation1 = new CarOperation1();
	private static boolean loop=true;

	  
	public static void main(String[] args) {
		while (loop==true) {
			car_menu();
		}
	
	}


	private static void car_menu() {
		
		Scanner obj=new Scanner(System.in);
		System.out.println("===========MENU==========="
	              + "1. Add car details"
	              + "2. Search car details"
	              + "3. update car details"
	              + "4. Delete car details"
	              
	              + "5. show details"
	              + "6.exit");
		System.out.println("enter your input");
		int input=obj.nextInt();
		switch (input) {
		case 1: System.out.println("======how many car do you want to add? ======");
		                                 int choice=obj.nextInt();
		                                for (int i = 0; i < choice; i++) {
		                                	carOperation1.add_operation();
											}
		                                break;
        case 2:
        	System.out.println("====Search car by===="
	                   + "1.name"
	                   + "2.brand"
	                   + "3.fuel type"
	                   + "4.go back");
                 System.out.println("enter your input");
                  int input1=obj.nextInt();
                  switch (input1) {
                case 1: carOperation1.searchByName();
                  car_menu();
                 break;
						
                  case 2: carOperation1.searchByBrand();
                  car_menu();
                  break;
						
                  case 3:carOperation1.searchByFuel_type();
                  car_menu();
                  break;
                  
                  case 4:car_menu();
                  car_menu();
					break;
                  }
                  break;
        case 3:
        	carOperation1.updateCarDetails();
 		   car_menu();
            break;
        case 4:
        	 carOperation1.deleteCarDetails();
		     car_menu();
            break;
        case 5:
        	carOperation1.getAllDetails();
        	car_menu();
            break;
        case 6:
            loop = false;
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice. Please choose a valid option.");
            break;
    }
}
}


