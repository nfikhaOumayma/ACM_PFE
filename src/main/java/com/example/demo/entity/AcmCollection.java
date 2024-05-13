package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACM_COLLECTION")
public class AcmCollection implements Serializable {

	private static final long serialVersionUID = 1633108725945267561L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_COLLECTION", unique = true, nullable = false)
	private Long id;

	@Column(name = "CUSTOMER_TYPE", nullable = false)
	private String typeCustomer;

	@Column(name = "CUSTOMER_ID_EXTERN", nullable = false)
	private Long customerIdExtern;

	@Column(name = "ACCOUNT_NUMBER", nullable = false, length = 256)
	private String accountNumber;

	@Column(name = "PRODUCT_DESCRIPTION", nullable = false, length = 512)
	private String productDescription;

	@Column(name = "CUSTOMER_NAME", nullable = false, length = 512)
	private String customerName;

	@Column(name = "BRANCH_DESCRIPTION", nullable = false, length = 256)
	private String branchDescription;

	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount;

	@Column(name = "LOAN_OFFICER", length = 50)
	private String loanOfficer;

	@Column(name = "FIRST_UNPAID_INSTALLMENT", nullable = false)
	private Date firstUnpaidInstallment;

	@Column(name = "UNPAID_AMOUNT", nullable = false)
	private BigDecimal unpaidAmount;

	@Column(name = "LATE_DAYS", nullable = false)
	private Integer lateDays;

	@Column(name = "NUMBER_OF_UNPAID_INSTALLMENT", nullable = false)
	private Integer numberOfUnpaidInstallment;

	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "ID_ACM_COLLECTION_STEP", nullable = false)
	private Long idAcmCollectionStep;

	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	@Column(name = "BRANCH_ID", nullable = false)
	private Long branchId;

	@Column(name = "CURRENCY_SYMBOL")
	private String currencySymbol;

	@Column(name = "CURRENCY_DECIMALPLACES")
	private Integer currencyDecimalPlaces;

	@Column(name = "ID_LOAN_EXTERN")
	private Integer idLoanExtern;

	@Column(name = "AVAILABLE_DATE")
	private Date availableDate;

	@Column(name = "COLLECTION_OWNER")
	private String owner;

	@Column(name = "COLLECTION_OWNER_NAME")
	private String ownerName;

	@Column(name = "GROUP_OWNER")
	private String groupOwner;

	@Column(name = "GROUP_OWNER_NAME")
	private String groupOwnerName;

	@Column(name = "COLLECTION_TYPE")
	private String collectionType;

	@Column(name = "ID_PARENT_COLLECTION")
	private Long idParentCollection;

	@Column(name = "STATUT_LIBELLE")
	private String statutLibelle;

	@Column(name = "STATUT_LIBELLE_DONE")
	private String statutLibelleDone;

	@Column(name = "STATUT_WORKFLOW")
	private String statutWorkflow;

}
