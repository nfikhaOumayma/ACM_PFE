package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.entity.User;

public interface IACMService {

	//public <T> void Indexation(String indexeName, LoansRetriever<T> retriever);
	//public void IndexTotalLoan();
	//void IndexCollection();
	public <T> void indexObjects(List<T> objects, String indexName);
	public List<User> findBycollaborateur(String responsableId) ;

}
