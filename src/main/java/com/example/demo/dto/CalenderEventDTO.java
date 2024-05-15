package com.example.demo.dto;

import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalenderEventDTO {

	private String libelleEvent;
	private String statut;

	@Field(type = FieldType.Date)
	private Date dateLastUpdate;

	@Field(type = FieldType.Date)
	private Date dateFin;

	private int retardJour;
	private String category;
	private String owner;
	private String branchDescription;
	private String date;

	public CalenderEventDTO(String libelleEvent, String statut, Date dateLastUpdate, Date dateFin,
			int retardJour, String category, String owner, String branchDescription, Date date) {

		this.libelleEvent = libelleEvent;
		this.statut = statut;
		this.dateLastUpdate = dateLastUpdate;
		this.dateFin = dateFin;
		this.retardJour = retardJour;
		this.category = category;
		this.owner = owner;
		this.branchDescription = branchDescription;
		this.date = (new LocalDate()).toString("yyyy-MM-dd");
	}
}
