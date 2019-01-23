package blog.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ComponentScan("blog.database")
public class HibernateConfiguration {
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuilder.addProperties(getProperties());
		localSessionFactoryBuilder.scanPackages("blog.database");
		return localSessionFactoryBuilder.buildSessionFactory();
		
		
	}
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource basicDataSource =new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/blogproject");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		return basicDataSource;
	}
	public Properties getProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		
		return properties;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager()
	{
		
		return new HibernateTransactionManager(getSessionFactory());
	
	}
	

}