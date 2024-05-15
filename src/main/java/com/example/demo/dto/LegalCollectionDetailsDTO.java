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
public class LegalCollectionDetailsDTO {
	@Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Text)
    private String customerName;

    @Field(type = FieldType.Text)
    private String productDescription;

    @Field(type = FieldType.Text)
    private String statutLibelle;

    @Field(type = FieldType.Text)
    private String loanOfficer;

    @Field(type = FieldType.Text)
    private String branchDescription;

    @Field(type = FieldType.Text)
    private String owner;

    @Field(type = FieldType.Text)
    private String statut;

    @Field(type = FieldType.Text)
    private String typeRecours;
  
    private String name;

    private String date;


    
    public LegalCollectionDetailsDTO(Long id, String customerName, String productDescription,
			String statutLibelle, String loanOfficer, String branchDescription, String owner,
			String statut ,String name,  Date date) {

		super();
		this.id = id;
		this.customerName = customerName;
		this.productDescription = productDescription;
		this.statutLibelle = statutLibelle;
		this.loanOfficer = loanOfficer;
		this.branchDescription = branchDescription;
		this.owner = owner;
		this.statut = statut;
		this.name=name;
		this.date = (new LocalDate()).toString("yyyy-MM-dd");
    }

	

}
