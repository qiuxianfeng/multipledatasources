package com.mzd.multipledatasources.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
* @ClassName: DynamicDataSource
* @Description: 动态数据源（需要继承AbstractRoutingDataSource）
* @author darren
* @date 2019年2月22日
*
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
		return dataBaseType;
	}

}
