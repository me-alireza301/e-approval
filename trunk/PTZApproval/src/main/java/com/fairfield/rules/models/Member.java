package com.fairfield.rules.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jbpm_id_membership")
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_;
	
	@Column(name="CLASS_")
	private String className;
	
	@Column(name="NAME_")
	private String name;
	
	@Column(name="ROLE_")
	private String role;	

	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="USER_")
	User user;

	@ManyToOne(targetEntity=Group.class)
	@JoinColumn(name="GROUP_")
	Group group;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}
