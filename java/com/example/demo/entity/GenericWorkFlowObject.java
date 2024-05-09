package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACM_GENERIC_WORKFLOW_OBJECT")
public class GenericWorkFlowObject {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_GENERIC_WORKFLOW_OBJECT", unique = true, nullable = false)
	private Long id;

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The generic work flow objects. 
	@OneToMany(mappedBy = "genericWorkFlowObject")
	@JsonIgnore
	private Set<Item> genericWorkFlowObjects = new HashSet<>();*/
}

