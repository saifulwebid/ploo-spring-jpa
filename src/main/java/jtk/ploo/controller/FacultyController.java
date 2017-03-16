package jtk.ploo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jtk.ploo.model.Faculty;
import jtk.ploo.repository.FacultyRepository;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyRepository repository;
	
	@RequestMapping("/list")
	public List<Faculty> list() {
		List<Faculty> result = new ArrayList<Faculty>();
		
		for (Faculty faculty : repository.findAll()) {
			result.add(faculty);
		}
		
		return result;
	}
	
	@RequestMapping("/create")
	public Faculty create(@RequestParam("name") String name) {		
		return repository.save(new Faculty(name, new Date()));
	}
}
