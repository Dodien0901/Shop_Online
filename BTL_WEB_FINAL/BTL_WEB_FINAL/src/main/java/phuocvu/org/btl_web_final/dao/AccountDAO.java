package phuocvu.org.btl_web_final.dao;

import phuocvu.org.btl_web_final.context.DBContext;
import phuocvu.org.btl_web_final.entity.Account;
import phuocvu.org.btl_web_final.entity.Category;
import phuocvu.org.btl_web_final.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        String query = "SELECT * FROM Account ORDER BY id DESC";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String user = rs.getString("user");
                String pass = rs.getString("pass");
                int isSell = rs.getInt("isSell");
                int isAdmin = rs.getInt("isAdmin");
                int status = rs.getInt("status");
                accountList.add(new Account(id, user, pass, isSell, isAdmin, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }
    public void deleteAccount(int accountId) {
        String query = "DELETE FROM Account WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, accountId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateAccount(int id, String user, int isAdmin, int status) {
        String query = "UPDATE Account SET user = ?, isAdmin = ?, status = ? WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user);
            ps.setInt(2, isAdmin);
            ps.setInt(3, isAdmin);
            ps.setInt(4, id);
             ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String user, String pass) {
        String query = "insert into account\n"
                + "values(?,?,0,0)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void editAccount( String user,int status) {
        String query = "update Account\n"
                + "set [user] = ?,\n"
                + "set[status] = ?,\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(5, String.valueOf(status));
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
