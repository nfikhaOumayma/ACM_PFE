package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.rep.*;
import com.example.demo.service.IACMService;

@RestController
@RequestMapping("v2/api-docs")
public class ACMController {
	
	@Autowired
	public IACMService s;
	
	@Autowired
	public LoanRepository lrep;
	@Autowired
	public CollectionRepository crep;

	@GetMapping("/Allindex")
    public String Createindex() {
            s.indexObjects(crep.getCollections(), "acmcollection");
            s.indexObjects(lrep.loanIndex(), "loans");
            return "Indexing successful";
    }
	

	/*@GetMapping("/totalLoans")
	public ResponseEntity<Void> getLoans() {

		s.IndexTotalLoan();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/collection")
	public ResponseEntity<Void> getCollections() {

		s.IndexCollection();
		return ResponseEntity.ok().build();
	}*/
	
	


}


