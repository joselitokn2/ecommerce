package com.wirtz.ecommerce.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @PropertySource: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html
 * @EnableTransactionManagement: 
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html
 *
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.wirtz.ecommerce")
public class AppContext {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dataSource = new JndiDataSourceLookup();
		dataSource.setResourceRef(true);
		return dataSource.getDataSource("jdbc/Ecommerce");
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.wirtz.ecommerce.model");
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
				environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		// https://hibernate.atlassian.net/browse/HHH-11722

		// TODO: remove
		System.out.println("############# " + environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		System.out.println("############# " + environment.getRequiredProperty("hibernate.dialect"));
		System.out.println("############# " + environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

//		hibernateProperties.setProperty("hibernate.legacy_limit_handler",
//				environment.getRequiredProperty("hibernate.legacy_limit_handler"));
		return hibernateProperties;
	}

}
