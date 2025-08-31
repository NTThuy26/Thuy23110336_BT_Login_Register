package nt.tthuy.Interface.Service;

import nt.tthuy.Models.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
	
	void insert(User user);
    boolean register(String email, String password, String username, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
