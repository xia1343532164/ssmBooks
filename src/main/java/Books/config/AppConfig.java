package Books.config;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages="Books")
@EnableWebMvc
@PropertySource("classpath:jdbc.properties")
@MapperScan("Books.dao.mybatis.mapper") //// 扫描此包下的所有mapper接口并注册实现bean
@EnableTransactionManagement //开启事务
public class AppConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Bean
	public DataSource dataSource(Environment env){
		String url = env.getProperty("jdbc.url");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");
		String driverClass = env.getProperty("jdbc.driver");
		
		DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(driverClass);
		return ds;
	}
	@Bean
	public JdbcTemplate tempalte(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// GET    /assets/bootstrap/css/bootstrap.min.css
				// 资源路径    /public/bootstrap/css/bootstrap.min.css
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
		registry.addResourceHandler("/book-pictures/**").addResourceLocations("file:///E:/upload/");
		
	}
	//文件上传
	@Bean
	public MultipartResolver multipartResolver(){//文件名必须这样写，因为spring mvc会用这个id查找多部解析器
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(10 * 1024 * 1024);//字节
		return mr;
	}
	//mybatis配置
	@Bean
	public SqlSessionFactoryBean  sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sf.setDataSource(dataSource);
		return sf;
	}
	//事务
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
