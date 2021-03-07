package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class Database {

    private static Database instance;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection()  {
        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simpledb","postgres", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public void create(int id,String name,String surname,double grade)   {
        Database dbCon =new Database();
        Connection con = dbCon.getConnection();
        PreparedStatement ps = null;
        try {
            String query="insert into students(id,name,surname,grade) values (?,?,?,?)";
            ps= con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setDouble(4, grade);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public  void read(int id)
    {
        Database dbCon =new Database();
        Connection con = dbCon.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query="select * from students";
            ps=con.prepareStatement(query);
            System.out.println(ps);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("ID-"+rs.getString("id"));
                System.out.println("name-"+rs.getString("name"));
                System.out.println("surname-"+rs.getString("surname"));
                System.out.println("grade-"+rs.getString("grade"));
                System.out.println("++++++++++++++++++++++++++++++++++++++++");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void update(int newId,String name,String surname,double grade,int id){
        Database dbCon =new Database();
        Connection con = dbCon.getConnection();
        PreparedStatement ps=null;
        try {
            String query="update students set id=?,name=?,surname=?,grade=? where id=?";
            ps=con.prepareStatement(query);
            ps.setInt(1, newId);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setDouble(4, grade);
            ps.setInt(5, id);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete(int id){
        Database dbCon =new Database();
        Connection con = dbCon.getConnection();
        PreparedStatement ps=null;
        try {
            String query="delete from students where id=?";
            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}