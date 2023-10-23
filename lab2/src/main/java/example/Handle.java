package org.example;

import org.dao.Repository;
import org.pojo.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public  class Handle implements Repository<Product> {
    private List<Product> list;

    public Handle(List<Product> list){
        this.list =list;
    }

    public Handle(){

    }



    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    @Override
    public void add(Product item) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySql.getConnection();
            String sql = "insert into product (id,name,price) values(?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, item.getId());
            preparedStmt.setString (2, item.getName());
            preparedStmt.setFloat(3,item.getPrice());

            preparedStmt.execute();

        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> readAll() {
        Connection conn = null;
        try {
            conn = MySql.getConnection();
            String query = "SELECT * FROM Product";
            Statement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Product stu = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getFloat("price")
                );
                list.add(stu);
            }
            conn.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product read(String id) {
        Connection conn = null;
        Product stu = null;
        try {
            conn = MySql.getConnection();
            String query = "SELECT * FROM Product where id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                 stu = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getFloat("price")
                );
            }
            conn.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stu;
    }

    @Override
    public boolean update(Product item) {
        Connection conn = null;
        Statement stmt = null;
        try {

            System.out.println("Connecting to database...");
            conn = MySql.getConnection();

            System.out.println("Updating records into the table...");
            String sql = "UPDATE product SET name = ?, price = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, item.getName());
            preparedStmt.setFloat    (2, item.getPrice());
            preparedStmt.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
                return  true;
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {

            System.out.println("Connecting to database...");
            conn = MySql.getConnection();

            System.out.println("Delete records into the table...");
            String sql = "delete from product where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, id);
            preparedStmt.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
                return true;
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }
}
