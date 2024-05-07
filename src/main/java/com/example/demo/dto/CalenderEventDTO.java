package com.example.demo.dto;

import java.util.Date;


public class CalenderEventDTO {

	 private String libelleEvent;
	    private String statut;
	    private Date dateLastUpdate;
	    private Date dateFin;
	    private int retardJour;
	    private String category;
	    private String owner;
	    private String branchDescription;
	    private Date date;

	    public CalenderEventDTO(String libelleEvent, String statut, Date dateLastUpdate, Date dateFin,
	                                int retardJour, String category, String owner, String branchDescription,Date date) {
	        this.libelleEvent = libelleEvent;
	        this.statut = statut;
	        this.dateLastUpdate = dateLastUpdate;
	        this.dateFin = dateFin;
	        this.retardJour = retardJour;
	        this.category = category;
	        this.owner = owner;
	        this.branchDescription = branchDescription;
	        this.date=date;
	    }
}