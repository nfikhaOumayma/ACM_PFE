package com.example.demo.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.*;
import com.example.demo.entity.*;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	
	@Query( value ="SELECT new com.example.demo.dto.LoanDTO("
			+ "l.accountNumberExtern, "
			+ "CASE " 
				+ "    WHEN l.statut = 1 THEN 'NEW' " 
				+ "    WHEN l.statut = 2 THEN 'DRAFT' "
				+ "    WHEN l.statut = 3 THEN 'Pending approval' "
				+ "    WHEN l.statut = 4 THEN 'approved' " 
				+ "    WHEN l.statut = 5 THEN 'Rejected' "
				+ "    WHEN l.statut = 6 THEN 'Canceled' " 
				+ "    WHEN l.statut = 7 THEN 'Review' "
				+ "    WHEN l.statut = 8 THEN 'Issued' " 
			+ "END AS statut, "
			+ "CASE "
			+ "			WHEN l.readyForDisb = 1 THEN 'à échoir' "
			+ "			ELSE 'n est pas à échoir' "
			+ "END , " 
			+ "CASE "
			+ "WHEN c.gender = 'F' THEN 'femme' "
			+ "WHEN c.gender = 'M' THEN 'Homme' "
			+ "END , "
			+ "c.customerName, "   
			+ "l.productDescription, "
			+ "l.applyDate, " + "l.portfolioDescription, " + "l.applyAmountTotal, " + "l.approvelAmount, "
			+ "l.loanReasonDescription, " + "l.branchDescription, " + "l.apr, "
			+ "l.loanApplicationStatus ,"
			+ " GETDATE()) " 
			+ "FROM Loan l "
			+ "LEFT JOIN Customer c ON c.id = l.customerId ")
	List<LoanDTO> loanIndex(); 
}
