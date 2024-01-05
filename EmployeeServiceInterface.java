package com.Au.Dao;

import com.Au.model.Employee;

public interface EmployeeService {
	public void createEmployee(Employee emp);
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnID(int id);
    //update employee
    public void updateEmployee(int id,String name);
    //delete employee
    public void deleteEmployee(int id);
    // Show max Salary
    public void showmaxsalary();
    // Show NameWise data
    public void ShowNamewisedata();
}
