package com.example.demo.service;

public interface ACMLoanService {

	public <T> void Indexation(String indexeName, LoansRetriever<T> retriever);
}
