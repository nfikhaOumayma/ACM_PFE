package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.rep.CalendarEventRepository;
import com.example.demo.rep.CollectionRepository;
import com.example.demo.rep.LoanRepository;

@Component
public class ChronService {

	private final IACMService acmService;
	private final LoanRepository loanrep;
	private final CollectionRepository collectionrep;
	private final CalendarEventRepository calenderEvent;

	public ChronService(IACMService acmService, LoanRepository loanrep,
			CollectionRepository collectionrep, CalendarEventRepository calenderEvent) {

		super();
		this.acmService = acmService;
		this.loanrep = loanrep;
		this.collectionrep = collectionrep;
		this.calenderEvent = calenderEvent;
	}

	@Scheduled(fixedRate = 24 * 60 * 60 * 1000) // 24 h
	public void startChronometer() {

		System.out.println("Scheduled task started at: " + LocalDateTime.now());

		acmService.indexObjects(loanrep.loanIndex(), "loans");
		acmService.indexObjects(collectionrep.getCollections(), "acmcollection");
		acmService.indexObjects(calenderEvent.getCalendarEvents(), "acmclenderevent");
		acmService.indexObjects(collectionrep.CustomerCollectionDetails(), "customer_collection_details");
		acmService.indexObjects(collectionrep.LegalCollectionDetails(),"legal_collection_details_index");
		System.out.println("Indexing job executed successfully.");
	
		acmService.findBycollaborateur("00153");
		
		
		// acmService.IndexTotalLoan();
		// acmService.Indexation("loans", () -> loanrep.loanIndex());


		
	}

}
