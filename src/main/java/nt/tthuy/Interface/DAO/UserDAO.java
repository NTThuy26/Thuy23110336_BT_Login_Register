package nt.tthuy.Interface.DAO;

import nt.tthuy.Models.User;

public interface UserDAO {
	static User get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
