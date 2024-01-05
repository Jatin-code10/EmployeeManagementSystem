package com.Au.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Au.Connection.DBConnection;
import com.Au.model.Employee;

public class EmployeeDaoImpl implements EmployeeService{
	
	Connection con;

	@Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setDouble(3, emp.getSalary());
            pstm.setInt(4, emp.getAge());
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Inserted Successfully !!!");
                con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


	    @Override
	    public void showAllEmployee() {
	        con=DBConnection.createDBConnection();
	        String query="select * from employee";
	        System.out.println("Employee Details :");
	        System.out.println("---------------------------------------------");

	        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary   ","  age");
	        System.out.println("---------------------------------------------");

	        try{
	            Statement stmt=con.createStatement();
	            ResultSet result= stmt.executeQuery(query);
	            while (result.next()){
	                System.out.format("%d\t%s\t%f\t%d\n",
	                        result.getInt(1),
	                        result.getString(2),
	                        result.getDouble(3),
	                        result.getInt(4));
	                System.out.println("---------------------------------------------");

	            }

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }

	    @Override
	    public void showEmployeeBasedOnID(int id) {
	        con=DBConnection.createDBConnection();
	        String query="select * from employee where id="+id;
	        try{
	            Statement stmt=con.createStatement();
	           ResultSet result= stmt.executeQuery(query);
	            while (result.next()){
	                System.out.format("%d\t%s\t%f\t%d\n",
	                        result.getInt(1),
	                        result.getString(2),
	                        result.getDouble(3),
	                        result.getInt(4));

	            }

	        }
	        catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }

	    @Override
	    public void updateEmployee(int id, String name) {
	        con=DBConnection.createDBConnection();
	        String query="update employee set name=? where id=?";
	        try{
	            PreparedStatement pstm=con.prepareStatement(query);
	            pstm.setString(1,name);
	            pstm.setInt(2,id);
	            int cnt=pstm.executeUpdate();
	            if(cnt!=0)
	                System.out.println("Employee Details updated successfully !!");

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }

	    @Override
	    public void deleteEmployee(int id) {
	        con=DBConnection.createDBConnection();
	        String query="delete from employee where id=?";
	        try{
	            PreparedStatement pstm=con.prepareStatement(query);
	            pstm.setInt(1,id);
	           int cnt= pstm.executeUpdate();
	           if(cnt!=0)
	               System.out.println("Employee Deleted Successfully!!! "+id);

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }


	    }
	    
	    
	    public void showmaxsalary() {
	    	con=DBConnection.createDBConnection();
	        String query="select * from employee where salary =(select max(salary) from employee);";
	        try{
	            PreparedStatement st=con.prepareStatement(query);
	            ResultSet result = st.executeQuery();
	            while (result.next()) {
	            	System.out.println(result.getInt(1));
	            	System.out.println(result.getString(2));
	            	System.out.println(result.getDouble(3));
	            }
	        }catch (Exception ex){
	            ex.printStackTrace();
	        }
	    }
	    
	    public void ShowNamewisedata() {
	    	con = DBConnection.createDBConnection();
	    	String query = "select * from employee order by name";
	    	try {
	    		PreparedStatement st = con.prepareStatement(query);
	    		ResultSet res = st.executeQuery();
	    		while(res.next()) {
	    			System.out.println(res.getInt(1));
	    			System.out.println(res.getString(2));
	    			System.out.println(res.getDouble(3));
	    		}
	    	}
	    	catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
}
