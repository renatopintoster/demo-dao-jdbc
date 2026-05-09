package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        DepartmentDao DepartmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = DepartmentDao.findById(3);
        System.out.println(department);
      
        System.out.println("\n=== TEST 3: department findAll ===");
        List<Department> list = DepartmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: department insert ===");
        Department newDepartment = new Department(null, "Hygiene");
        DepartmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: department update ===");
        department = DepartmentDao.findById(1);
        department.setName("Food");
        DepartmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        DepartmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
