package com.fairfield.rules.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="jbpm_id_user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_;
	
	@Column(name="CLASS_")
	private String className;
	
	@Column(name="NAME_")
	private String name;
	
	@Column(name="EMAIL_")
	private String email;
	
	@Column(name="PASSWORD_")
	private String password;

	
	@OneToMany(targetEntity=Member.class,mappedBy="user")
	private List<Member> memberships = new ArrayList<Member>(); 
	
	public List<Member> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Member> memberships) {
		this.memberships = memberships;
	}

	public Integer getID_() {
		return ID_;
	}

	public void setID_(Integer iD_) {
		ID_ = iD_;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
