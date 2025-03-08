package com.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
	@Id
	private int tid;
	private String tname;
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
