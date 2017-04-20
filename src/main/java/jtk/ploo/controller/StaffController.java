package jtk.ploo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jtk.ploo.model.Staff;
import jtk.ploo.repository.FacultyRepository;
import jtk.ploo.repository.StaffRepository;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@RequestMapping("")
	public String list(Model model) {
		List<Staff> staffs = (List<Staff>) staffRepository.findAll();
		
		model.addAttribute("staffs", staffs);
		
		return "staff/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("staff", new Staff("", "", "", null));
		model.addAttribute("faculties", facultyRepository.findAll());
		
		return "staff/add";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Staff staff, BindingResult bindingResult, Model model) {
		staffRepository.save(staff);
		
		return "redirect:/staff";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("staff", staffRepository.findOne(id));
		model.addAttribute("faculties", facultyRepository.findAll());
		
		return "staff/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String edit(@Valid Staff inputData, BindingResult bindingResult, Model model,
			@PathVariable("id") Long id) {
		Staff staff = staffRepository.findOne(id);
		
		staff.setName(inputData.getName());
		staff.setAddress(inputData.getAddress());
		staff.setPosition(inputData.getPosition());
		staff.setFaculty(inputData.getFaculty());
		
		staffRepository.save(staff);
		
		return "redirect:/staff";
	}
	
	@RequestMapping("/delete/{id}")
	public String findById(Model model, @PathVariable("id") Long id) {
		staffRepository.delete(staffRepository.findOne(id));
		
		return "redirect:/staff";
	}
	
}
