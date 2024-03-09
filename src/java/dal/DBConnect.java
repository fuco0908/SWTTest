/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class DBConnect {

    Connection connection;

    public DBConnect() {
        try {

            String user = "sa";
            String pass = "fuco";
            String url = "jdbc:sqlserver://FUCO\\SQLEXPRESS:1433;databaseName=WebProject;encrypt=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect database success!");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://FUCO\\SQLEXPRESS:1433;databaseName=WebProject;user=sa;password=fuco;encrypt=false";
                connection = DriverManager.getConnection(url);
                System.out.println("Connect database success!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }
}
