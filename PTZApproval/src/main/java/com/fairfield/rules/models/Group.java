package com.fairfield.rules.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jbpm_id_group")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID_;
	
	@Column(name="CLASS_")
	private String className;
	
	@Column(name="NAME_")
	private String name;
	
	@Column(name="TYPE_")
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
