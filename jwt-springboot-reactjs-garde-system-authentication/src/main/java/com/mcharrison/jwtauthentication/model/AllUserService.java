package com.mcharrison.jwtauthentication.model;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllUserService {
	
	@Autowired
	private AllUsersRepository repo;
	
	public List<AllUsers> listAll(){
		return repo.findAll();
	}
	
	public AllUsers save(AllUsers users) {
		if(users.getID()!=null&&repo.existsById(users.getID())) {
			throw new EntityExistsException("This user already exists");
		}
		return repo.save(users);
	}
	
	public AllUsers get(String id) {
		return repo.findById(id).get();
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}

}
