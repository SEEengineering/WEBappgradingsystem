package com.mcharrison.jwtauthentication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcharrison.jwtauthentication.Texams.Texams;
import com.mcharrison.jwtauthentication.Texams.TexamsRepository;
import com.mcharrison.jwtauthentication.exception.ResourceNotFoundException;
import com.mcharrison.jwtauthentication.grades.Grades;
import com.mcharrison.jwtauthentication.grades.GradesRepository;
import com.mcharrison.jwtauthentication.model.AllUsers;
import com.mcharrison.jwtauthentication.model.AllUsersRepository;
import com.mcharrison.jwtauthentication.module.Module;
import com.mcharrison.jwtauthentication.module.ModuleRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class TestRestAPIs {

	@Autowired
	private AllUsersRepository repo;

	@Autowired
	private ModuleRepository MRepo;

	@Autowired
	private GradesRepository GRepo;

	@Autowired
	private TexamsRepository TERepo;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/api/test/student")
	@PreAuthorize("hasRole('STUDENT') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/teacher")
	@PreAuthorize("hasRole('TEACHER') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}

	

	
	
	
	
	
	
	
//////////////////////////////////////////////////users/////////////////////////////////////////////////////////
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public List<AllUsers> getAllUsers() {
		return repo.findAll();
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/users")
	public AllUsers createUser(@RequestBody AllUsers AU) {
		return repo.save(AU);

	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users/{id}")
	public AllUsers getUserById(@PathVariable String id) {

		AllUsers AU = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
		return AU;

	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/users/{id}")
	public ResponseEntity<AllUsers> updateUsers(@PathVariable String id, @RequestBody AllUsers AUdetails) {
		AllUsers AU = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));

		AU.setName(AUdetails.getName());
		AU.setLastname(AUdetails.getLastname());
		AU.setEmail(AUdetails.getEmail());
		AU.setPhone(AUdetails.getPhone());
		AU.setAddress(AUdetails.getAddress());
		AU.setSex(AUdetails.getSex());
		AU.setRole(AUdetails.getRole());

		AllUsers updatedUser = repo.save(AU);
		return ResponseEntity.ok(updatedUser);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable String id) {
		AllUsers AU = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		repo.delete(AU);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	
	
	

/////////////////////////////////////////////////////////Module////////////////////////////////////////////
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/modules")
	public List<Module> getModules() {
		return MRepo.findAll();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/modules/{id}")
	public Module getModuleById(@PathVariable String id) {
		Module modules = MRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("module does not exist with id :" + id));
		return modules;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/modules")
	public Module createModules(@RequestBody Module modules) {
		return MRepo.save(modules);

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/modules/{id}")
	public ResponseEntity<Module> updateModule(@PathVariable String id, @RequestBody Module modules) {
		Module MD = MRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Module does not exist with id :" + id));

		MD.setId(MD.getId());
		MD.setTitle(MD.getTitle());
		MD.setDescription(MD.getDescription());
		MD.setLecturerID(MD.getLecturerID());
		Module updatedModules = MRepo.save(modules);
		return ResponseEntity.ok(updatedModules);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	

////////////////////////////////grades////////////////////////////////	
	
	
	
	@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/grades")
	public List<Grades> getGrades() {
		return GRepo.findAll();
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/grades/{id}")
	public Grades getGradesById(@PathVariable String id) {
		Grades grades = GRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("grade does not exist with id :" + id));
		return grades;
	}

	@PreAuthorize("hasRole('STUDENT')")
	@PostMapping("/grades")
	public Grades createGrades(@RequestBody Grades grades) {
		return GRepo.save(grades);

	}

	@PreAuthorize("hasRole('STUDENT')")
	@PutMapping("/grades/{id}")
	public ResponseEntity<Grades> updateGrades(@PathVariable String id, @RequestBody Grades grades) {
		Grades GDetails = GRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("grades does not exist with id :" + id));

		GDetails.setStudentID(GDetails.getStudentID());
		GDetails.setExamID(GDetails.getExamID());
		GDetails.setGrade1(GDetails.getGrade1());
		GDetails.setGrade2(GDetails.getGrade2());
		GDetails.setComments(GDetails.getComments());
		GDetails.setGradedBy(GDetails.getGradedBy());
		GDetails.setOverall(GDetails.getOverall());
		Grades updatedGrades = GRepo.save(grades);
		return ResponseEntity.ok(updatedGrades);
	}
/////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	
	
	
	
	
	

/////////////////////exams///////////////////////////////////////////
	
	@PreAuthorize("hasRole('TEACHER')")
	@GetMapping("/exams")
	public List<Texams> getExams() {
		return TERepo.findAll();
	}

	@PreAuthorize("hasRole('TEACHER')")
	@PostMapping("/exams")
	public Texams createExam(@RequestBody Texams TE) {
		return TERepo.save(TE);

	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@GetMapping("/exams/{id}")
	public Texams getExamById(@PathVariable String id) {
		Texams TE = TERepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exam does not exist with id :" + id));
		return TE;
	}

	@PreAuthorize("hasRole('TEACHER')")
	@PutMapping("/exams/{id}")
	public ResponseEntity<Texams> updateExams(@PathVariable String id, @RequestBody Texams TE) {
		Texams TEDetails = TERepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exam does not exist with id :" + id));
		TEDetails.setDescription(TEDetails.getDescription());
		TEDetails.setModuleID(TEDetails.getModuleID());
		TEDetails.setExaminerID(TEDetails.getExaminerID());
		Texams updatedExam = TERepo.save(TE);
		return ResponseEntity.ok(updatedExam);
	}

}