package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println("TESTE 01 " + seller);
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println("TESTE 02 " + obj);
		}
		
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println("TESTE 03 " + obj);
		}
	}
}