package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = {"classpath:dbinfo.properties"})
@ComponentScan(basePackages = {"com.example"})
public class RootConfig {
	@Value("${db.driverClass}")
	private String driverClassName;
	@Value("${db.url}")
	private String jdbcUrl;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(this.driverClassName);
		hikariConfig.setJdbcUrl(this.jdbcUrl);
		hikariConfig.setUsername(this.username);
		hikariConfig.setPassword(password);
		return hikariConfig;
	}
	
	@Bean
	public HikariDataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource(this.hikariConfig());
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(this.dataSource());
		sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(new ClassPathResource("mybatis-mapper.xml"));
		return sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(this.sqlSessionFactory());
		return sqlSession;
	}
	
}
