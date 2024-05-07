package com.example.demo.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.LoanDTO;
import com.example.demo.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	

    @Query(value = "SELECT new com.example.demo.dto.LoanDTO(l.accountNumberExtern, "
            + "statut , l.portfolioDescription, l.applyAmountTotal,"
            + "l.applyDate, l.approvelAmount, l.apr, l.branchDescription, l.loanApplicationStatus,"
            + "l.productDescription, l.loanReasonDescription, l.idIbLoan ,GETDATE())"
            + " FROM Loan l")
    List<LoanDTO> loanIndex();
	
	

}
