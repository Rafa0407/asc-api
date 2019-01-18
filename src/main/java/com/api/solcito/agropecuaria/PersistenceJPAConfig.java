package com.api.solcito.agropecuaria;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*
 * Archivo de configuracion para JPA, ya que las configuraciones predeterminadas fueron deshablitadas 
 * Se agregan los parametros de la BD y los paquetes que la aplicacion debe scanear para ser incluidas en la API 
 * Algunas propiedades para hibernate tambien fueron agregadas
 * */
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig{
 
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] { 
    		  "com.api.solcito.agropecuaria.empleados", 
    		  "com.api.solcito.agropecuaria.reporteDiario", 
    		  "com.api.solcito.agropecuaria.reporteSemanal"
      });
 
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());
 
      return em;
   }
 
   @Bean
   public DataSource dataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/empleados_asc");
      dataSource.setUsername( "root" );
      dataSource.setPassword( "s" );
      return dataSource;
   }
 
   @Bean
   public PlatformTransactionManager transactionManager(
     EntityManagerFactory emf){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf);
 
       return transactionManager;
   }

 
   Properties additionalProperties() {
       Properties properties = new Properties();
       properties.setProperty(
         "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");  
       properties.setProperty("useSSL", "false"); 
       properties.setProperty("hibernate.id.new_generator_mappings","false");
       properties.setProperty("hibernate.jdbc.time_zone", "UTC");
       return properties;
   }
}