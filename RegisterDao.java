package net.javaguides.register.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.register.bean.RegisterBean;

public class RegisterDao {

    public boolean insertRegistration(RegisterBean registerBean) throws ClassNotFoundException {
        boolean status = false;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet rs;
        
        if(registerBean.getPassword()=="") {
        	return false;
        }
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	//step1:connect
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/informations_db?useSSL=false", "root", "root");
            // Step 2:Create a statement using connection object
            preparedStatement = connection.prepareStatement("select * from login where username = ?");
            preparedStatement.setString(1, registerBean.getUsername());
            System.out.println(preparedStatement);
            rs = preparedStatement.executeQuery();
            status = rs.next();
            
            if(status==false) {
                preparedStatement = connection.prepareStatement("insert into login values(?,?)");
                preparedStatement.setString(1, registerBean.getUsername());
                preparedStatement.setString(2, registerBean.getPassword());
                System.out.println(preparedStatement);
                System.out.println(registerBean.getPassword());
                preparedStatement.executeUpdate();
                status = true;
            }
            else {
            	return false;
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
