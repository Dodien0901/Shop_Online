package phuocvu.org.btl_web_final.dao;

import phuocvu.org.btl_web_final.context.DBContext;
import phuocvu.org.btl_web_final.entity.Category;
import phuocvu.org.btl_web_final.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Customer getAccount(String user, String pass) {
        String sql = "select * from customer where username=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
