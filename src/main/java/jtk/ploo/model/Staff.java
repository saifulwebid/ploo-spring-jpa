package jtk.ploo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="staff_id")
	private Long id;
	
	private String name;
	
	private String address;
	
	private String position;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	protected Staff() {}
	
	public Staff(String name, String address, String position, Faculty faculty) {
		this.name = name;
		this.address = address;
		this.position = position;
		this.faculty = faculty;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return String.format(
				"Staff[id=%d, name=%s, address=%s, position=%s, faculty=%s]",
				id, name, address, position, faculty.toString());
	}

}
