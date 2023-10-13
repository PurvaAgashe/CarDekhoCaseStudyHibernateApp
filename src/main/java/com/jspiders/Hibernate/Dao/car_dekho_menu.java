//package com.jspiders.Hibernate.Dao;
//
//import java.util.Scanner;
//
////import com.jspiders.carddekho_case_study.operation.car_operation;
//
//public class car_dekho_menu {
//	  private static car_operation operation= new car_operation();
//	  private static boolean loop=true;
//
//	  
//	public static void main(String[] args) {
//		while (loop==true) {
//			car_menu();
//		}
//	} 
//		 
//	private static void car_menu() {
//			
//		Scanner obj=new Scanner(System.in);
//		System.out.println("===========MENU==========="
//	              + "1. Add car details"
//	              + "2. Search car details"
//	              + "3. update car details"
//	              + "4. Delete car details"
//	              
//	              + "5. show details"
//	              + "6.exit");
//		System.out.println("enter your input");
//		int input=obj.nextInt();
//		switch (input) {
//		case 1: System.out.println("======how many car do you want to add? ======");
//		                                 int choice=obj.nextInt();
//		                                for (int i = 0; i < choice; i++) {
//		                                	operation.add_operation();
//											}
////		                                operation.getAllDetails();
//			break;
//		}
////	}
//		
//			
////		case 2:System.out.println("====Search car by===="
////				                   + "1.name"
////				                   + "2.brand"
////				                   + "3.fuel type"
////				                   + "4.go back");
////		                        System.out.println("enter your input");
////		                         int input1=obj.nextInt();
////		                         switch (input1) {
////		                         case 1: operation.searchByName();
////		                         car_menu();
////		                         break;
////									
////		                         case 2: operation.searchByBrand();
////		                         car_menu();
////		                         break;
////									
////		                         case 3:operation.searchByFuel_type();
////		                         car_menu();
////		                         break;
////		                         
////		                         case 4:car_menu();
////		                         car_menu();
////								break;
////		                         }
////		                         break;
////		                        
////	   case 3:
////		   operation.updateCarDetails();
////		   car_menu();
////		break;
////		
////		
////		case 4:
////		     operation.deleteCarDetails();
////		     car_menu();
////			break;
////			
////		case 5	: operation.getAllDetails();
////		car_menu();
////		break;
////			
////		case 6:System.out.println("thankyou...!");
////		         System.exit(0);
////			
////
////		default : 
////			break;
////		}
////	}
////
////}
