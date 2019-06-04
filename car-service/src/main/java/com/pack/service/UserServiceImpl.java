package com.pack.service;


import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pack.dao.UserDao;
import com.pack.form.Admin;
import com.pack.form.Center;
import com.pack.form.Status;
import com.pack.form.Type;
import com.pack.form.User;
@Service
public class UserServiceImpl implements UserService {
	private static final Logger log=Logger.getLogger(UserServiceImpl.class);
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
    @Transactional
	public void addUser(User u) {
		// TODO Auto-generated method stub
	log.info("Inside add user method");
	userDao.addUser(u);	
	}
    @Transactional

	public void addAdmin(Admin a) {
		// TODO Auto-generated method stub
		log.info("inside add admin");
	userDao.addAdmin(a);
	}
    @Transactional

	public int validateUser(User u) {
		// TODO Auto-generated method stub
		log.info("inside validate user");
		int i=userDao.validateUser(u);
		return i;
	}
@Transactional
	public int validateAdmin(Admin a) {
		log.info("inside validate admin");
		int i=userDao.validateAdmin(a);
		return i;
	}
@Transactional
public void addService(Center ser) {
	// TODO Auto-generated method stub
	log.info("Inside add service method");
	userDao.addService(ser);	
	
}
@Transactional
public List<Center> listService() {
	// TODO Auto-generated method stub
	log.info("inside list servcie method");
List l=userDao.listService();
	return l;
}

@Transactional
public void addRequest1(Type ty) {
	// TODO Auto-generated method stub
	log.info("inside add cost ser");
	userDao.addRequest1(ty);
	
	
}
@Transactional
public void addRequest(Status st) {
	// TODO Auto-generated method stub
	log.info("inside add cost ser");
	userDao.addRequest(st);
	
}

@Transactional
public List<Status> listRequest() {
	List l=userDao.listRequest();
	return l;
}
@Transactional
public void acceptRequest(int reqId) {
	userDao.acceptRequest(reqId);
	
}
@Transactional
public List<Status> listStatus() {
	// TODO Auto-generated method stub
	List l=userDao.listStatus();
	return l;
	
}
@Transactional

public void rejectRequest(int reqId) {
	// TODO Auto-generated method stub
	log.info("inside reject cost ser");
	userDao.rejectRequest(reqId);
	
}





}
