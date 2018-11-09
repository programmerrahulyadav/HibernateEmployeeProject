package com.myproject.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.employee.commonutils.CommonUtils;
import com.employee.entity.EmployeeDto;

public class InsertEmployee {

	public void insertEmployeeInDataBase(EmployeeDto dto) {
		
		
		SessionFactory sessionFactory = null;
		try {
			
			sessionFactory = CommonUtils.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction transcation = session.beginTransaction();
			session.save(dto);
			transcation.commit();
			session.close();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}
		
	}
}
