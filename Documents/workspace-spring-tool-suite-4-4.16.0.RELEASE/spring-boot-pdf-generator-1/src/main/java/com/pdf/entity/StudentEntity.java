package com.pdf.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "students")

public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_email")
	private String email;

	@Column(name = "student_dept")
	private String department;

	@CreationTimestamp
	private Date created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public StudentEntity(int id, String name, String email, String department, Date created_at) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.created_at = created_at;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
