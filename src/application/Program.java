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
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println("TESTE 01 - " + seller);
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println("TESTE 02 - " + obj);
		}
		
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println("TESTE 03 - " + obj);
		}
		
		Seller newSeller = new Seller(null, "Greg", "Greg@gmai.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("TESTE 04 - " + newSeller.getId());
			
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("TESTE 05 - " + seller.getId());
		
		System.out.println("Enter id for delete");
		int id = scan.nextInt();
		sellerDao.deleteById(id);
		System.out.println("TESTE 06 - DELETE COMPLETE");
		
		scan.close();
				
	}
}