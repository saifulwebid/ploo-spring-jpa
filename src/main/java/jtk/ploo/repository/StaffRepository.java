package jtk.ploo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import jtk.ploo.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long> {

	List<Staff> findByName(String name);
	
}
