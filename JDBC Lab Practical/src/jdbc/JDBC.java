/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "";
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);
           
            stmt = conn.createStatement();
            
           
            String query = "SELECT * FROM employee";
            rs = stmt.executeQuery(query);

           
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name + " - " + age);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
    
}
