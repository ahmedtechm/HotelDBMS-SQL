package HotelJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HotelDBMS {

	 public static void main(String[] args) {
		 
		 String url = "jdbc:sqlserver://localhost:1433;" +
	                  "databaseName=HotelDBMS;" +
	                  "encrypt=true;" +
	                  "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";

	        try (Connection connection = DriverManager.getConnection(url, user, pass);
	                Statement statement = connection.createStatement()) {

	            // Create Hotels table
	            String hotelsTable = "CREATE TABLE Hotels "
	            				   + "(id INT PRIMARY KEY, "
	            				   + "hotel_name VARCHAR(255) NOT NULL, "
	            				   + "hotel_location VARCHAR(255), "
	            			  	   + "created_date DATE NOT NULL, "
	            				   + "updated_date DATE, "
	            				   + "is_Active bit NOT NULL)";

	            statement.executeUpdate(hotelsTable);

	            // Create Room_Type table
	            String roomTypeTable = "CREATE TABLE Room_Type "
	            					 + "(id INT PRIMARY KEY, "
	            					 + "room_type_name VARCHAR(255) NOT NULL, "
	            					 + "created_date DATE, "
	            					 + "updated_date DATE, "
	            					 + "is_Active bit NOT NULL)";

	            statement.executeUpdate(roomTypeTable);

	            // Create Rooms table
	            String roomsTable = "CREATE TABLE Rooms "
	            					+ "(id INT PRIMARY KEY, "
	            					+ "room_type_id INT, "
	            					+ "hotel_id INT, "
	            					+ "created_date DATE NOT NULL, "
	            					+ "updated_date DATE, "
	            					+ "is_Active bit NOT NULL, "
	            					+ "FOREIGN KEY (room_type_id) REFERENCES Room_Type(id), "
	            					+ "FOREIGN KEY (hotel_id) REFERENCES Hotels(id))";

	            statement.executeUpdate(roomsTable);

	            // Create Guests table
	            String guestsTable = "CREATE TABLE Guests "
	            				   + "(id INT PRIMARY KEY, "
	            				   + "guest_name VARCHAR(255) NOT NULL, "
	            				   + "guest_phone VARCHAR(255) NOT NULL, "
	            				   + "guest_accompanying_members INT NOT NULL, "
	            				   + "guest_payment_amount INT NOT NULL, "
	            				   + "room_id INT, "
	            				   + "hotel_id INT, "
	            				   + "created_date DATE NOT NULL, "
	            				   + "updated_date DATE, "
	            				   + "is_Active bit NOT NULL, "
	            				   + "FOREIGN KEY (room_id) REFERENCES Rooms(id), "
	            				   + "FOREIGN KEY (hotel_id) REFERENCES Hotels(id))";

	            statement.executeUpdate(guestsTable);

	            // Create Employee_Type table
	            String employeeTypeTable = "CREATE TABLE Employee_Type "
	            						 + "(id INT PRIMARY KEY, "
	            					 	 + "employee_type_name VARCHAR(255) NOT NULL, "
	            						 + "created_date DATE NOT NULL, "
	            						 + "updated_date DATE, "
	            						 + "is_Active bit NOT NULL)";

	            statement.executeUpdate(employeeTypeTable);

	            // Create Employees table
	            String employeesTable = "CREATE TABLE Employees "
	            					  + "(id INT PRIMARY KEY, "
	            					  + "employee_type_id INT, "
	            					  + "room_id INT, "
	                    			  + "created_date DATE NOT NULL, "
	                    			  + "updated_date DATE, "
	                    			  + "is_Active bit NOT NULL, "
	                    			  + "FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id), "
	                    			  + "FOREIGN KEY (room_id) REFERENCES Rooms(id))";

	            statement.executeUpdate(employeesTable);

	            System.out.println("Tables created successfully.");
	            
	            
	            
	            String sqlHotel = "INSERT INTO Hotels (id, hotel_name, hotel_location, created_date, updated_date, is_Active) "
                        		+ "VALUES (1, 'Hilton', 'Muscat', '2022-01-01', null, 1)";
	            		
	            statement.executeUpdate(sqlHotel);

	            
	            
	            String sqlRoomType = "INSERT INTO Room_Type (id, room_type_name, created_date, updated_date, is_Active) "
                        		   + "VALUES (1, 'Standard', '2022-01-01', null, 1)";
	            
	            statement.executeUpdate(sqlRoomType);

	            
	            
	            String sqlRoom = "INSERT INTO Rooms (id, room_type_id, hotel_id, created_date, updated_date, is_Active) "
                        	   + "VALUES (1, 1, 1, '2022-01-01', null, 1)";
	            
	            statement.executeUpdate(sqlRoom);
	            
	            
	            
	            String sqlGuest = "INSERT INTO Guests (id, guest_name, guest_phone, guest_accompanying_members, guest_payment_amount, room_id, hotel_id, created_date, updated_date, is_Active) "
                                + "VALUES (1, 'Ahmed AL Abri', '555-1234', 2, 200, 1, 1, '2022-01-01', null, 1)";
	            
	            statement.executeUpdate(sqlGuest);

	            
	            
	            String sqlEmployeeType = "INSERT INTO Employee_Type (id, employee_type_name, created_date, updated_date, is_Active) "
                        			   + "VALUES (1, 'Manager', '2022-01-01', null, 1)";
	            
	            statement.executeUpdate(sqlEmployeeType);

	            
	            
	            String sqlEmployee = "INSERT INTO Employees (id, employee_type_id, room_id, created_date, updated_date, is_Active) "
                        		   + "VALUES (1, 1, 1, '2022-01-01', null, 1)";
	            
	            statement.executeUpdate(sqlEmployee);

	            
	        } catch (Exception ex) {
	        	System.out.println("Error creating tables: " + ex.getMessage());
	        }
	    }
	}
