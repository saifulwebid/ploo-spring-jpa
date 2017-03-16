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
import jtk.ploo.model.Staff;
import jtk.ploo.repository.FacultyRepository;
import jtk.ploo.repository.StaffRepository;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@RequestMapping("/list")
	public List<Staff> list() {
		List<Staff> result = new ArrayList<Staff>();
		
		for (Staff staff : staffRepository.findAll()) {
			result.add(staff);
		}
		
		return result;
	}
	
	@RequestMapping("/create")
	public Staff create(@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("position") String position,
			@RequestParam("faculty") String faculty_name) {
		Faculty faculty = facultyRepository.findByName(faculty_name).get(0);
		
		return staffRepository.save(new Staff(name, address, position, faculty));
	}
	
	@RequestMapping("/findById")
	public Staff findById(@RequestParam("id") Long id) {
		return staffRepository.findOne(id);
	}
	
}
