package com.mcharrison.jwtauthentication.grades;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GradesService {
	private String ID;
	
	@Autowired
	private GradesRepository Grepo;
	
	public List<Grades> listAll(){
		return Grepo.findAll();
	}
	
	public Grades save(Grades grades) {
		if(grades.getStudentID()!=null&&Grepo.existsById(grades.getStudentID())) {
			throw new EntityExistsException("This grade already exists ");
		}
		return Grepo.save(grades);
	}
	
	public Grades get(String id) {
		return Grepo.findById(id).get();
	}
	
	public String delete(String id) {
		Grepo.deleteById(id);
		return "deleted grade " + id;
	}
}
