package nt.tthuy.Interface.Service;

import nt.tthuy.Models.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
}
