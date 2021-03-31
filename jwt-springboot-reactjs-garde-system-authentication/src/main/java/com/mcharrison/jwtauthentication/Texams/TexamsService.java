package com.mcharrison.jwtauthentication.Texams;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TexamsService {
	
	
	private String ID;
	
	@Autowired
	private TexamsRepository TErepo;
	
	public List<Texams> listAll(){
		return TErepo.findAll();
	}
	
	public Texams save(Texams exams) {
		if(exams.getID()!=null&&TErepo.existsById(exams.getID())) {
			throw new EntityExistsException("This grade already exists ");
		}
		return TErepo.save(exams);
	}
	
	public Texams get(String id) {
		return TErepo.findById(id).get();
	}
	
	public void delete(String id) {
		TErepo.deleteById(id);
	}
}
