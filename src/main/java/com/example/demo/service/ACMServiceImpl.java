package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.*;

import com.example.demo.rep.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ACMServiceImpl implements IACMService {

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	@Autowired
	UserRepository  userRep;
	
	
	@Override
	public <T> void indexObjects(List<T> newData, String indexName) {

		IndexCoordinates indexCoordinates = IndexCoordinates.of(indexName);
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			indexOperations.create();
			elasticsearchRestTemplate.save(newData, indexCoordinates);
			System.out.println("New index " + indexName + " created with data : " + newData.size()
					+ " Records added");
		}
		else {
			elasticsearchRestTemplate.save(newData, indexCoordinates);
			System.out.println(
					indexName + " updated with new data : " + newData.size() + " Records added");
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findBycollaborateur(String responsableId) {

		List<User> listCollaborateur= userRep.findByResponsableId(responsableId);
		System.out.println("voila la liste des utilisateur qui ont comme responsable"+responsableId);
		 for (User user : listCollaborateur) {
		        System.out.println(user);
		    }
		return listCollaborateur;
		
	}
	
	/*@Autowired
	private CollectionRepository crep;
	private LoanRepository lrep;

	@Override
	public void IndexTotalLoan() {

		List<LoanDTO> newData = lrep.loanIndex();

		IndexCoordinates indexCoordinates = IndexCoordinates.of("loans");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			indexOperations.create();
			elasticsearchRestTemplate.save(newData, indexCoordinates);
			System.out.println("new Index loans created with newData "+newData.size()+"records");
		}
		else {
			elasticsearchRestTemplate.save(newData, indexCoordinates);
			System.out.println(" loans created with newData" +newData.size()+"records");
		}		
	} 
	@Override
	public void IndexCollection() {

		List<CollectionDTO> newData = crep.getCollections();

		IndexCoordinates indexCoordinates = IndexCoordinates.of("acmcollection");
		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);

		if (!indexOperations.exists()) {
			indexOperations.create();
			elasticsearchRestTemplate.save(newData, indexCoordinates);
			System.out.println("new Index acmcollection created with newData "+newData.size()+"records");
		}
		else {
			elasticsearchRestTemplate.save(newData, indexCoordinates);
			System.out.println(" acmcollection created with newData" +newData.size()+"records");
		}
	}*/

	
	
	

	
	
	/*
	 * public <T> void Indexation(String indexeName, LoansRetriever<T> retriever) { // Obtenez les
	 * données à indexer à partir du récupérateur List<T> dataToIndex = retriever.retrieveData(); //
	 * Indexer chaque élément dans Elasticsearch IndexCoordinates indexCoordinates =
	 * IndexCoordinates.of(indexeName); for (T data : dataToIndex) {
	 * elasticsearchRestTemplate.save(data, indexCoordinates); } }
	 */

	/*
	 * @Override public <T> void Indexation(String indexName, LoansRetriever<T> retriever) {
	 * IndexCoordinates indexCoordinates = IndexCoordinates.of(indexName); IndexOperations
	 * indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates); boolean indexExists =
	 * indexOperations.exists(); List<T> newData = retriever.retrieveData(); if (indexExists) {
	 * elasticsearchRestTemplate.save(newData, indexCoordinates); System.out.println( indexName +
	 * " updated with new data : " + newData.size() + " Records added"); } else {
	 * indexOperations.create(); elasticsearchRestTemplate.save(newData, indexCoordinates);
	 * System.out.println("New index " + indexName + " created with data : " + newData.size() +
	 * " Records added"); } } // method 2
	 * @Override public void IndexCollection() { List<CollectionDTO> newData =
	 * Crep.getCollections(); IndexCoordinates indexCoordinates = IndexCoordinates.of("collection");
	 * IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates); if
	 * (!indexOperations.exists()) { indexOperations.create();
	 * elasticsearchRestTemplate.save(newData, indexCoordinates);
	 * System.out.println("Index created"); } else { elasticsearchRestTemplate.save(newData,
	 * indexCoordinates); System.out.println("Index updated with new data"); } }
	 * @Override public void IndexTotalLoan() { List<LoanDTO> newData = rep.loanIndex();
	 * IndexCoordinates indexCoordinates = IndexCoordinates.of("acm_total_loan"); IndexOperations
	 * indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates); if
	 * (!indexOperations.exists()) { indexOperations.create();
	 * elasticsearchRestTemplate.save(newData, indexCoordinates);
	 * System.out.println("Index created"); } else { elasticsearchRestTemplate.save(newData,
	 * indexCoordinates); System.out.println("Index updated with new data"); } }
	 */

	// method 3

}
