package nt.tthuy.Service.Imp;

import nt.tthuy.Models.User;
import nt.tthuy.DAO.Imp.UserDaoImpl;
import nt.tthuy.Interface.DAO.UserDAO;
import nt.tthuy.Interface.Service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public User login(String username, String password) {
	User user = this.get(username);
	if (user != null && password.equals(user.getPassWord())) {
	return user;
	}
	return null;
	}
	@Override
	public User get(String username) {
	    try {
	        return userDao.get(username);  // sửa ở đây
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
