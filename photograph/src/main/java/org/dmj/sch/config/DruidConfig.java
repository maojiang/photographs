package org.dmj.sch.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.dmj.sch.bean.DruidBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by 56821 on 2018/8/12.
 */
@Configuration
public class DruidConfig {
    @Autowired
    DruidBean druidBean;


    @Bean(name="dataSource")
    //因为SpringBoot也为我们提供了一个默认的datasource，可谓贴心，当我们需要自己的连接池的时候，可以使用@primary注解，告诉Springboot
    //优先使用我们自己的DataSource
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidBean.getDriver());
        dataSource.setUrl(druidBean.getUrl());
        dataSource.setUsername(druidBean.getUsername());
        dataSource.setPassword(druidBean.getPassword());
        dataSource.setInitialSize(druidBean.getInitialSize());
        dataSource.setMaxActive(druidBean.getMaxActive());
        dataSource.setMinIdle(druidBean.getMinIdle());
        dataSource.setMaxWait(druidBean.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidBean.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidBean.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druidBean.getValidationQuery());
        dataSource.setTestWhileIdle(druidBean.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidBean.isTestOnBorrow());
        dataSource.setTestOnReturn(druidBean.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druidBean.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidBean.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setUseGlobalDataSourceStat(druidBean.isUseGlobalDataSourceStat());
        try {
            dataSource.setFilters(druidBean.getFilters());
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: "+ e);
        }
        dataSource.setConnectionProperties(druidBean.getConnectionProperties());
        return dataSource;
    }




}
