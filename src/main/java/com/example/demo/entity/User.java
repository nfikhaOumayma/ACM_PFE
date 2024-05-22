package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACM_USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1083246912484526667L;

	/** The username. */
	@Id
	@Column(name = "USERNAME", unique = true, nullable = false, length = 256)
	private String username;

	/** The account portfolio id. */
	@Column(name = "ACCOUNT_PORTFOLIO_ID", nullable = false)
	private Long accountPortfolioId;

	/** The responsable id. */
	@Column(name = "RESPONSABLE_ID")
	private String responsableId;

	/** The user extern id. */
	@Column(name = "USER_EXTERN_ID", nullable = false)
	private Long userExternId;

	/** The user profil id. */
	@Column(name = "USER_PROFIL_ID", nullable = false)
	private Long userProfilId;

	/** The password. */
	@Column(name = "PASSWORD", nullable = false, length = 256)
	private String password;

	/** The nom. */
	@Column(name = "SUR_NAME")
	private String nom;

	/** The prenom. */
	@Column(name = "NAME")
	private String prenom;

	/** The email. */
	@Column(name = "EMAIL")
	private String email;

	/** The branchID. */
	@Column(name = "BRANCHID")
	private Integer branchID;

	/** The branch name. */
	@Column(name = "BRANCHE_NAME", length = 50)
	private String branchName;

	/** The branch description. */
	@Column(name = "BRANCHE_DESCRIPTION", length = 200)
	private String branchDescription;

	/** The id customer. */
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	/** The access branches. */
	@Column(name = "ACCESS_BRANCHES")
	private String accessBranches;

	/** The temporary pwd. */
	@Column(name = "TEMPORARY_PWD")
	private Boolean temporaryPwd;

	/** The category : {@link UserCategory} ENUMS. */
	@Column(name = "CATEGORY")
	private String category;

	/** The defaultLang : {@link UserLangValues} ENUMS. */
	@Column(name = "DEFAULT_LANG")
	private String defaultLang;

	/** The token. */
	@Transient
	private String token;

	/** The portfolio name. */
	@Column(name = "PORTFOLIO_NAME")
	private String portfolioName;

	/** The groupes. 
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ACM_USERS_GROUPE", joinColumns = {@JoinColumn(name = "USERNAME")},
			inverseJoinColumns = {@JoinColumn(name = "ID_ACM_GROUPE")})
	private Set<Groupe> groupes = new HashSet<>();*/
	
	/** The hiring date. */
	@Column(name = "HIRING_DATE")
	private Date hiringDate;

	/** The resigning date. */
	@Column(name = "RESIGNING_DATE")
	private Date resigningDate;

	/** The temporary responsable. */
	@Column(name = "TEMPORARY_RESPONSABLE")
	private Boolean temporaryResponsable;

	/** The old responsible id. */
	@Column(name = "OLD_RESPONSABLE_ID")
	private String oldResponsibleId;

	/** The old responsable name. */
	@Column(name = "OLD_RESPONSABLE_NAME")
	private String oldResponsableName;

	/** The employee id. */
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;

	/** The failed attempts. */
	@Column(name = "FAILED_ATTEMPTS")
	private Integer failedAttempts;

	/** The pwd expiry date. */
	@Column(name = "PWD_EXPIRY_DATE")
	private Date pwdExpiryDate;

	@Override
	public String toString() {

		return "User [username=" + username + ", accountPortfolioId=" + accountPortfolioId
				+ ", responsableId=" + responsableId + ", userExternId=" + userExternId
				+ ", userProfilId=" + userProfilId + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", email=" + email + ", branchID=" + branchID
				+ ", branchName=" + branchName + ", branchDescription=" + branchDescription
				+ ", customerId=" + customerId + ", accessBranches=" + accessBranches
				+ ", temporaryPwd=" + temporaryPwd + ", category=" + category + ", defaultLang="
				+ defaultLang + ", token=" + token + ", portfolioName=" + portfolioName
				+ ", hiringDate=" + hiringDate + ", resigningDate=" + resigningDate
				+ ", temporaryResponsable=" + temporaryResponsable + ", oldResponsibleId="
				+ oldResponsibleId + ", oldResponsableName=" + oldResponsableName + ", employeeId="
				+ employeeId + ", failedAttempts=" + failedAttempts + ", pwdExpiryDate="
				+ pwdExpiryDate + "]";
	}
	
	

	/** The acm conditionnal approves. 
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<AcmConditionnalApprove> acmConditionnalApproves = new HashSet<>();*/

}
