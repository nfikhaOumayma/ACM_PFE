package com.example.demo.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import com.example.demo.AcmDashboardingApplication;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebMvc
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() throws IOException, XmlPullParserException {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis((java.util.function.Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths((java.util.function.Predicate<String>) PathSelectors.any()).build().apiInfo(apiInfo());
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws XmlPullParserException the xml pull parser exception
	 */
	private ApiInfo apiInfo() throws IOException, XmlPullParserException {

		MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
		Model model;
		if ((new File("pom.xml")).exists()) {
			model = mavenXpp3Reader.read(new FileReader("pom.xml"));
		}
		else {
			// Packaged artifacts contain a META-INF/maven/${groupId}/${artifactId}/pom.properties
			model = mavenXpp3Reader
					.read(new InputStreamReader(AcmDashboardingApplication.class.getResourceAsStream(
							"/Elasticsearch_ACM/pom.xml")));
		}
		return new ApiInfo(" Dashboard for Advanced Credit Management (ACM)", model.getDescription(),
				model.getParent().getVersion(), "Terms of TALYS",
				new Contact("ACM", "www.talys-consulting.com", "info@talys-consulting.com"),
				"License of API", "www.talys-consulting.com", Collections.emptyList());
	}
	@Bean
	public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
	    return new BeanPostProcessor() {

	        @Override
	        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	            if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
	                customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
	            }
	            return bean;
	        }

	        private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
	            List<T> copy = mappings.stream()
	                    .filter(mapping -> mapping.getPatternParser() == null)
	                    .collect(Collectors.toList());
	            mappings.clear();
	            mappings.addAll(copy);
	        }

	        @SuppressWarnings("unchecked")
	        private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
	            try {
	                Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
	                field.setAccessible(true);
	                return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
	            } catch (IllegalArgumentException | IllegalAccessException e) {
	                throw new IllegalStateException(e);
	            }
	        }
	    };
	}


}
