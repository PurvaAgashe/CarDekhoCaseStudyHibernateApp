package com.jspiders.Hibernate.Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.protobuf.Method;
import com.jspiders.Hibernate.Dto.Car;

public class CarOperation1 {
 private static	EntityManagerFactory entityManagerFactory;
	private static  EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	  
	private static void openConnnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("Car");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if (entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if (entityManager!=null) {
			entityManager.close();	
		}
		if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	public  static void add_operation() {
		openConnnection();
		entityTransaction.begin();
		
		Scanner obj2 = new Scanner(System.in) ;
		System.out.println("enter car id");
		int id=obj2.nextInt();
		System.out.println("enter car name");
		String name=obj2.next();
		System.out.println("enter car model name");
		String model=obj2.next();
		System.out.println("enter car brand");
		String brand=obj2.next() ;
		System.out.println("enter car fuel type");
		String fuel=obj2.next();
		System.out.println("enter car price");
		double price=obj2.nextDouble();
		
		Car car = new Car();
        car.setCar_id(id);
        car.setName(name);
        car.setModel(model);
        car.setBrand(brand);
        car.setFuel_type(fuel);
        car.setPrice(price);
        entityManager.persist(car);
        entityTransaction.commit();
        entityManager.close();

        System.out.println("Car added successfully!");
		

	}
	public static void searchByName() {
		openConnnection();
		entityTransaction.begin();
		System.out.print("Enter car Name: ");
		Scanner scanner=new Scanner(System.in);
        int name= scanner.nextInt();
        scanner.nextLine();

        Car car = entityManager.find(Car.class, name);
       
          if (car==null) {
        	  System.out.println("car not found");
			
		} else {
			System.out.println(car);
			

		}
          entityTransaction.commit();
          entityManager.close();
		
		
	}
	public  static void searchByBrand() {
		openConnnection();
		entityTransaction.begin();
		System.out.print("Enter car Brand: ");
		Scanner scanner=new Scanner(System.in);
        String Brand= scanner.next();
        scanner.nextLine();

        Car car = entityManager.find(Car.class, Brand);
       
          if (car==null) {
        	  System.out.println("car not found");
			
		} else {
			System.out.println(car);
			

		}
          entityTransaction.commit();
          entityManager.close();
		
		
	}
		
	
	public static void searchByFuel_type() {
		openConnnection();
		entityTransaction.begin();
		System.out.print("Enter car Fuel: ");
		Scanner scanner=new Scanner(System.in);
        String fuel= scanner.next();
        scanner.nextLine();

        Car car = entityManager.find(Car.class, fuel);
       
          if (car==null) {
        	  System.out.println("car not found");
			
		} else {
			System.out.println(car);
			

		}
          entityTransaction.commit();
          entityManager.close();
		
		
	}
	public void updateCarDetails() {
		openConnnection();
		entityTransaction.begin();
		System.out.print("Enter car ID: ");
		Scanner scanner=new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Car car = entityManager.find(Car.class, id);
        if (car == null) {
            System.out.println("Car not found");
            entityManager.close();
            return;
        }
else {
	

        int id_new=scanner.nextInt();
		System.out.println("enter car name");
		String name_new=scanner.next();
		System.out.println("enter car model name");
		String model_new=scanner.next();
		System.out.println("enter car brand");
		String brand_new=scanner.next() ;
		System.out.println("enter car fuel type");
		String fuel_new=scanner.next();
		System.out.println("enter car price");
		double price_new=scanner.nextDouble();
		
		Car car1 = new Car();
        car1.setCar_id(id_new);
        car1.setName(name_new);
        car1.setModel(model_new);
        car1.setBrand(brand_new);
        car1.setFuel_type(fuel_new);
        car1.setPrice(price_new);
        entityManager.persist(car);
        entityTransaction.commit();
        entityManager.close();

        System.out.println("Car added successfully!");

        
}
	}
	public void getAllDetails() {
		openConnnection();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM CarInfo c", Car.class);

@SuppressWarnings("unchecked")
List<Car> carList = query.getResultList();

System.out.println("Id" + "\t" + "Name" + "\t" + "Model" + "\t" + "Brand" + "\t\t" + "Fuel" + "\t" + "Price");

for (Car car : carList) {
	System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getModel() + "\t" + car.getBrand()
			+ "\t" + car.getFuel_type() + "\t" + car.getPrice());
}
entityTransaction.commit();
closeConnection();
	}
	public void deleteCarDetails() {
		openConnnection();
		entityTransaction.begin();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Car Id for Removing the car");
		int r_id = sc.nextInt();
		Car car = entityManager.find(Car.class, r_id);
		if (car != null) {
			entityManager.remove(car);
			System.out.println("Car info deleted.");
		} else {
			System.out.println("Car id does Not Exists!");
		}
		entityTransaction.commit();
		closeConnection();
		
	}
		
	}
	
	
	
	