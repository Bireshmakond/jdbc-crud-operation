package curd_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SwitchCaseUsingCrudOperation {
	 static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","Root@123");
		boolean b=true;
		while(b)
		{
			System.out.println("select 1.Insert  2.update 3.Retrieve 4.Delete  5.Exit");
			int a=sc.nextInt();
			switch(a)
			{
			case 1:{
		    PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?)");
			System.out.println("Enter student id");
			int id=sc.nextInt();
			System.out.println("Enter student name");
			String name=sc.next();
			System.out.println("Enter student age");
			int age=sc.nextInt();
			System.out.println("Enter student address");
			String address=sc.next();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, address);
			preparedStatement.execute();
			System.out.println("value inserted successfully");
			break;
			}
			case 2:
			{
				System.out.println("Enter id which is to be updated");
				PreparedStatement preparedStatement=connection.prepareStatement("update student set stu_name=? where stu_id=?");
				System.out.println("Enter student id");
				int id=sc.nextInt();
				System.out.println("Enter student name");
				String name=sc.next();
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
				preparedStatement.execute();
				System.out.println("value updated successfully");
				break;
			}
			case 3:{
				System.out.println("Enter id to Fetch Details");
				PreparedStatement preparedStatement=connection.prepareStatement("select * from student where stu_id=?");
				System.out.println("Enter id");
				int id=sc.nextInt();
				preparedStatement.setInt(1, id);
				
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					System.out.print(resultSet.getInt(1)+" ");
					System.out.print(resultSet.getString(2)+" ");
					System.out.print(resultSet.getInt(3)+" ");
					System.out.println(resultSet.getString(4)+" ");
				}
				break;
			}
			case 4:{
				System.out.println("Enter id to delete from table");
				
				PreparedStatement preparedStatement=connection.prepareStatement("delete from student where stu_id=?");
				System.out.println("Enter student id");
				int id=sc.nextInt();
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
				System.out.println("value deleted successfully");
				break;
			}
			
			case 5:{
				System.out.println("exit");
				b=false;
			}
			}
		}
		connection.close();
			
		
		
		
	}

}