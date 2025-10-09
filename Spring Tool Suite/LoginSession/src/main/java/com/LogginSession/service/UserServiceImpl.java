package com.LogginSession.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LogginSession.model.User;
import com.LogginSession.repository.UserRepo;


@Service("uServ1")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo uRep;
	
	
	@Override
	public boolean checkUser(String userid) {
		// TODO Auto-generated method stub
		Optional<User> cus=uRep.findById(userid);
		if(cus.isEmpty())return false;
		System.out.println(cus.get());
		return true;
	}
	
	@Override
	public boolean checkUserPass(String userid, String cusPass) {
		// TODO Auto-generated method stub
		Optional<User> cusOp=uRep.findById(userid);
		if(cusOp.isEmpty())return false;
		if(cusOp.get().getUserpass().equals(cusPass)) return true;
		return false;
	}
	
	
	@Override
	public boolean checkUserFlag(String userid) {
		// TODO Auto-generated method stub
		Optional<User> cusOp=uRep.findById(userid);
		if(cusOp.isEmpty())return false;
        return cusOp.get().getFlag()==1;
	}
	
	
	@Override
	public void flipFlg(String userid) {
		// TODO Auto-generated method stub
		Optional<User> cusOp=uRep.findById(userid);
		if(cusOp.isPresent()) {
			System.out.println(cusOp.get());
			if(cusOp.get().getFlag()==1) cusOp.get().setFlag(0);
			else cusOp.get().setFlag(1);
			System.out.println(cusOp.get());
			uRep.save(cusOp.get());
		}
	}
	
	
	
	@Override
	public String doLogin(String uid, String upass) {
		// TODO Auto-generated method stub
		if (checkUser(uid)) {
			if(checkUserPass(uid,upass)) {
				if(checkUserFlag(uid)) {
					flipFlg(uid);
					return "EntryPage";
				}
				else return "alreadyLoggedin";
//				else return "LoginPage";
			}
			else return"WrongPass";
//			else return "LoginPage";
		}
		else return "RegisterPage";
//		else return "LoginPage";
	}
	
	@Override
	public void doLogout(String uid) {
		flipFlg(uid);
	}
	
	
}
