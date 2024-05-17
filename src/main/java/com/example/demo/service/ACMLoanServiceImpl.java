package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import com.example.demo.rep.*;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ACMLoanServiceImpl implements ACMLoanService {

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;

	@Autowired
	public CollectionRepository Crep;

	
	/*public <T> void Indexation(String indexeName, LoansRetriever<T> retriever) {

				  // Obtenez les données à indexer à partir du récupérateur
	    List<T> dataToIndex = retriever.retrieveData();

	    // Indexer chaque élément dans Elasticsearch
	    IndexCoordinates indexCoordinates = IndexCoordinates.of(indexeName);
	    for (T data : dataToIndex) {
	        elasticsearchRestTemplate.save(data, indexCoordinates);
	    }	
	}*/
	
	@Override
	public <T> void Indexation(String indexName, LoansRetriever<T> retriever) {

	    IndexCoordinates indexCoordinates = IndexCoordinates.of(indexName);

	    IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);
	    
	    boolean indexExists = indexOperations.exists();

	    List<T> newData = retriever.retrieveData();


	    if (indexExists) {
    	    elasticsearchRestTemplate.save(newData, indexCoordinates);
	        System.out.println(indexName + " updated with new data : "+ newData.size() + " Records added");
	    } else {
			indexOperations.create();
    	    elasticsearchRestTemplate.save(newData, indexCoordinates);
	        System.out.println("New index " + indexName + " created with data : "+ newData.size() + " Records added");
	    }
	}
	
	
	



}

