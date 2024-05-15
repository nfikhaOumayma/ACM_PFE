package com.example.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor@Entity
@Table(name = "ACM_ITEM")
public class Item  implements Serializable {
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_ITEM", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ELEMENT_ID")
	private Long elementId;
	
	/** The generic work flow object.*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ACM_GENERIC_WORKFLOW_OBJECT")
	private GenericWorkFlowObject genericWorkFlowObject; 

	/** The branches. */
	@Column(name = "ACCESS_BRANCHE")
	private String branches;

	/** The status. */
	@Column(name = "STATUS")
	private Integer status;

	/** The actual step. */
	@Column(name = "ID_ACM_INSTANCE_ITEM_ACTUAL_STEP")
	private Long actualStepInstance;

	/** The actual step. */
	@Column(name = "ID_ACTUAL_STEP_WF")
	private Long actualStep;

	/** The item instances. 
	@OneToMany(mappedBy = "item")
	private Set<ItemInstance> itemInstances = new HashSet<>();*/

	/** The review from step. */
	@Column(name = "REVIEW_FROM_STEP")
	private Long reviewFromStep;

	/** The owner. */
	@Column(name = "OWNER")
	private String owner;

	/** The owner name. */
	@Column(name = "OWNER_NAME")
	private String ownerName;

	/** The owner email. */
	@Column(name = "OWNER_EMAIL")
	private String ownerEmail;

	/** The portfolio id. */
	@Column(name = "PORTFOLIO_ID")
	private Long portfolioId;

	/** The group owner name. */
	@Column(name = "GROUP_OWNER_NAME")
	private String groupOwnerName;

	/** The group owner. */
	@Column(name = "GROUP_OWNER")
	private String groupOwner;
	
	/** The group owner. */
	@Column(name = "Category")
	private String category;
}