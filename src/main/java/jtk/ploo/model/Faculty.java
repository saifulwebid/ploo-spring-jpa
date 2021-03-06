package jtk.ploo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="faculty_id")
	private Long id;
	
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="established_date")
	private Date establishedDate;
	
	protected Faculty() {}
	
	public Faculty(String name, Date estDate) {
		this.name = name;
		this.establishedDate = estDate;
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

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, name=%s, estDate=%s]",
				id, name, establishedDate.toString());
	}
	
}
