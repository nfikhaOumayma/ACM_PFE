package com.example.demo.dto;

import java.util.Date;

import org.joda.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class acmCollectionDTO {

	   private String customerName;
	    private String productDescription;
	    private String statutLibelle;
	    private String loanOfficer;
	    private String branchDescription;
	    private String owner;
	    private String statut;
	    private String date;
		public acmCollectionDTO(String customerName, String productDescription,
				String statutLibelle, String loanOfficer, String branchDescription, String owner,
				String statut, Date date) {

			super();
			this.customerName = customerName;
			this.productDescription = productDescription;
			this.statutLibelle = statutLibelle;
			this.loanOfficer = loanOfficer;
			this.branchDescription = branchDescription;
			this.owner = owner;
			this.statut = statut;
			this.date = (new LocalDate()).toString("yyyy-MM-dd");
			}
	    
}
