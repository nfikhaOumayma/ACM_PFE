package com.example.demo.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "Repository.RepositoryElasticSearch")
@ComponentScan(basePackages = {"com.example.Elasticsearch_ACM"})
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

	@Value("${elasticsearch.url}")
	public String elasticsearchUrl;
	
	@Bean
	@Override
	public RestHighLevelClient elasticsearchClient(){
		final ClientConfiguration config = ClientConfiguration.builder()
		.connectedTo(elasticsearchUrl)
		.build();
		return RestClients.create(config).rest();
	}
	
	@Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        final ClientConfiguration configuration = ClientConfiguration.builder()
                .connectedTo(elasticsearchUrl)
                .build();
        return new ElasticsearchRestTemplate(RestClients.create(configuration).rest());
    }
}
