package com.myproject.Employee;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.employee.commonutils.CommonUtils;
import com.employee.entity.EmployeeDto;

public class UpdateData {

	public void updateData(String condition,Integer primaryKey) {
		
		
		SessionFactory sessionfactory = null;
		Session session = null;
		Scanner input = new Scanner(System.in);
		try {
			 sessionfactory = CommonUtils.getSessionFactory();
			 session = sessionfactory.getCurrentSession();
			 Transaction transcation = session.beginTransaction();
			 StringBuilder query = new StringBuilder();
			 if(condition.equals("all")) {
				 
				 System.out.println("enter firstname..");
					System.out.println("press enter...");
					String firstname =input.next();
					System.out.println("enter lastname..");
					System.out.println("press enter...");
					String lastname =input.next();
					System.out.println("enter email..");
					System.out.println("press enter...");
					String email=input.next();
					query.append("update from employeedb_employeetable set first_name='").append(firstname).append("'").append(" AND last_name='").append(lastname)
					.append("' AND email='").append(email).append("' WHERE empId=").append(primaryKey).toString();
					
			 }else {
				 System.out.println("1: firstname");
				 System.out.println("2: lastname");
				 System.out.println("3: email");
				 System.out.println("enter the number to update column");
				 int key= input.nextInt();
				 query.append("update from employeedb_employeetable ");
				 switch (key) {
				case 1:
					System.out.println("enter firstname..");
					System.out.println("press enter...");
					String firstname =input.next();
					query.append(" set first_name='").append(firstname).append("' WHERE empId=").append(primaryKey);
					break;
				case 2:
					
					System.out.println("enter lastname..");
					System.out.println("press enter...");
					String lastname =input.next();
					query.append(" set last_name='").append(lastname).append("' WHERE empId=").append(primaryKey);
					
					break;

				default:
					System.out.println("enter email..");
					System.out.println("press enter...");
					String email =input.next();
					query.append(" set email='").append(email).append("' WHERE empId=").append(primaryKey);
					
					break;
				}
				 
			 }
			int result = session.createQuery(query.toString()).executeUpdate();
			if(result == 1) {
				System.out.println(" records updated sucessfully...");
			}
			 transcation.commit();
			
		} finally {
			// TODO: handle finally clause
			sessionfactory.close();
			input.close();
		}
	}
}
