package com.myproject.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.employee.commonutils.CommonUtils;
import com.employee.entity.EmployeeDto;

public class ReadObject {

	public List<EmployeeDto> readData(String conditon,Integer val ) {
		List<EmployeeDto> employee = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		try {
			if(conditon.equals("all") && val == null) {
				sessionfactory = CommonUtils.getSessionFactory();
				 session = sessionfactory.getCurrentSession();
				session.beginTransaction();
				employee = session.createQuery("from employeedb_employeetable").getResultList();
			}else {
				sessionfactory = CommonUtils.getSessionFactory();
				 session = sessionfactory.getCurrentSession();
				 session.beginTransaction();
				employee = session.createQuery("from employeedb_employeetable where empId="+val).getResultList();
			}
		} finally {
			// TODO: handle finally clause
			sessionfactory.close();
		}
		
		return employee;
	}
}
