package hiber.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Конфигурационный класс Spring.
 * Отвечает за настройку:
 * - источника данных (DataSource),
 * - SessionFactory (Hibernate),
 * - менеджера транзакций.
 * Аннотация @PropertySource для подключения внешнего файла конфигурации db.properties.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "hiber")
@PropertySource("classpath:db.properties")
public class AppConfig {

   private final Environment env;

   public AppConfig(Environment env) {
      this.env = env;
   }

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource ds = new DriverManagerDataSource();
      ds.setDriverClassName(env.getProperty("db.driver"));
      ds.setUrl(env.getProperty("db.url"));
      ds.setUsername(env.getProperty("db.username"));
      ds.setPassword(env.getProperty("db.password"));
      return ds;
   }

   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
      sf.setDataSource(dataSource());
      sf.setPackagesToScan("hiber.model");
      Properties hibernateProps = new Properties();
      hibernateProps.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
      hibernateProps.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      hibernateProps.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
      sf.setHibernateProperties(hibernateProps);
      return sf;
   }

   @Bean
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      return new HibernateTransactionManager(sessionFactory);
   }
}
