package com.mzd.multipledatasources.config;

/**
 * Created by pure on 2018-05-06.
 */
public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final DatabaseType DEFAULT_DS = DatabaseType.datasource1;

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(DatabaseType dbType) {
        System.out.println("切换到{"+dbType+"}数据源");
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static DatabaseType getDB() {
    	System.out.println("获取到{"+contextHolder.get()+"}数据源");
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}

