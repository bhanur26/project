package com.pack.dao;

import java.util.List;

import com.pack.form.Admin;
import com.pack.form.Center;
import com.pack.form.Status;
import com.pack.form.Type;
import com.pack.form.User;

public interface UserDao {
public void addUser(User u);
public void addAdmin(Admin a);
public int validateUser(User u);
public int validateAdmin(Admin a);
public void addService(Center ser);
public  List<Center> listService();

public void addRequest1(Type ty);
public void addRequest(Status st);
public List<Status> listRequest();
public void acceptRequest(int reqId);
public List<Status> listStatus();
public void rejectRequest(int reqId);

}
