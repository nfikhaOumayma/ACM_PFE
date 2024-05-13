package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;
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

	public <T> void Indexation(String indexName, LoansRetriever<T> retriever) {

	    IndexCoordinates indexCoordinates = IndexCoordinates.of(indexName);

	    // Vérifier si l'index existe
	    IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(indexCoordinates);
	    boolean indexExists = indexOperations.exists();

	    // Récupérer les nouvelles données
	    List<T> newData = retriever.retrieveData();

	    // ajouter les nouveaux données
	    elasticsearchRestTemplate.save(newData, indexCoordinates);

	    if (indexExists) {
	        System.out.println(indexName + " updated with new data : "+ newData.size() + " Records added");
	    } else {
	        System.out.println("New index " + indexName + " created with data : "+ newData.size() + " Records added");
	    }
	}



}

