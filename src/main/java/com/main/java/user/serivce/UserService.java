package com.main.java.user.serivce;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.java.user.DAO.UserDAO;
import com.main.java.user.domain.User;
@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	public void add(User user) {
		System.out.println(cryptoPassword(user.getPassword()));
		user.setPassword(cryptoPassword(user.getPassword()));
		userDAO.add(user);
		System.out.println(user);
	}
	private String cryptoPassword(String password) {
		try {
			MessageDigest md =MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] sha256Hash=md.digest();
			StringBuilder sb= new StringBuilder();
			for(byte b: sha256Hash) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
	}catch(Exception e) {
		e.printStackTrace();
		return null;
		}

	}
	public User login(User user) {
		User tempUser = (userDAO.get(user.getUserId()));
		System.out.println(user.getUserId());
		if(tempUser!=null&&tempUser.getPassword().equals(cryptoPassword(user.getPassword()))){
			return tempUser;	
		}
		else return null;
	}
}
