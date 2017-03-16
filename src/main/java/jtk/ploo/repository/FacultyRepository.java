package jtk.ploo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import jtk.ploo.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {

	List<Faculty> findByName(String name);
	
}
