package jtk.ploo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jtk.ploo.model.Faculty;
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
	
	@RequestMapping("/findById")
	public Staff findById(@RequestParam("id") Long id) {
		return staffRepository.findOne(id);
	}
	
}
