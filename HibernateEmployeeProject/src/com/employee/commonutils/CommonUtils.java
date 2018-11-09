package com.employee.commonutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.entity.EmployeeDto;

public class CommonUtils {

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionfactory= new Configuration().configure().addAnnotatedClass(EmployeeDto.class).buildSessionFactory();
		return sessionfactory;
	}
}
