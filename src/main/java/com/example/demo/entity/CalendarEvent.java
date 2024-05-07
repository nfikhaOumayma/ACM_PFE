package com.example.demo.entity;
import java.io.Serializable;
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
@Table(name = "ACM_CALENDAR_EVENT")
public class CalendarEvent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_CALENDAR_EVENT", unique = true, nullable = false)
	private Long id;

	/** The Date debut. */
	@Column(name = "DATE_DEBUT", nullable = false)
	private Date dateDebut;

	/** The Date fin. */
	@Column(name = "DATE_FIN", nullable = false)
	private Date dateFin;

	/** The type event. */
	@Column(name = "TYPE_EVENT", nullable = false)
	private String typeEvent;

	/** The libelle event. */
	@Column(name = "LIBELLE_EVENT", nullable = false)
	private String libelleEvent;

	/** The Description event. */
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	/** The username. */
	@Column(name = "USERNAME", nullable = false)
	private String username;

	/** The name of customer. */
	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customerName;

	/** The phone number. */
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumer;

	/** The place. */
	@Column(name = "PLACE", nullable = false)
	private String place;

	/** The statut. */
	@Column(name = "STATUT", nullable = false)
	private String statut;

	/** The participant. */
	@Column(name = "PARTICIPANT", nullable = false)
	private String participant;

	/** The id loan extern. */
	@Column(name = "ID_LOAN_EXTERN")
	private Long idLoanExtern;

	/** The id collection. */
	@Column(name = "ACM_ID_COLLECTION")
	private Long idCollection;

	/** The id claim. */
	@Column(name = "ACM_ID_CLAIM")
	private Long idClaim;

	/** The category. */
	@Column(name = "CATEGORY", nullable = false)
	private String category;

	/** The step name. */
	@Column(name = "STEP_NAME")
	private String stepName;

	/** The user full name. */
	@Column(name = "USER_FULL_NAME")
	private String userFullName;

	/** The acm customer id. */
	@Column(name = "ID_CUSTOMER_EXTERN")
	private Long idCustomerExtern;

	/** The id item. */
	@Column(name = "ID_ACM_ITEM")
	private Long idItem;

	/** The id item. */
	@Column(name = "DATE_LAST_UPDATE")
	private Date dateLastUpdate;
}
