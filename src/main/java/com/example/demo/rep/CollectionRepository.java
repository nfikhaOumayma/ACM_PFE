package com.example.demo.rep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.*;
import com.example.demo.entity.AcmCollection;

@Repository
public interface CollectionRepository extends JpaRepository<AcmCollection, Long> {

	@Query(value = "SELECT new com.example.demo.dto.CollectionDTO(" 
			+ "collection.id, "
			+ "collection.typeCustomer, " 
			+ "collection.customerIdExtern, "
			+ "collection.accountNumber, " 
			+ "collection.productDescription, "
			+ "collection.customerName, " 
			+ "collection.branchDescription, " 
			+ "collection.amount, "
			+ "collection.loanOfficer, " 
			+ "collection.firstUnpaidInstallment, "
	        + "(collection.amount - collection.unpaidAmount), "
			+ "collection.unpaidAmount, " 
			+ "collection.lateDays, "
			+ "collection.numberOfUnpaidInstallment, " 
			+ "collection.status, "
			+ "collection.idAcmCollectionStep, " 
			+ "collection.productId, "
			+ "collection.branchId, " 
			+ "collection.currencySymbol, "
			+ "collection.currencyDecimalPlaces, "
			+ "collection.idLoanExtern, "
			+ "collection.availableDate, " 
			+ "collection.owner, " 
			+ "collection.ownerName, "
			+ "collection.groupOwner, " 
			+ "collection.groupOwnerName, "
			+ "collection.collectionType, " 
			+ "collection.idParentCollection, "
			+ "collection.statutLibelle, " 
			+ "collection.statutLibelleDone, "
			+ "collection.statutWorkflow" 
			+ ",GETDATE()) " 
			+ "FROM AcmCollection collection")
	List<CollectionDTO> getCollections();

	@Query(value = "SELECT new com.example.demo.dto.CustomerCollectionDetailsDTO( " 
			+ "	   c.id, "
			+ "    c.customerName, "
			+ "    c.productDescription, " 
			+ "    c.statutLibelle, " 
			+ "    c.loanOfficer, "
			+ "    c.branchDescription, " 
			+ "    CASE "
			+ "        WHEN c.ownerName IS NULL THEN c.groupOwnerName "
			+ "        ELSE c.ownerName " 
			+ "    END  , " 
			+ "    CASE "
			+ "        WHEN c.status = 0 AND c.statutWorkflow = 'pre-litigation' THEN 'pre-litigation' "
			+ "        WHEN c.status = 0 AND c.statutWorkflow = 'amicably' THEN 'amicably' "
			+ "        WHEN c.status = 1 THEN 'Legal' " 
			+ "        WHEN c.status = -1 THEN 'Paid' "
			+ "    END  , "
			+ "GETDATE()) " 
			+ "FROM AcmCollection c "
			+ "WHERE c.collectionType = 'COLLECTION'")
	List<CustomerCollectionDetailsDTO> CustomerCollectionDetails();

	
	
	@Query(value = "SELECT NEW com.example.demo.dto.LegalCollectionDetailsDTO(" 
		    + "c.id, " 
		    + "c.customerName, "
		    + "c.productDescription, " 
		    + "c.statutLibelle, " 
		    + "c.loanOfficer, " 
		    + "c.branchDescription, "
		    + "CASE " 
		        + "WHEN c.ownerName IS NULL THEN c.groupOwnerName "
		        + "ELSE c.ownerName " 
		    + "END, " 
		    + "CASE "
		        + "WHEN c.status = 0 THEN 'Active' " 
		        + "WHEN c.status = 1 THEN 'Closed' "
		    + "END,"
		    + "gwo.name, GETDATE())" 
		+ "FROM AcmCollection c "
		+ "INNER JOIN Item i ON i.elementId = c.id " 
		+ "INNER JOIN GenericWorkFlowObject gwo ON gwo.id = i.genericWorkFlowObject " 
		+ "WHERE c.collectionType = 'LEGAL' AND i.category = 'LEGAL'")
		List<LegalCollectionDetailsDTO> LegalCollectionDetails();

} 

