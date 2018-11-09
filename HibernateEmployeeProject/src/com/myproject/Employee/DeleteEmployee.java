package com.myproject.Employee;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.employee.commonutils.CommonUtils;

public class DeleteEmployee {

	
	public void delete(String condition,Integer primarykey) {
		
		SessionFactory sessionfactory = null;
		Session session = null;
		Scanner input = new Scanner(System.in);
		try {
			 sessionfactory = CommonUtils.getSessionFactory();
			 session = sessionfactory.getCurrentSession();
			 Transaction transcation = session.beginTransaction();
			 StringBuilder query = new StringBuilder();
			 
			 if(condition.equals("all") && primarykey == null) {
				 query.append("delete from employeedb_employeetable");
				  
			 }else {
				 query.append("delete from employeedb_employeetable WHERE empId=").append(primarykey);
			 }
			 int result = session.createQuery(query.toString()).executeUpdate();
			 if(result == 1) {
				 System.out.println("record delete suecssfully....");
			 }
		}finally {
			sessionfactory.close();
		}
	}
}
