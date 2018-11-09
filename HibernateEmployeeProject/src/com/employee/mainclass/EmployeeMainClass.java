package com.employee.mainclass;

import java.util.List;
import java.util.Scanner;

import com.employee.entity.EmployeeDto;
import com.myproject.Employee.DeleteEmployee;
import com.myproject.Employee.InsertEmployee;
import com.myproject.Employee.ReadObject;
import com.myproject.Employee.UpdateData;

public class EmployeeMainClass {

	public static void main(String[] args) {
		
		
		System.out.println("CRUD operation : to perform enter 1-4 ");
		System.out.println("1 : insertion");
		System.out.println("2 : update");
		System.out.println("3 : read  object");
		System.out.println("4 : delete");
		
		Scanner input = new Scanner (System.in);
		int value = input.nextInt();
		switch (value) {
		case 1:
			//insertion...
			System.out.println("enter firstname..");
			System.out.println("press enter...");
			String firstname =input.next();
			System.out.println("enter lastname..");
			System.out.println("press enter...");
			String lastname =input.next();
			System.out.println("enter email..");
			System.out.println("press enter...");
			String email=input.next();
			
			InsertEmployee insert = new InsertEmployee();
			EmployeeDto dto = new EmployeeDto(firstname,lastname,email);
			insert.insertEmployeeInDataBase(dto);
			break;
			
		case 2:
			//update...
			//update all or update on the basis of 
			System.out.println("all : gives list of all object");
			System.out.println("one : gives list of one object");
			System.out.println("enter the value : ");
			String condition = input.next();
			UpdateData update = new UpdateData();
			System.out.println("enter primary key ");
			Integer primaryKey = input.nextInt();
			update.updateData(condition, primaryKey);
			break;
			
		case 3:
			//read all or all
			List<EmployeeDto> employeeList = null;
			ReadObject read = new ReadObject();
			System.out.println("all : gives list of all object");
			System.out.println("one : gives list of one object");
			System.out.println("enter the value : ");
			String conditionread = input.next();
			Integer condVal = null;
			if(conditionread.equals("one")) {
				System.out.println("enter primary key..");
				condVal = input.nextInt();
				 employeeList  = read.readData(conditionread,condVal);
			}else {
				 employeeList  = read.readData(conditionread,condVal);
			}
		   display(employeeList);
			break;

		case 4 :
			//delete
			System.out.println("all : warning it will delete all the elements");
			System.out.println("one : delete one element ");
			System.out.println("enter the value : ");
			String conditionDelete = input.next();
			DeleteEmployee delete = new DeleteEmployee();
			Integer deleteprimarykey = null;
			if(conditionDelete.equals("all")) {
				delete.delete(conditionDelete, deleteprimarykey);
			}else {
				System.out.println("enter the primarykey.....");
				deleteprimarykey = input.nextInt();
				delete.delete(conditionDelete, deleteprimarykey);
			}
			
			
			
			break;
		}
		
		input.close();
	}

	private static void display(List<EmployeeDto> employeeList) {
		for (EmployeeDto employeeDto : employeeList) {
			   System.out.println("---------------------------------------");
			   	System.out.println("firstname : "+employeeDto.getFirst_name());
			   	System.out.println("lastname : "+employeeDto.getLast_name());
			   	System.out.println("email : "+employeeDto.getEmail());
			    System.out.println("---------------------------------------");
		}
	}
}
