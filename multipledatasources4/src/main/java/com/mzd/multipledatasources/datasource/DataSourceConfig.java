package com.mzd.multipledatasources.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration //该注解类似于spring配置文件
@MapperScan(basePackages = "com.mzd.multipledatasources.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {
	
	 @Autowired
	 private Environment env;
	 
	/**
	 * 
	* @Title: getDateSource1
	* @Description: 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
	* @param @return    参数
	* @return DataSource    返回类型
	* @throws
	 */
	@Primary
	@Bean(name = "test1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test1")
	public DataSource getDateSource1() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 
	* @Title: getDateSource2
	* @Description: 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
	* @param @return    参数
	* @return DataSource    返回类型
	* @throws
	 */
	@Bean(name = "test2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test2")
	public DataSource getDateSource2() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 
	* @Title: DataSource
	* @Description: @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
	*               @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
	* @param @param test1DataSource
	* @param @param test2DataSource
	* @param @return    参数
	* @return DynamicDataSource    返回类型
	* @throws
	 */
	@Bean(name = "dynamicDataSource")
	public DynamicDataSource DataSource(@Qualifier("test1DataSource") DataSource test1DataSource,
			@Qualifier("test2DataSource") DataSource test2DataSource) {
		Map<Object, Object> targetDataSource = new HashMap<>();
		targetDataSource.put(DataSourceType.DataBaseType.TEST01, test1DataSource);
		targetDataSource.put(DataSourceType.DataBaseType.TEST02, test2DataSource);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSource);// 该方法是AbstractRoutingDataSource的方法
		dataSource.setDefaultTargetDataSource(test1DataSource);// 默认的datasource设置为myTestDbDataSource
		return dataSource;
	}

	/**
	 * 
	* @Title: test1SqlSessionFactory
	* @Description: 根据数据源创建SqlSessionFactory
	* @param @param dynamicDataSource
	* @param @return
	* @param @throws Exception    参数
	* @return SqlSessionFactory    返回类型
	* @throws
	 */
	@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);// 指定数据源(这个必须有，否则报错)
		 // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
		//bean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
		return bean.getObject();
	}
	
    
    /**
     * 
    * @Title: transactionManager
    * @Description: 配置事务管理器
    * @param @param dataSource
    * @param @return
    * @param @throws Exception    参数
    * @return DataSourceTransactionManager    返回类型
    * @throws
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


}
