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
}
