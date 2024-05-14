package com.example.demo.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.*;
import com.example.demo.entity.*;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	
	@Query(value = "SELECT new com.example.demo.dto.LoanDTO(l.accountNumberExtern, "
			+ "statut , l.portfolioDescription, l.applyAmountTotal,"
			+ "l.applyDate, l.approvelAmount, l.apr, l.branchDescription, l.loanApplicationStatus,"
			+ "l.productDescription, l.loanReasonDescription, l.idIbLoan ,GETDATE())"
			+ " FROM Loan l")
	List<LoanDTO> loanIndex();

	/*@Query("SELECT new com.example.demo.dto.LoanApplicationDetailsDTO(" + "accountNumberExtern, "
			+ "CASE " + "    WHEN statut = 1 THEN 'NEW' " + "    WHEN statut = 2 THEN 'DRAFT' "
			+ "    WHEN statut = 3 THEN 'Pending approval' "
			+ "    WHEN statut = 4 THEN 'approved' " + "    WHEN statut = 5 THEN 'Rejected' "
			+ "    WHEN statut = 6 THEN 'Canceled' " + "    WHEN statut = 7 THEN 'Review' "
			+ "    WHEN statut = 8 THEN 'Issued' " + "END AS statut, " + "productDescription, "
			+ "applyDate, " + "portfolioDescription, " + "applyAmountTotal, " + "approvelAmount, "
			+ "loanReasonDescription, " + "branchDescription, " + "apr, "
			+ "loanApplicationStatus) " + "FROM ACMLoan")
	List<LoanDTO> loanIndex();*/

	/*@Query("SELECT new com.example.demo.dto.CalendarEventDTO(" + "c.eventLabel, " + "c.statut, "
			+ "c.lastUpdateDate, " + "c.endDate, " + "CASE " + "    WHEN c.statut = 'CLOSED' THEN "
			+ "        CASE "
			+ "            WHEN DATEDIFF(day, c.endDate, c.lastUpdateDate) < 0 THEN 0 "
			+ "            ELSE COALESCE(DATEDIFF(day, c.endDate, c.lastUpdateDate), 0) "
			+ "        END " + "    WHEN c.statut = 'NEW' THEN " + "        CASE "
			+ "            WHEN DATEDIFF(day, c.endDate, CURRENT_DATE()) < 0 THEN 0 "
			+ "            ELSE COALESCE(DATEDIFF(day, c.endDate, CURRENT_DATE()), 0) "
			+ "        END " + "END, " + "c.category, " + "CONCAT(u.name, ' ', u.surName), "
			+ "u.brancheDescription) "
			+ "FROM com.example.Elasticsearch_ACM.Entities.ACMCalendarEvent c " + "INNER JOIN "
			+ "     com.example.Elasticsearch_ACM.Entities.ACMUsers u ON c.username = u.username")
	List<CalenderEventDTO> CalendarEvent();*/

	/*@Query("SELECT new com.example.demo.dto.CustomerCollectionDetailsDTO( " + "    c.customerName, "
			+ "    c.productDescription, " + "    c.statusLabel, " + "    c.loanOfficer, "
			+ "    c.branchDescription, " + "    CASE "
			+ "        WHEN c.collectionOwnerName IS NULL THEN c.groupOwnerName "
			+ "        ELSE c.collectionOwnerName " + "    END, " + "    CASE "
			+ "        WHEN c.status = 0 AND c.statusWorkflow = 'pre-litigation' THEN 'pre-litigation' "
			+ "        WHEN c.status = 0 AND c.statusWorkflow = 'amicably' THEN 'amicably' "
			+ "        WHEN c.status = 1 THEN 'Legal' " + "        WHEN c.status = -1 THEN 'Paid' "
			+ "    END, " + "    c.dateInsertion ) " + "FROM ACMCollection c "
			+ "WHERE c.collectionType = 'COLLECTION'")
	List<CustomerCollectionDetailsDTO> CustomerCollectionDetails();*/

	/*
	 * @Query("SELECT new com.example.demo.dto.LegalCollectionDetailsDTO(" + "id, " +
	 * "customerName, " + "productDescription, " + "statusLabel, " + "loanOfficer, " +
	 * "branchDescription, " + "CASE " +
	 * "    WHEN c.collectionOwnerName IS NULL THEN c.groupOwnerName " +
	 * "    ELSE c.collectionOwnerName " + "END, " + "CASE " +
	 * "    WHEN c.status = 0 THEN 'Active' " + "    WHEN c.status = 1 THEN 'Closed' " + "END, " +
	 * "gwo.name, " + "c.dateInsertion) " + "FROM " +
	 * "    com.example.Elasticsearch_ACM.Entities.ACMCollection c, " +
	 * "    com.example.Elasticsearch_ACM.Entities.ACMGenericWorkflowObject gwo " + "INNER JOIN " +
	 * "    com.example.Elasticsearch_ACM.Entities.ACMItem i ON i.id = c.id " + "INNER JOIN " +
	 * "    com.example.Elasticsearch_ACM.Entities.ACMGenericWorkflowObject gwo2 ON gwo2.id = c.id "
	 * + "WHERE c.collectionType = 'LEGAL' AND i.category = 'LEGAL' ")
	 * List<LegalCollectionDetailsDTO> LegalCollectionDetails();
	 */

}
