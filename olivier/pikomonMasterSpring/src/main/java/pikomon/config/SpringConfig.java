package pikomon.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"pikomon.dao"})
public class SpringConfig {

	// Definition la base de donnee
	// DataSource
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// dataSource.setUsername("root");
		// dataSource.setPassword("");
		// dataSource.setUrl("jdbc:mysql://localhost:3306/pikomon?serverTimezone=Europe/Paris");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/pikomon");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		return dataSource;
	}

	// Configuration de l'EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		// definition des packages contenant des entites
		emf.setPackagesToScan("pikomon.model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProperties = new Properties();
		// jpaProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQL5InnoDBDialect");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.format_sql", "true");
		emf.setJpaProperties(jpaProperties);
		return emf;
	}

	// transactionManager =>Aspect pour la gestion des transactions
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
