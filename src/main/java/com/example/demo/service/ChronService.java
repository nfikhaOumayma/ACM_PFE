package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.rep.CalendarEventRepository;
import com.example.demo.rep.CollectionRepository;
import com.example.demo.rep.LoanRepository;

@Component
public class ChronService {

	private final ACMLoanService loanService;
	private final LoanRepository Loanrep;
	private final CollectionRepository Collectionrep;
	private final CalendarEventRepository calenderEvent;


 
	public ChronService(ACMLoanService loanService, LoanRepository loanrep,
			CollectionRepository collectionrep, CalendarEventRepository calenderEvent) {

		super();
		this.loanService = loanService;
		Loanrep = loanrep;
		Collectionrep = collectionrep;
		this.calenderEvent = calenderEvent;
	}



	@Scheduled(fixedRate = 24 * 60 * 60 * 1000) // 24 h
	public void startChronometer() {
		System.out.println("Scheduled task started at: " + LocalDateTime.now());

		loanService.Indexation("totalloans", () -> Loanrep.loanIndex());
		loanService.Indexation("acmcollection", () -> Collectionrep.getCollections() );
		loanService.Indexation("calenderevent", () -> calenderEvent.getCalendarEvents());
	}
}
