package SqlOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDoperation {

	
	public static void main(String[] args) throws Exception {
		
		Class.forName("org.sqlite.JDBC");
		
		Connection con=DriverManager.getConnection("jdbc:sqlite:/c:\\sqllitedbjava\\mani.db");
		
		//select qry use panna
		Statement stmt=con.createStatement();
		
		
		ResultSet rs;
		//insert update delete kku sql injuction varathamari
		PreparedStatement st;
		
		
		
		String qry="";
		int id,age,choice;
		String name,city;
		
		Scanner in=new Scanner(System.in);
		
		Scanner str=new Scanner(System.in);
		
		while(true)
		{	System.out.println("---------------------------------");
			System.out.println("SQLite Java CRUD Operation\t|");
			System.out.println("1.Insert\t\t\t|");
			System.out.println("2.Update\t\t\t|");
			System.out.println("3.Delete\t\t\t|");
			System.out.println("4.Select\t\t\t|");
			System.out.println("5.Exit\t\t\t\t|");
			System.out.println("---------------------------------");
			System.out.println("Enter your Choice:");
			choice =in.nextInt();
			
			System.out.println("---------------------------------");
			
			switch(choice) {
			
			case 1:
				System.out.println("1.Insert New Data");
				
				System.out.println("Enter Name :");
				name=str.nextLine();
				System.out.println("Enter Age :");
				age=in.nextInt();
				System.out.println("Enter City :");
				city=str.nextLine();
				//? place holder
				qry="insert into users(Name,Age,City) values(?,?,?)";
				st=con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, city);
				st.executeUpdate();
				System.out.println("Data Insert Success");
				break;
			case 2:
				System.out.println("2.Updating a Data");
				
				System.out.println("Enter ID :");
				id=in.nextInt();
				System.out.println("Enter Name :");
				name=str.nextLine();
				System.out.println("Enter Age :");
				age=in.nextInt();
				System.out.println("Enter City :");
				city=str.nextLine();
				
				qry="update users set Name=?,Age=?,City=? where Id=?";
				
				st=con.prepareStatement(qry);
				
				
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, city);
				st.setInt(4, id);
				st.executeUpdate();
				System.out.println("Data Update Success");
				
		
				break;
			case 3:
				System.out.println("3.Deleting a Data");
				System.out.println("Enter ID :");
				id=in.nextInt();
				qry="delete from users where Id=?";
				st=con.prepareStatement(qry);
				st.setInt(1, id);
				
				st.executeUpdate();
				System.out.println("Dat Deleted Success");
				break;
				
				
			case 4:
				System.out.println("4.Print all  Data");
				qry="select Id,Name,Age,City from users";
				rs=stmt.executeQuery(qry);
				while(rs.next())
				{
					id=rs.getInt("Id");
					name=rs.getString("Name");
					age=rs.getInt("Age");
					city=rs.getString("City");
					
					System.out.print(id+" ");
					System.out.print(name+" ");
					System.out.print(age+" ");
					System.out.println(city+" ");
					
					
				}
				
				break;
			case 5:
				System.out.println("Thank you");
				//exit
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
			System.out.println("---------------------------------");
			
			
			
		}
		
		
		
		
		
		
	}

}
