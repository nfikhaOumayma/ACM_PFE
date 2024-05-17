package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
public class LoanDTO {
	private String accountNumberExtern;

	@Field(type = FieldType.Text)
	private String statut;

	@Field(type = FieldType.Text)
	private String readyForDisb;

	private String gender;
	
	private String customerName;

	private String productDescription;

	@Field(type = FieldType.Date)
	private Date applyDate;

	private String portfolioDescription;
	private BigDecimal applyAmountTotal;
	private BigDecimal approvelAmount;
	private String loanReasonDescription;
	private String branchDescription;
	private BigDecimal apr;
	private String loanApplicationStatus;
	
	

	private String date;

	public LoanDTO(String accountNumberExtern, String statut, String readyForDisb,String gender,
			String customerName,
			String productDescription, Date applyDate, String portfolioDescription,
			BigDecimal applyAmountTotal, BigDecimal approvelAmount, String loanReasonDescription,
			String branchDescription, BigDecimal apr, String loanApplicationStatus,  Date date) {

		super();
		this.accountNumberExtern = accountNumberExtern;
		this.statut = statut;
		this.readyForDisb = readyForDisb;
		this.gender = gender;
		this.customerName = customerName;
		this.productDescription = productDescription;
		this.applyDate = applyDate;
		this.portfolioDescription = portfolioDescription;
		this.applyAmountTotal = applyAmountTotal;
		this.approvelAmount = approvelAmount;
		this.loanReasonDescription = loanReasonDescription;
		this.branchDescription = branchDescription;
		this.apr = apr;
		this.loanApplicationStatus = loanApplicationStatus;
		this.date = (new LocalDate()).toString("yyyy-MM-dd");
	}

	
	
	
}
