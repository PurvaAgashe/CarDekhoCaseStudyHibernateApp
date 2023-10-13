//package com.jspiders.Hibernate.Dao;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import com.jspiders.Hibernate.Dto.Car;
//import com.mysql.cj.Query;
//
//
//
//
//public class carOperation {
//	private static EntityManagerFactory entityManagerFactory;
//	private static EntityManager entityManager;
//	private static EntityTransaction entityTransaction;
//	
//	private static void openConnection(){
//		entityManagerFactory = Persistence.createEntityManagerFactory("Car");
//		entityManager=entityManagerFactory.createEntityManager();
//		entityTransaction=entityManager.getTransaction();  
//	}
//	private static void closeConnection()
//	{
//		if(entityManagerFactory!=null)
//		{
//			entityManagerFactory.close();
//		}
//		if(entityManager!=null)
//		{
//			entityManager.close();
//		}
//		if(entityTransaction!=null)
//		{
//			if(entityTransaction.isActive())
//			{
//				entityTransaction.rollback();
//			}
//		}
//	}
//	public void add_operation() {
//		try {
//			Scanner obj2 = new Scanner(System.in) ;
//			System.out.println("enter car id");
//			int id=obj2.nextInt();
//			System.out.println("enter car name");
//			String name=obj2.next();
//			System.out.println("enter car model name");
//			String model=obj2.next();
//			System.out.println("enter car brand");
//			String brand=obj2.next() ;
//			System.out.println("enter car fuel type");
//			String fuel=obj2.next();
//			System.out.println("enter car price");
//			Double price=obj2.nextDouble();
//			openConnection();
//			entityTransaction.begin();
//			 Car newCar = new Car();
//		        newCar.setCar_id(id);
//		        newCar.setName(name);
//		        newCar.setModel(model);
//		        newCar.setBrand(brand);
//		        newCar.setFuel_type(fuel);
//		        newCar.setPrice(price);
//		        try {
//		            entityManager.persist(newCar);
//		            System.out.println("Car added successfully.");
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		            System.err.println("Failed to add car.");
//		        } finally {
//		            closeConnection();
//		        }
//		}
//	}
//}
//		
//	
//
////}
////		public void getAllDetails() {
////	        openConnection();
////
////	        try {
////	            Query query = entityManager.createQuery("SELECT c FROM Car c");
////	            List<Car> cars = query.getResultList();
////
////	            for (Car car : cars) {
////	                System.out.println(car.toString());
////	            }
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        } finally {
////	            closeConnection();
////	        }
////	    }
////		public void searchByName() {
////	        openConnection();
////	        try {
////	            Scanner scanner = new Scanner(System.in);
////	            System.out.println("Enter the name");
////	            String searchName = scanner.next();
////
////	            Query query = entityManager.createQuery("SELECT c FROM Car c WHERE c.name = :searchName");
////	            query.setParameter("searchName", searchName);
////
////	            List<Car> cars = query.getResultList();
////
////	            if (cars.isEmpty()) {
////	                System.out.println("No result found.");
////	            } else {
////	                for (Car car : cars) {
////	                    System.out.println(car.toString());
////	                }
////	            }
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        } finally {
////	            closeConnection();
////	        }
////	    }
////
////	    public void searchByBrand() {
////	        openConnection();
////	        try {
////	            Scanner scanner = new Scanner(System.in);
////	            System.out.println("Enter the Brand");
////	            String searchBrand = scanner.next();
////
////	            Query query = entityManager.createQuery("SELECT c FROM Car c WHERE c.brand = :searchBrand");
////	            query.setParameter("searchBrand", searchBrand);
////
////	            List<Car> cars = query.getResultList();
////
////	            if (cars.isEmpty()) {
////	                System.out.println("No result found.");
////	            } else {
////	                for (Car car : cars) {
////	                    System.out.println(car.toString());
////	                }
////	            }
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        } finally {
////	            closeConnection();
////	        }
////	    }
////
////	    public void searchByFuelType() {
////	        openConnection();
////	        try {
////	            Scanner scanner = new Scanner(System.in);
////	            System.out.println("Enter the fuel type");
////	            String searchFuelType = scanner.next();
////
////	            Query query = entityManager.createQuery("SELECT c FROM Car c WHERE c.fuel_type = :searchFuelType");
////	            query.setParameter("searchFuelType", searchFuelType);
////
////	            List<Car> cars = query.getResultList();
////
////	            if (cars.isEmpty()) {
////	                System.out.println("No result found.");
////	            } else {
////	                for (Car car : cars) {
////	                    System.out.println(car.toString());
////	                }
////	            }
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        } finally {
////	            closeConnection();
////	        }
////	    }
////
////	    public void updateCarDetails() {
////	        openConnection();
////	        try {
////	            Scanner scanner = new Scanner(System.in);
////	            System.out.println("Enter the car ID to update:");
////	            int carId = scanner.nextInt();
////
////	            Car carToUpdate = entityManager.find(Car.class, carId);
////
////	            if (carToUpdate != null) {
////	                // Read updated details from the user
////	                System.out.print("Enter updated name: ");
////	                carToUpdate.set_name(scanner.next());
////
////	                System.out.print("Enter updated model: ");
////	                carToUpdate.set_model(scanner.next());
////
////	                System.out.print("Enter updated brand: ");
////	                carToUpdate.set_brand(scanner.next());
////
////	                System.out.print("Enter updated fuel type: ");
////	                carToUpdate.set_fuel_type(scanner.next());
////
////	                System.out.print("Enter updated price: ");
////	                carToUpdate.set_price(scanner.nextDouble());
////
////	                entityManager.merge(carToUpdate);
////	                System.out.println("Car details updated successfully.");
////	            } else {
////	                System.out.println("Car with ID " + carId + " not found.");
////	            }
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        } finally {
////	            closeConnection();
////	        }
////	    }
////
////	    public void deleteCarDetails() {
////	        openConnection();
////	        try {
////	            Scanner scanner = new Scanner(System.in);
////	            System.out.println("Enter the car ID to delete:");
////	            int carId = scanner.nextInt();
////
////	            Car carToDelete = entityManager.find(Car.class, carId);
////
////	            if (carToDelete != null) {
////	                entityManager.remove(carToDelete);
////	                System.out.println("Car details deleted successfully.");
////	            } else {
////	                System.out.println("Car with ID " + carId + " not found.");
////	            }
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        } finally {
////	            closeConnection();
////	        }
//	    
//	
