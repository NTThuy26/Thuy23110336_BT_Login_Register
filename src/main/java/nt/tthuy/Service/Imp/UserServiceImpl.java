package nt.tthuy.Service.Imp;

import nt.tthuy.Models.User;

import java.sql.Date;

import nt.tthuy.DAO.Imp.UserDaoImpl;
import nt.tthuy.Interface.DAO.UserDAO;
import nt.tthuy.Interface.Service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}
	@Override
	public User get(String username) {
	    try {
	        return userDao.get(username); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@Override
    public void insert(User user) {
        userDao.insert(user);
    }
    @Override
    public boolean register(String email, String password, String username, String phone) {
    	try {
            if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email) || userDao.checkExistPhone(phone)) {
                return false;
            }
            User user = new User();
            user.setEmail(email);
            user.setUserName(username);
            user.setPassWord(password);
            user.setPhone(phone);

            userDao.insert(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }
    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }
    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

}
