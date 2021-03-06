package org.deepblue.dailyroutine.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name="TASKS")
@Data // All fields are private and final. Getters and setters are generated (https://projectlombok.org/features/Value.html)
public class Task implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;

	@NotEmpty
	@Column(name="PROJECT_ID", nullable=false)
	Integer project_id;

	@NotEmpty @Length(max=20)
	@Column(name="NAME", unique=true, nullable=false)
	String name;
	
	@Length(max=10)
	@Column(name="DUE_DATE", nullable=true)
	String due_date;
	
	@Length(max=100)
	@Column(name="NOTE", nullable=true)
	String note;
	
	@NotEmpty
	@Column(name="DONE", nullable=false)
	String done ="1";
	
	@NotEmpty
	@Column(name="DELETED", nullable=false)
	String deleted ="1";
}
