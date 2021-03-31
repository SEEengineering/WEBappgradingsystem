package com.mcharrison.jwtauthentication.module;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ModuleService {
	private String ID;
	
	@Autowired
	private ModuleRepository Mrepo;
	
	public List<Module> listAll(){
		return Mrepo.findAll();
	}
	
	public Module save(Module modules) {
		if(modules.getId()!=null&&Mrepo.existsById(modules.getId())) {
			throw new EntityExistsException("This exam already exists ");
		}
		return Mrepo.save(modules);
	}
	
	public Module get(String id) {
		return Mrepo.findById(id).get();
	}
	
	public void delete(String id) {
		Mrepo.deleteById(id);
	}
}
