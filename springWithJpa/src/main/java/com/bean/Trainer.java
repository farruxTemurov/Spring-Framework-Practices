package com.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Trainer {
	@Id
	@Column(name = "tid")
	private int tid;
	@Column(name = "tname")
	private String tname;
	@Column(name = "tech")
	private String tech;
	@OneToMany
	@JoinColumn(name = "tid") // Link to Fk in student's table
	private List<Student> listofStudents;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public List<Student> getListofStudents() {
		return listofStudents;
	}

	public void setListofStudents(List<Student> listofStudents) {
		this.listofStudents = listofStudents;
	}

	@Override
	public String toString() {
		return "Trainer [tid=" + tid + ", tname=" + tname + ", tech=" + tech + ", listofStudents=" + listofStudents
				+ "]";
	}

}
