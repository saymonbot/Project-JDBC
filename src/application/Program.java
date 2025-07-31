package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Program to execute alterations in seller table
		
		System.out.println("TESTE 01 - FindById");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTESTE 02 - FindByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTESTE 03 - FindAll");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTESTE 04 - INSERT SELLER");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmai.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println(newSeller.getId());
			
		System.out.println("\nTESTE 05 - UPDATE SELLER");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println(seller.getId());
		
		System.out.println("\nTESTE 06 - DELETE SELLER");
		System.out.println("Enter id for delete");
		int id = scan.nextInt();
		sellerDao.deleteById(id);
		System.out.println("DELETE COMPLETE");
		
		scan.close();
	}
}
