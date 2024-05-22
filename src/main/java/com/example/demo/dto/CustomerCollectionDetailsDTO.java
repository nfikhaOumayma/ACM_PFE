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
public class CustomerCollectionDetailsDTO {
	@Field(type = FieldType.Long)
    private Long id;
	
    @Field(type = FieldType.Text)
    private String customerName;
    
    @Field(type = FieldType.Text)
    private String productDescription;
    
    @Field(type = FieldType.Text)
    private String etape_encours;
   
    @Field(type = FieldType.Text)
    private String portefeuille;
    
    @Field(type = FieldType.Text)
    private String branchDescription;
    
    @Field(type = FieldType.Text)
    private String owner;
    
    @Field(type = FieldType.Text)
    private String statut;
    
 
    private String date;

	public CustomerCollectionDetailsDTO(Long id,String customerName, String productDescription,
			String etape_encours, String portefeuille, String branchDescription, String owner,
			String statut,  Date date) {
		this.id=id;
		this.customerName = customerName;
		this.productDescription = productDescription;
		this.etape_encours = etape_encours;
		this.portefeuille = portefeuille;
		this.branchDescription = branchDescription;
		this.owner = owner;
		this.statut = statut;
		this.date = (new LocalDate()).toString("yyyy-MM-dd");
	}




	

}
