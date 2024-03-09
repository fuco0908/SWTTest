/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBConnect;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class User {

    private int userID;
    private String fullName;
    private String userName;
    private String password;
    private String email;
    private String userRole;
    private int status;
    private String phone;
    private String code;

    public User() {
    }

    public User(int userID, String fullName, String userName, String Password, String email, String userRole, int status, String phone, String code) {
        this.userID = userID;
        this.fullName = fullName;
        this.userName = userName;
        this.password = Password;
        this.email = email;
        this.userRole = userRole;
        this.status = status;
        this.phone = phone;
        this.code = code;
    }

    public User(int userID, String userName, String Password, String email, String userRole, int status) {
        this.userID = userID;
        this.userName = userName;
        this.password = Password;
        this.email = email;
        this.userRole = userRole;
        this.status = status;
    }

    public User(String userName, String email, String code) {
        this.userName = userName;
        this.email = email;
        this.code = code;
    }

    public User(String userName, String email, String phone, String code) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.code = code;
    }

    public User(String userName, String Password, String email, String userRole, int status, String phone, String code) {
        this.userName = userName;
        this.password = Password;
        this.email = email;
        this.userRole = userRole;
        this.status = status;
        this.phone = phone;
        this.code = code;
    }

    public User(String userName, String Password) {
        this.userName = userName;
        this.password = Password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassord(String Passord) {
        this.password = Passord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isValid() {
        Connection conn = null;
        CallableStatement callableStatement = null;
        Boolean loginState = false;

        try {
            DBConnect db = new DBConnect();
            conn = db.getConnection();
            callableStatement = conn.prepareCall("{call CheckLogin(?, ?)}");
            callableStatement.setString(1, this.userName);
            callableStatement.setString(2, this.password);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                loginState = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return loginState;
    }

    public boolean isAdmin() {
        Connection conn = null;
        CallableStatement callableStatement = null;
        Boolean loginState = false;

        try {
            DBConnect db = new DBConnect();
            conn = db.getConnection();
            callableStatement = conn.prepareCall("{call CheckLoginAdmin(?, ?)}");
            callableStatement.setString(1, this.userName);
            callableStatement.setString(2, this.password);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                loginState = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return loginState;
    }
}
