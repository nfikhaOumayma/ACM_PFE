package com.example.demo.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.joda.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
	    private String accountNumberExtern;
	    private int statut;
	    private String portfolioDescription;
	    private BigDecimal applyAmountTotal;
	    private String applyDate;
	    private BigDecimal approvelAmount;
	    private BigDecimal apr;
	    private String branchDescription;
	    private String loanApplicationStatus;
	    private String productDescription;
	    private String loanReasonDescription;
		private Long idIbLoan;
		private String date;
		public LoanDTO(String accountNumberExtern, int statut, String portfolioDescription,
				BigDecimal applyAmountTotal, Date applyDate, BigDecimal approvelAmount,
				BigDecimal apr, String branchDescription, String loanApplicationStatus,
				String productDescription, String loanReasonDescription, Long idIbLoan,
				Date date) {

			super();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			this.accountNumberExtern = accountNumberExtern;
			this.statut = statut;
			this.portfolioDescription = portfolioDescription;
			this.applyAmountTotal = applyAmountTotal;
			this.applyDate = dateFormat.format(applyDate);
			this.approvelAmount = approvelAmount;
			this.apr = apr;
			this.branchDescription = branchDescription;
			this.loanApplicationStatus = loanApplicationStatus;
			this.productDescription = productDescription;
			this.loanReasonDescription = loanReasonDescription;
			this.idIbLoan = idIbLoan;
			this.date = (new LocalDate()).toString("yyyy-MM-dd");
		}
		

}