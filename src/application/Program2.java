package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//Program to execute alterations in department table

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("TEST 01 - FindById");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\nTEST 02 - FindAll");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTEST 03 - INSER DEPARTMENT");
		Department department = new Department(null, "Cosmetics");
		departmentDao.insert(department);
		System.out.println(department.getId());
		
		System.out.println("\nTEST 04 - UPDATE DEPARTMENT");
		department = departmentDao.findById(1);
		department.setName("Clothes");
		departmentDao.update(department);
		System.out.println(department.getId());
		
		System.out.println("\nTEST 05 - DELETE DEPARTMENT");
		System.out.println("Enter id for delete");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("DELETE COMPLETE");
		
		scan.close();
	}
}
