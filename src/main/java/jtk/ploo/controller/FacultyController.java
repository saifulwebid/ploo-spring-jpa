package jtk.ploo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("")
	public String list(Model model) {
		List<Faculty> faculties = (List<Faculty>) repository.findAll();
		
		model.addAttribute("faculties", faculties);
		
		return "faculty/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("faculty", new Faculty("", new Date()));
		
		return "faculty/add";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Faculty faculty, BindingResult bindingResult, Model model) {		
		repository.save(faculty);
		
		return "redirect:/faculty";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("faculty", repository.findOne(id));
		
		return "faculty/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String update(@Valid Faculty inputData, BindingResult bindingResult, Model model,
			@PathVariable("id") Long id) {
		Faculty faculty = repository.findOne(id);
		
		faculty.setName(inputData.getName());
		faculty.setEstablishedDate(inputData.getEstablishedDate());
		
		repository.save(faculty);
		
		return "redirect:/faculty";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		repository.delete(repository.findOne(id));
		
		return "redirect:/faculty";
	}
	
}
