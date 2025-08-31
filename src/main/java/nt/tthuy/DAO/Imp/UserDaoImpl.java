package nt.tthuy.DAO.Imp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nt.tthuy.Connection.DBConnection;
import nt.tthuy.Interface.DAO.UserDAO;
import nt.tthuy.Models.User;
public class UserDaoImpl implements UserDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public User get(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		try {
		conn = new DBConnection().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setPassWord(rs.getString("password"));
		return user; }
		} catch (Exception e) {e.printStackTrace(); }
		return null;
	}
	public User login(String username, String password) {
	    String sql = "SELECT * FROM [User] WHERE username = ? AND password = ?";
	    try {
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUserName(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPassWord(rs.getString("password"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public User getByEmail(String email) {
	    String sql = "SELECT * FROM [User] WHERE email = ?";
	    try {
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, email);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUserName(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPassWord(rs.getString("password"));
	            user.setPhone(rs.getString("phone"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
    public void insert(User user) {
        String sql = "INSERT INTO [User](email, username, password, phone) VALUES (?,?,?,?)";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassWord());
            ps.setString(4, user.getPhone());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Override
    public boolean checkExistEmail(String email) {
        String query = "SELECT * FROM [User] WHERE email = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
	@Override
    public boolean checkExistUsername(String username) {
        String query = "SELECT * FROM [User] WHERE username = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
	@Override
    public boolean checkExistPhone(String phone) {
        String query = "SELECT * FROM [User] WHERE phone = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
