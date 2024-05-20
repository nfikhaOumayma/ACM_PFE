package com.example.demo.dto;

import java.math.BigDecimal;

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
public class CollectionDTO {
	private Long id;

	private String typeCustomer;

	private Long customerIdExtern;

	private String accountNumber;

	private String productDescription;

	private String customerName;

	private String branchDescription;

	private BigDecimal amount;

	private String loanOfficer;
	
	@Field(type = FieldType.Date)
	private Date firstUnpaidInstallment;
	
	private BigDecimal Paid_Amount;

	private BigDecimal unpaidAmount;

	private Integer lateDays;

	private Integer numberOfUnpaidInstallment;

	private Integer status;

	private Long idAcmCollectionStep;

	private Long productId;

	private Long branchId;

	private String currencySymbol;

	private Integer currencyDecimalPlaces;

	private Integer idLoanExtern;
	
	@Field(type = FieldType.Date)
	private Date availableDate;

	private String owner;

	private String ownerName;

	private String groupOwner;

	private String groupOwnerName;

	private String collectionType;

	private Long idParentCollection;

	private String statutLibelle;

	private String statutLibelleDone;

	private String statutWorkflow;

	private String date;

	public CollectionDTO(Long id, String typeCustomer, Long customerIdExtern, String accountNumber,
			String productDescription, String customerName, String branchDescription,
			BigDecimal amount, String loanOfficer, Date firstUnpaidInstallment, BigDecimal Paid_Amount,
			BigDecimal unpaidAmount, Integer lateDays, Integer numberOfUnpaidInstallment,
			Integer status, Long idAcmCollectionStep, Long productId, Long branchId,
			String currencySymbol, Integer currencyDecimalPlaces, Integer idLoanExtern,
			Date availableDate, String owner, String ownerName, String groupOwner,
			String groupOwnerName, String collectionType, Long idParentCollection,
			String statutLibelle, String statutLibelleDone, String statutWorkflow, Date date) {

		super();

		this.id = id;
		this.typeCustomer = typeCustomer;
		this.customerIdExtern = customerIdExtern;
		this.accountNumber = accountNumber;
		this.productDescription = productDescription;
		this.customerName = customerName;
		this.branchDescription = branchDescription;
		this.amount = amount;
		this.loanOfficer = loanOfficer;
		this.firstUnpaidInstallment = firstUnpaidInstallment;
		this.Paid_Amount=Paid_Amount;
		this.unpaidAmount = unpaidAmount;
		this.lateDays = lateDays;
		this.numberOfUnpaidInstallment = numberOfUnpaidInstallment;
		this.status = status;
		this.idAcmCollectionStep = idAcmCollectionStep;
		this.productId = productId;
		this.branchId = branchId;
		this.currencySymbol = currencySymbol;
		this.currencyDecimalPlaces = currencyDecimalPlaces;
		this.idLoanExtern = idLoanExtern;
		this.availableDate = availableDate;
		this.owner = owner;
		this.ownerName = ownerName;
		this.groupOwner = groupOwner;
		this.groupOwnerName = groupOwnerName;
		this.collectionType = collectionType;
		this.idParentCollection = idParentCollection;
		this.statutLibelle = statutLibelle;
		this.statutLibelleDone = statutLibelleDone;
		this.statutWorkflow = statutWorkflow;
		this.date = (new LocalDate()).toString("yyyy-MM-dd");
	}

}
