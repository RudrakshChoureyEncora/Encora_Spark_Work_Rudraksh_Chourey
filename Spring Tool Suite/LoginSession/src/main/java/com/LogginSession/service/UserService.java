package com.LogginSession.service;


public interface UserService {
	public abstract  boolean checkUser(String cusId);
	public abstract boolean checkUserPass(String cusId,String cusPass);
	public abstract boolean checkUserFlag(String cusId);
	public abstract String doLogin(String uid,String upass);
	public abstract void flipFlg(String userid);
	public abstract void doLogout(String userid);
}
