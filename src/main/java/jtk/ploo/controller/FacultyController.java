package jtk.ploo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jtk.ploo.model.Faculty;
import jtk.ploo.repository.FacultyRepository;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyRepository repository;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Faculty> faculties = (List<Faculty>) repository.findAll();
		
		model.addAttribute("faculties", faculties);
		
		return "faculty";
	}
	
	@RequestMapping("/create")
	public Faculty create(@RequestParam("name") String name) {		
		return repository.save(new Faculty(name, new Date()));
	}
	
	@RequestMapping("/findById")
	public Faculty findById(@RequestParam("id") Long id) {
		return repository.findOne(id);
	}
	
}
