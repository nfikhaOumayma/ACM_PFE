package com.example.demo.service;

import java.util.List;

@FunctionalInterface
interface LoansRetriever<T> {
    List<T> retrieveData();
}