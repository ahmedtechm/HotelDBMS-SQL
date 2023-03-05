package HotelJdbc;

import java.sql.Connection;
import java.util.Scanner;

public class HotelDBMS {

	 public static void main(String[] args) {
		 
		 String url = "jdbc:sqlserver://localhost:1433;" +
	                  "databaseName=HotelDBMS;" +
	                  "encrypt=true;" +
	                  "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
		 
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("enter name");
	        String name = scanner.next();
	        System.out.println("enter roll no");
	        Integer roll = scanner.nextInt();
	        System.out.println("enter class");
	        String cls = scanner.next();
	      
	        Connection con = null;
		 
		 
	 }

}
