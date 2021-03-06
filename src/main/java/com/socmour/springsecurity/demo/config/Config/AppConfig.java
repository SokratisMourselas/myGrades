package com.socmour.springsecurity.demo.config.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.socmour.springsecurity.demo")
@PropertySource({ "classpath:persistence-mysql.properties",
        "classpath:security-persistence-mysql.properties" })
public class AppConfig implements WebMvcConfigurer {

    private Logger logger = Logger.getLogger(getClass().getName());

    // defining a bean for ViewResolver
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Autowired
    public Environment env;

    @Bean
    public DataSource myDataSource(){

        ComboPooledDataSource myDataSource = new ComboPooledDataSource();

        try{
            myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
            logger.info(">>>>> jdnc.url = " + env.getProperty("jdbc.url"));
            logger.info(">>>>> jdnc.user = " + env.getProperty("jdbc.user"));

            myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            myDataSource.setUser(env.getProperty("jdbc.user"));
            myDataSource.setPassword(env.getProperty("jdbc.password"));

            myDataSource.setInitialPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.initialPoolSize"))));
            myDataSource.setMinPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.minPoolSize"))));
            myDataSource.setMaxPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.maxPoolSize"))));
            myDataSource.setMaxIdleTime(Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.maxIdleTime"))));


        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        return myDataSource;
    }

    private Properties getHibernateProperties() {
        // set hibernate properties
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        // create session factory
        LocalSessionFactoryBean sessionFactory = new
                LocalSessionFactoryBean();
        // set the properties
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    // define a bean for security data source
    @Bean
    public DataSource securityDataSource() {

        // create connection pool
        ComboPooledDataSource securityDataSource
                = new ComboPooledDataSource();

        // set the jdbc driver class

        try {

            securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        // log the connection props
        // for sanity's sake, log this info
        // just to make sure we are REALLY reading data from properties file

        logger.info(">>> security.jdbc.url=" +
                env.getProperty("security.jdbc.url"));
        logger.info(">>> security.jdbc.user=" +
                env.getProperty("security.jdbc.user"));


        // set database connection props

        securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
        securityDataSource.setUser(env.getProperty("security.jdbc.user"));

        securityDataSource.setPassword(env.getProperty("security.jdbc.password"));

        // set connection pool props

        securityDataSource.setInitialPoolSize(
                getIntProperty("security.connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(
                getIntProperty("security.connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(
                getIntProperty("security.connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(
                getIntProperty("security.connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    
    // need a helper method
    // read environment property and convert to int

    private int getIntProperty(String propName) {

        String propVal = env.getProperty(propName);

        // now convert to int
        assert propVal != null;
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new
                HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }


}
